package BrutStringSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

class SearcherUniversalTest {
    final static int NUMBER_OF_ITERATIONS = 1000;
    final static double DICTIONARY_WORDS_DENSITY  = 0.5;

    static void searchString(Function<String[], SubstringSearcher> fun) {

        // задать тестовые данные
        // -- задать словарь для поиска
        for (int i = 0; i <= NUMBER_OF_ITERATIONS; i++) {
            testOneCase(DICTIONARY_WORDS_DENSITY, fun);
        }

        // -- задать строку, в которой будем искать
//        String testSearchString = "";


        // вызвать тестируемую функцию на тестовых данных

        // протестить странные кейсы

        testOneCase(0, fun);
        testOneCase(1, fun);

        // ручное тестирование
        testManualCase(fun);
        // написать assert


    }


    private static void testOneCase(double dictionaryWordsDensity, Function<String[], SubstringSearcher> fun) {

        StringSearchTestData testData = StringSearchTestData.generateTestData(dictionaryWordsDensity);
        Assertions.assertTrue(testCase(testData, fun));
        System.out.println("SearchString testOneCase: Test passed");
    }

    private static boolean testCase(StringSearchTestData testData, Function<String[], SubstringSearcher> fun) {
        SubstringSearcher stringSearcher = fun.apply(testData.dictionary);
        HashMap<String, List<Integer>> searchResultMap;
        searchResultMap = stringSearcher.searchString(testData.searchString);

        return areMapsEqual(searchResultMap, testData.substringsMap);
    }

    private static void testManualCase(Function<String[], SubstringSearcher> fun) {
        StringSearchTestData testData = StringSearchTestData.generateManualTestData();
        Assertions.assertTrue(
                testCase(testData, fun)
        );

//        System.out.println(fun.getClass().toString());

        // ToDo: вывести имя класса SubstringSearcher (и/или имя теста)
        System.out.println("SearchString testManualCase: Test passed");
    }

    private static boolean areMapsEqual (HashMap<String, List<Integer>> firstMap,
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