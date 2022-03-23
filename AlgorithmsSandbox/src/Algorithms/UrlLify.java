package Algorithms;

public class UrlLify {

    public static String urLify(String s, int n) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();

    }

    public static String urLifyInPlace(String s, int n) {
        int index = s.length() - n;
        char[] sCh = new char[s.length()];

        for (int i = n - 1; i >= 0;) {
            if (s.charAt(i) != 32) {
                sCh[i + index] = s.charAt(i);
                i--;
            } else {
                sCh[i + index] = '0';
                sCh[i + index - 1] = '2';
                sCh[i + index - 2] = '%';
                index = index - 2;
                i--;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c: sCh) {
            sb.append(c);
        }

        return sb.toString();

    }

    public static void main(String[] args) {

        String s = "Mr John Smith    ";

        System.out.println(urLifyInPlace(s, 13));
    }
}
