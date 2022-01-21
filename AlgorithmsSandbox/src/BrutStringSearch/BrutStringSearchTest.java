package BrutStringSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class BrutStringSearchTest {
    final int NUMBER_OF_ITERATIONS = 1000;
    final static double DICTIONARY_WORDS_DENSITY  = 0.5;

//    final char[] arrayOfAllowedCharacters = new char[] {'a', 'b', 'c', 'd', 'e', 'f', '1',}

    @Test
    void searchString() {
        System.out.println("----------Begin Test of BrutStringSearchTest---------------");
        SearcherUniversalTest.searchString(BrutStringSearcher::new);
        System.out.println("----------End Test of BrutStringSearchTest--------------");
    }
}