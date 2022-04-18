package Algorithms;

import java.util.Arrays;

public class MatixAndZero {
    public static int[][] spreadZeros(int[][] matrix) {
        boolean zeroFirstRow = false;
        for (int j=0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                zeroFirstRow = true;
                break;
            }
        }
        for (int i=1; i < matrix.length; i++) {
            for (int j=0; j < matrix[0].length; j++) {
                if (matrix[i][j]==0) {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        for(int i=matrix.length-1; i>=1; i--) {
            for (int j=matrix[0].length-1; j>=0; j--) {
                if (matrix[i][0]==0 || matrix[0][j]==0) {
                    matrix[i][j]=0;
                }
            }
        }
        if (zeroFirstRow) {
            for (int j=0; j<matrix[0].length; j++) {
                matrix[0][j]=0;
            }
        }
        return matrix;
    }
}
