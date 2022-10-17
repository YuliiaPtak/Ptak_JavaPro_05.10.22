public class HomeWorkApp {

    public static void main(String[] args) {
        printThreeWords();
        System.out.println();

        checkSumSign(-5, 3);
        System.out.println();

        printColor(100);
        System.out.println();

        compareNumbers(2, 3);
        System.out.println();

        System.out.println(sumIsWithin(15, 5));
        System.out.println();

        checkSign(-5);
        System.out.println();

        System.out.println(isNegative(5));
        System.out.println();

        printString("Слава Україні!!!", 5);
        System.out.println();

        System.out.println(isLeap(2000));
    }

    public static void printThreeWords() {
        System.out.println("Orange \nBanana \nApple");
    }

    public static void checkSumSign(int a, int b) {
        System.out.println(a + b < 0 ? "negative" : "positive");
    }

    public static void printColor(int value) {
        if (value > 100) {
            System.out.println("Green");
        } else if (value > 0) {
            System.out.println("Yellow");
        } else {
            System.out.println("Red");
        }
    }

    public static void compareNumbers(int a, int b) {
        System.out.println(a >= b ? "a >= b" : "a < b");
    }

    public static boolean sumIsWithin(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void checkSign(int value) {
        System.out.println(value < 0 ? "negative" : "positive");
    }

    public static boolean isNegative(int value) {
        return value < 0;
    }

    public static void printString(String str, int times) {
        for (int i = 0; i < times; i++) {
            System.out.println(str);
        }
    }

    public static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
