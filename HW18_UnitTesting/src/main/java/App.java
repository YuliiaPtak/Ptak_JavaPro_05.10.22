public class App {

    public static void main(String[] args) {
        Parser parser = new Parser("test.log");
        TestResult testResult = parser.parse();
        System.out.println(testResult);
    }
}
