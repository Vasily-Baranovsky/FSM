package Algorithms;

public class OneAway {
    public static final String RESULT="Result - ";
    public static void main(String[] args) {
        String str1 = "pale";
        String str2 = "ple";
        System.out.println(RESULT + checkStrings(str1,str2));

        str1 = "pales";
        str2 = "pale";
        System.out.println(RESULT + checkStrings(str1,str2));

        str1 = "pale";
        str2 = "pales";
        System.out.println(RESULT + checkStrings(str1,str2));


        str1 = "pale";
        str2 = "bale";
        System.out.println(RESULT + checkStrings(str1,str2));

        str1 = "pale";
        str2 = "bake";
        System.out.println(RESULT + checkStrings(str1,str2));
    }

    public static boolean checkStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return isOneRemoved(str2, str1);
        }
        else if (str1.length() > str2.length()) {
            return isOneRemoved(str1, str2);
        }

        return isOneReplaced(str1, str2);
    }


    public static boolean isOneRemoved(String strLong, String strShort) {
        if (strLong.length() <= strShort.length()) {
            return false;
        }

        if (strLong.length() - strShort.length() > 1) {
            return false;
        }

        int counter = 0;
        for (int i = 0; i < strShort.length(); i++) {
            if (strLong.charAt(i) != strShort.charAt(i-counter)) {
                counter++;
            }

            if (counter > 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean isOneReplaced(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int counter=0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                counter++;
            }

            if (counter > 1) {
                return false;
            }
        }

        return true;
    }
}
