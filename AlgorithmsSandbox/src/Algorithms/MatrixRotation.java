package Algorithms;

public class MatrixRotation {
    public static void main(String[] args) {
/*
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
*/
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        System.out.println("Input Matrix:");
        printMatrix(matrix);

        System.out.println("Rotated Matrix:");
        printMatrix(rotateClockwise(matrix));

        System.out.println("Inplace Rotated Matrix:");
        rotateClockwiseInplace(matrix);
        printMatrix(matrix);
    }


    public static void printMatrix(int[][] matrix) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }


    public static int[][] rotateClockwise(int[][] matrix) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;

        // только для квадратных матриц
        if (nRows != nCols) return null;

        int[][] resMatrix = new int[nRows][nCols];

        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                resMatrix[i][j] = matrix[nCols-j-1][i];
            }
        }

        return resMatrix;
    }

    public static void rotateClockwiseInplace(int[][] matrix) {
        int n = matrix.length;
/*
x1 = n - j -1
y1 = i

x2 = n - y1 -1
y2 = x1


x3 = n - y2 - 1
x3 = x2

tmp = m[i][j]
m[i][j] = m[x3][y3]
m[x3][y3] = m[x2][y2]
m[x2][y2] = m[x1][y1]
m[x1][y1] = tmp
* */

        int nRowsPart = (int) Math.round(matrix.length / 2.);
        int nColsPart = matrix[0].length / 2;

        for (int i = 0; i < nRowsPart; i++) {
            for (int j = 0; j < nColsPart; j++) {
                int x1 = n-j-1;
                int y1 = i;

                int x2 = n-y1-1;
                int y2 = x1;

                int x3 = n-y2-1;
                int y3 = x2;

                int tmp = matrix[i][j];
                matrix[i][j] = matrix[x1][y1];
                matrix[x1][y1] = matrix[x2][y2];
                matrix[x2][y2] = matrix[x3][y3];
                matrix[x3][y3] = tmp;
            }
        }
    }
}
