package Algorithms;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TreeAlgorythmsTest {
    public static final int MAX_ARRAY_SIZE = 30;
    @Test
    void convertSortedArrayToBSTNaiveTest() {
        int[] array = new int[MAX_ARRAY_SIZE];
        for (int i=0; i < MAX_ARRAY_SIZE; i++) {
            array[i] = i;
        }
        System.out.println(TreeAlgorythms.convertSortedArrayToBST(array));
    }

    @Test
    void convertSortedArrayToBSTRandomTest() {
        int[] array = new int[MAX_ARRAY_SIZE];
        for (int i=0; i < MAX_ARRAY_SIZE; i++) {
            array[i] = (int)(Math.random()*MAX_ARRAY_SIZE*2);
        }
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(TreeAlgorythms.convertSortedArrayToBST(array));
    }
}