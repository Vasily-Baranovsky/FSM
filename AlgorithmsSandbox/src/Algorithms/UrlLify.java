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

    public static String

    public static void main(String[] args) {

        String s = "Mr John Smith      ";

        System.out.println(urLify(s, 13));
    }
}
