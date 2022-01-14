package BrutStringSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class BrutWithHypothesisSearcherTest {
    //TODO сделать тестовые данные для тестирования глазами
    final int NUMBER_OF_ITERATIONS = 1000;
    final static double DICTIONARY_WORDS_DENSITY  = 0.5;

//    final char[] arrayOfAllowedCharacters = new char[] {'a', 'b', 'c', 'd', 'e', 'f', '1',}

    @Test
    void searchString() {

        // задать тестовые данные
        // -- задать словарь для поиска
        for (int i = 0; i <= NUMBER_OF_ITERATIONS; i++) {
            testOneCase(DICTIONARY_WORDS_DENSITY);
        }

        // -- задать строку, в которой будем искать
//        String testSearchString = "";


        // вызвать тестируемую функцию на тестовых данных

        // протестить странные кейсы

        testOneCase(0);
        testOneCase(1);

        // написать assert


    }

    //TODO сделать универсальный тестd
    void testSubstringSearcher(SubstringSearcher substringSearcher) {
        // задать тестовые данные
        // -- задать словарь для поиска
        for (int i = 0; i <= NUMBER_OF_ITERATIONS; i++) {
            testOneCase(DICTIONARY_WORDS_DENSITY);
        }

        // -- задать строку, в которой будем искать
//        String testSearchString = "";


        // вызвать тестируемую функцию на тестовых данных

        // протестить странные кейсы
        // написать assert


    }

    private void testOneCase(double dictionaryWordsDensity) {

        StringSearchTestData testData = StringSearchTestData.generateTestData(dictionaryWordsDensity);
        HashMap<String, List<Integer>> searchResultMap;

        BrutWithHypothesisSearcher brutStringSearcher = new BrutWithHypothesisSearcher(testData.dictionary);
        searchResultMap = brutStringSearcher.searchString(testData.searchString);

        Assertions.assertTrue(areMapsEqual(searchResultMap, testData.substringsMap));
        System.out.println("SearchString test: Test passed");
    }

    private boolean areMapsEqual (HashMap<String, List<Integer>> firstMap,
                                  HashMap<String, List<Integer>> secondMap) {
        if (firstMap.size() != secondMap.size()) {
            return false;
        }

        for (Map.Entry<String, List<Integer>> e : firstMap.entrySet()) {
            List<Integer> secondList = secondMap.get(e.getKey());
            if(secondList == null) {
                return false;
            }

            List<Integer> firstList = e.getValue();

            if (firstList.size() != secondList.size()) {
                return false;
            }

            for (int i = 0; i < firstList.size(); i++) {
                if ( ! Objects.equals(firstList.get(i), secondList.get(i))) {
                    return false;
                }
            }
        }

        return true;
    }




}