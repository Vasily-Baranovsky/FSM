package Algorithms;

import java.util.HashMap;

public class Permutation {
    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> charsS1 = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            int n = charsS1.getOrDefault(s1.charAt(i), 0);
            charsS1.put(s1.charAt(i), n+1);
        }

        for(int i = 0; i < s2.length(); i++) {
            if (!charsS1.containsKey(s2.charAt(i))) {
                return false;
            } else {
                int n = charsS1.get(s2.charAt(i));
                charsS1.put(s2.charAt(i), n - 1 );
                if(charsS1.get(s2.charAt(i)) <= 0) {
                    charsS1.remove(s2.charAt(i));
                }
            }
        }

        return charsS1.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "aaaaa";
        String s2 = "aaaa ";

        System.out.println(isPermutation(s1, s2));
    }
}
