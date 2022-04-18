package Algorithms;

public class PalindromeBrutforceKte {
    public static void main(String[] args) {
        char[] string = "oooppp".toCharArray();
        System.out.println(generatePermutation(string, 0));
    }

    public static boolean generatePermutation(char[] string, int level) {
        if (level == string.length) {
           // System.out.println(new String(string));
            return isPalindrome(string);
        }
        for (int i = level; i < string.length; i++) {
            char[] newArray = string.clone();
            char currentSymbol = newArray[level];
            newArray[level]=newArray[i];
            newArray[i]=currentSymbol;
            if (generatePermutation(newArray, level+1)) return true;
        }
        return false;
    }

    public static boolean isPalindrome(char[] string) {
        for (int i = 0, j = string.length-1; i<j;) {
            if (string[i]==' ') {
                i++;
                continue;
            }
            if (string[j]==' ') {
                j--;
                continue;
            }
            if (string[i]!=string[j]) {
                return false;
            }
            j--;
            i++;
        }
        return true;
    }
}
