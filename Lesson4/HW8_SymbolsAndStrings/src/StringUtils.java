public class StringUtils {
    public static int findSymbolOccurrence(String str, char symbol) {
        int charCounter = 0;

        for (int i = 0; i < str.length(); i++) {
            if (symbol == str.charAt(i)) {
                charCounter++;
            }
        }
        return charCounter;
    }

    public static int findWordPosition(String source, String target) {
        return source.indexOf(target);
    }

    public static String stringReverse(String str) {
        char[] reversed = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            reversed[reversed.length - i - 1] = str.charAt(i);
        }
        return String.valueOf(reversed);
    }

    public static boolean isPalindrome(String str) {
        return str.equalsIgnoreCase(stringReverse(str));
    }
}
