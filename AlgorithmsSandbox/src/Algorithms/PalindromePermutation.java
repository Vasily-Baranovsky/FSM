package Algorithms;

import java.util.ArrayList;

public class PalindromePermutation {
    public static void main(String[] args) {
        //String s1 = "Tact Coa";
        String s = "xyzxyz";

        ArrayList<String> arrResult = getPermutations(s);

        for (int i=0; i<arrResult.size(); ++i) {
            System.out.println(arrResult.get(i) + " - " + isPalindrome(arrResult.get(i)));
        }

        System.out.println("Final result - " + isPalindromeExists(arrResult));
    }

    public static ArrayList<String> getPermutations(String str) {
        ArrayList<String> arrRes = new ArrayList<>();
        char[] chArr = str.toCharArray();

        getPermutations(0, chArr, arrRes);

        return arrRes;
    }

    public static void getPermutations(int startIndex, char[] str, ArrayList<String> arrRes) {

        if (startIndex >= str.length-1) {
            arrRes.add(new String(str));
            return;
        }

        for (int i = startIndex; i < str.length; i++) {
            char[] chCopy=str.clone();
            char chTmp = chCopy[startIndex];
            chCopy[startIndex]=chCopy[i];
            chCopy[i]=chTmp;

            getPermutations(startIndex+1, chCopy, arrRes);
        }
    }

    public static boolean isPalindrome(String str) {
        for (int i=0; i<str.length()/2; ++i) {
            if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPalindromeExists( ArrayList<String> arrayOfPermutations) {
        for (int i = 0; i < arrayOfPermutations.size(); i++) {
            if (isPalindrome(arrayOfPermutations.get(i))) {
                return true;
            }
        }

        return false;
    }
}

