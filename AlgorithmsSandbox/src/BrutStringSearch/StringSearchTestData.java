package BrutStringSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StringSearchTestData {

    final static int MAX_WORDS_IN_DICTIONARY = 10;
    final static int MAX_WORD_LENGTH = 10;
    final static int APPROX_MAX_GENERATED_STRING_LENGTH = 200;
    final static double DICTIONARY_WORDS_DENSITY  = 0.5;
    String[] dictionary;
    String searchString;
    HashMap<String, List<Integer>> substringsMap;

    private StringSearchTestData() {

    }


    private static char generateSymbol() {
        return (char)('a' + (int)(Math.random()*27));
    }

    private static String generateWord() {
        StringBuilder resultBuilder = new StringBuilder("");

        for(int i = 0; i < MAX_WORD_LENGTH; i++) {
            resultBuilder.append(generateSymbol());
        }

        return resultBuilder.toString();

    }

    private static String[] generateDictionary() {
        int actualWordsInDictionary = (int) (Math.random()*(MAX_WORDS_IN_DICTIONARY - 1)) +1;
        String[] generatedStrings = new String[actualWordsInDictionary];

        for(int i =0; i < actualWordsInDictionary; i++) {
            generatedStrings[i] = generateWord();
        }

        return generatedStrings;
    }

    public static StringSearchTestData generateTestData() {
        StringSearchTestData testData = new StringSearchTestData();
        testData.dictionary = generateDictionary();

        HashMap<String, List<Integer>> substringsMap = new HashMap<>();
        StringBuilder generatedStringBuilder = new StringBuilder("");


        int currentIndex = 0;
        while (generatedStringBuilder.length() < APPROX_MAX_GENERATED_STRING_LENGTH){
            String currentWord = null;
            double possibility = Math.random();

            if (possibility < DICTIONARY_WORDS_DENSITY) {
                int wordIndex = (int)(Math.random()*testData.dictionary.length);
                currentWord = testData.dictionary[wordIndex];
                List<Integer> indexes = substringsMap.computeIfAbsent(currentWord, k -> new ArrayList<>());
                indexes.add(currentIndex);
            } else {
                currentWord = generateWord();
                String finalCurrentWord = currentWord;
                if (Arrays.stream(testData.dictionary).anyMatch(s -> s.equals(finalCurrentWord))) {
                    continue;
                }
            }

            generatedStringBuilder.append(currentWord);
            currentIndex = currentIndex + currentWord.length();
        }

        testData.searchString = generatedStringBuilder.toString();
        testData.substringsMap = substringsMap;

        return testData;
    }
}
