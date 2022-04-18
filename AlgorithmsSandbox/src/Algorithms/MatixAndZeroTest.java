package Algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatixAndZeroTest {
    static class MatrixGenerator {
        private final static int[][] manualMatrix = {
                {1, 2, 3, 4, 5},
                {1, 0, 2, 3, 0},
                {0, 2, 3, 4, 0}
        };
        public static int[][] getManualMatrix () {
            return manualMatrix;
        }
    }

    @Test
    void spreadZeros() {
        System.out.println(Arrays.deepToString(MatrixGenerator.getManualMatrix()));
        System.out.println(Arrays.deepToString(MatixAndZero.spreadZeros(MatrixGenerator.getManualMatrix())));
    }
}