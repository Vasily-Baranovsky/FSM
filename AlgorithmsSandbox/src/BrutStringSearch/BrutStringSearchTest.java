package BrutStringSearch;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BrutStringSearchTest {
    final int MAX_WORDS_IN_DICTIONARY = 10;
    final int MAX_WORD_LENGTH = 10;
    final int NUMBER_OF_ITERATIONS = 1000;
    final int APPROX_MAX_GENERATED_STRING_LENGTH = 200;
    final double DICTIONARY_WORDS_DENSITY  = 0.5;
//    final char[] arrayOfAllowedCharacters = new char[] {'a', 'b', 'c', 'd', 'e', 'f', '1',}

    @Test
    void searchString() {

        // задать тестовые данные
        // -- задать словарь для поиска
        for (int i = 0; i <= NUMBER_OF_ITERATIONS; i++) {

        }

        // -- задать строку, в которой будем искать
        String testSearchString = "";


        // вызвать тестируемую функцию на тестовых данных

        // протестить странные кейсы
        // написать assert



    }


    private char generateSymbol() {
        return (char)('a' + (int)(Math.random()*27));
    }

    private String generateWord() {
        StringBuilder resultBuilder = new StringBuilder("");

        for(int i = 0; i < MAX_WORD_LENGTH; i++) {
            resultBuilder.append(generateSymbol());
        }

        return resultBuilder.toString();
    }

    private String[] generateDictionary() {
        int actualWordsInDictionary = (int) (Math.random()*MAX_WORDS_IN_DICTIONARY);
        String[] generatedStrings = new String[actualWordsInDictionary];

        for(int i =0; i < actualWordsInDictionary; i++) {
             generatedStrings[i] = generateWord();
        }

        return generatedStrings;
    }


    private void testOneCase(String[] dictionary) {
        HashMap<String, List<Integer>> initialSubstringsMap = new HashMap<>();
        StringBuilder generatedStringBuilder = new StringBuilder("");


        int currentIndex = 0;
        while (generatedStringBuilder.length() < APPROX_MAX_GENERATED_STRING_LENGTH){
            String currentWord = null;
            double possibility = Math.random();

            if (possibility < DICTIONARY_WORDS_DENSITY) {
                int wordIndex = (int)(Math.random()*dictionary.length);
                currentWord = dictionary[wordIndex];
                List<Integer> indexes = initialSubstringsMap.computeIfAbsent(currentWord, k -> new ArrayList<>());
                indexes.add(currentIndex);
            } else {
                currentWord = generateWord();
                String finalCurrentWord = currentWord;
                if (Arrays.stream(dictionary).anyMatch(s -> s.equals(finalCurrentWord))) {
                    continue;
                }
            }

            generatedStringBuilder.append(currentWord);
            currentIndex = currentIndex + currentWord.length();
        }
        //TODO вызвать функцию и проверить, что ее результат совпадает со сгенерированным
    }


}