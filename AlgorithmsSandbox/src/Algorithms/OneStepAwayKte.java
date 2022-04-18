package Algorithms;


public class OneStepAwayKte {
    public static boolean isOneStepAway(String string1, String string2) {
        int lengthDelta = string1.length() - string2.length();
        if (lengthDelta==0) {
            return isOneReplaceAway(string1, string2);
        }
        if (lengthDelta==1) {
            return isOneSymbolInserted (string2, string1);
        }
        if (lengthDelta==-1) {
            return isOneSymbolInserted(string1, string2);
        }
        return false;
    }

    private static boolean isOneSymbolInserted (String shorterString, String longerString) {
        if (shorterString.length()==0) {
            return true;
        }

        int counter=0;
        for (int i=0; i-counter < shorterString.length(); i++) {
            if (shorterString.charAt(i-counter)!=longerString.charAt(i)) {
                if (counter>0) {
                    return false;
                } else {
                    counter++;
                }
            }
        }
        return true;
    }

    private static boolean isOneReplaceAway (String string1, String string2) {
        for (int i =0, counter=0; i < string1.length(); i++) {
            if (string1.charAt(i)!=string2.charAt(i)) {
                if (counter>0) {
                    return false;
                } else {
                    counter++;
                }
            }
        }
        return true;
    }
}
