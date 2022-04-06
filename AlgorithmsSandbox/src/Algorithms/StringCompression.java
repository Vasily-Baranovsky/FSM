package Algorithms;

public class StringCompression {
    public static void main(String[] args) {
        String str="aabcccccaaa";
        String strCompressed = compress(str);

        System.out.println(strCompressed);
        System.out.println(decompress(strCompressed));

    }

    public static String compress(String str) {

        int counter=1;
        char ch=str.charAt(0);
        StringBuilder builder = new StringBuilder();
        for (int i=1; i<str.length(); i++) {
            if (ch != str.charAt(i)) {
                builder.append(ch).append(counter);

                ch = str.charAt(i);
                counter=0;
            }

            counter++;
        }

        builder.append(ch).append(counter);

        String strResult = builder.toString();
        if (strResult.length() >= str.length()) {
            return str;
        }
        return strResult;
    }

    public static String decompress(String compressedString) {

        // не сжатая строка, т.к. сжатые строки содержат минимум два символа (буква и кол-во повторений)
        if (compressedString.length() < 2) {
            return compressedString;
        }

        // не сжатая строка, т.к. сжатые строки содержат минимум два символа (буква и кол-во повторений)
        if (!isNumber(compressedString.charAt(1))) {
            return compressedString;
        }

        int counter=0;
        char ch=compressedString.charAt(0);

        StringBuilder builder = new StringBuilder(ch);
        StringBuilder number = new StringBuilder();
        for (int i = 1; i < compressedString.length(); i++) {
            if (isNumber(compressedString.charAt(i))) {
                number.append(compressedString.charAt(i));
//                System.out.println(number.toString());
            }
            else {
                int n = Integer.parseInt(number.toString());
                String strCh = String.valueOf(ch);
                builder.append(strCh.repeat(n));

                ch = compressedString.charAt(i);
                number = new StringBuilder();
            }
        }

        builder.append(String.valueOf(ch).repeat(Integer.parseInt(number.toString())));

        return builder.toString();
    }

    public static boolean isNumber(char ch) {
        if (    ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4' ||
                ch == '5' || ch == '6' || ch == '7' || ch == '8' || ch == '9' ) {
            return true;
        }

        return false;
    }
}
