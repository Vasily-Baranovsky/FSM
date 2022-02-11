package BrutStringSearch;

import org.junit.jupiter.api.Assertions;

import java.util.*;
import java.util.function.Function;

public class SearcherUniversalTest {
    final static int NUMBER_OF_ITERATIONS = 1000;
    final static double DICTIONARY_WORDS_DENSITY  = 0.5;

    public static void searchString(Function<String[], SubstringSearcher> fun) {

        // ручное тестирование
        testManualCase(fun);

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


        // написать assert


    }

    private static void testOneCase(double dictionaryWordsDensity, Function<String[], SubstringSearcher> fun) {

        StringSearchTestData testData = StringSearchTestData.generateTestData(dictionaryWordsDensity);
        SubstringSearcher stringSearcher = fun.apply(testData.dictionary);

        Assertions.assertTrue(testCase(testData, stringSearcher));
        System.out.println(stringSearcher.getClass().getSimpleName()+ ".searchString testOneCase: Test passed");
    }

    private static boolean testCase(
            StringSearchTestData testData,
            SubstringSearcher stringSearcher) {

        HashMap<String, List<Integer>> searchResultMap = stringSearcher.searchString(testData.searchString);

        return areMapsEqual(searchResultMap, testData.substringsMap);
    }

    private static void testManualCase(Function<String[], SubstringSearcher> fun) {
        StringSearchTestData testData = StringSearchTestData.generateManualTestData();
        SubstringSearcher stringSearcher = fun.apply(testData.dictionary);
        Assertions.assertTrue(testCase(testData, stringSearcher));

        // Done: вывести имя класса SubstringSearcher (и/или имя теста)
        System.out.println(stringSearcher.getClass().getSimpleName() + ".searchString testManualCase: Test passed");
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