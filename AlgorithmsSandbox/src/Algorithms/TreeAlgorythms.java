package Algorithms;

public class TreeAlgorythms {
    public static TreeNode convertSortedArrayToBST (int[] array) {
        //вызываем рекурсивный метод с началом подмассива, концом подмассива
        return convertSubArray (array, 0, array.length-1);
    }

    private static TreeNode convertSubArray (int[] array, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }

        int currentIndex = (endIndex + startIndex)/2;

        return new TreeNode(array[currentIndex], convertSubArray(array, startIndex, currentIndex-1), convertSubArray(array, currentIndex+1, endIndex));
    }
}
