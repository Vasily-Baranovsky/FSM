package Algorithms;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PalindromePermutation {
    public static void main(String[] args) {
        //String s1 = "Tact Coa";
        String s = "xyz";

        ArrayList<String> arrResult = getPermutations(s);

        for (int i=0; i<arrResult.size(); ++i) {
            System.out.println(arrResult.get(i));
        }
    }

    public static ArrayList<String> getPermutations(String str) {
        ArrayList<String> arrRes = new ArrayList<>();
        char[] chArr = str.toCharArray();
        char[] chSubArray = str.substring(1).toCharArray();

        getPermutations(0, chSubArray, arrRes);

        return arrRes;
    }

    public static void getPermutations(int startIndex, char[] str, ArrayList<String> arrRes) {
        if (arrRes == null) {
            arrRes = new ArrayList<>();
        }

        if (str.length < 2) {
            return;
        }


        for (int i = startIndex+1; i < str.length; i++) {
            char[] chCopy=str.clone();
            char chTmp = chCopy[0];
            chCopy[0]=chCopy[i];
            chCopy[i]=chTmp;

            arrRes.add(new String(chCopy));

            getPermutations(startIndex+1, str, arrRes);
        }
    }
}

