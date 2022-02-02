package BrutStringSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class BrutWithHypothesisSearcherTest {
    final int NUMBER_OF_ITERATIONS = 1000;
    final static double DICTIONARY_WORDS_DENSITY  = 0.5;

//    final char[] arrayOfAllowedCharacters = new char[] {'a', 'b', 'c', 'd', 'e', 'f', '1',}

    @Test
    void searchString() {
        System.out.println("----------Begin Test of BrutWithHypothesisSearcherTest---------------");
        SearcherUniversalTest.searchString(BrutWithHypothesisSearcher::new);
        System.out.println("----------End Test of BrutWithHypothesisSearcherTest--------------");
    }
}