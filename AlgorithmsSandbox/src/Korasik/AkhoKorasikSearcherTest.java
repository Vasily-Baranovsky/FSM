package Korasik;

import BrutStringSearch.SearcherUniversalTest;
import BrutStringSearch.TrieBrutStringSearcher;
import org.junit.jupiter.api.Test;

class AkhoKorasikSearcherTest {
    final int NUMBER_OF_ITERATIONS = 1000;
    final static double DICTIONARY_WORDS_DENSITY  = 0.5;

//    final char[] arrayOfAllowedCharacters = new char[] {'a', 'b', 'c', 'd', 'e', 'f', '1',}

    @Test
    void searchString() {
        System.out.println("----------Begin Test of TrieBrutStringSearcherTest---------------");
        SearcherUniversalTest.searchString(AkhoKorasikSearcher::new);
        System.out.println("----------End Test of TrieBrutStringSearcherTest--------------");
    }
}