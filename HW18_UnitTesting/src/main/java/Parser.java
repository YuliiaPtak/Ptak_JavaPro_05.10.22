import java.io.*;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Parser {

    private File file;
    private Path path;
    private String pathString;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH:mm:ss.SSS");

    public Parser(String pathString) {
        this.pathString = pathString;
    }

    public Parser(File file) {
        this.file = file;
    }

    public Parser(Path path) {
        this.path = path;
    }

    public TestResult parse() {
        if (file != null) {
            return buildTestResult(file);
        } else if (path != null) {
            return buildTestResult(path.toFile());
        } else if (pathString != null) {
            return buildTestResult(new File(pathString));
        }
        throw new RuntimeException("File not found");
    }

    private TestResult buildTestResult(File file) {
        TestResult testResult = new TestResult();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while (reader.ready()) {
                String line = reader.readLine();
                if (line.contains("tests found")) {
                    testResult.setTotalNumberOfTests(clean(line));
                } else if (line.contains("tests successful")) {
                    testResult.setNumberOfSuccessfulTests(clean(line));
                } else if (line.contains("tests failed")) {
                    testResult.setNumberOfFailedTests(clean(line));
                } else if (line.contains("Launch date: ")) {
                    testResult.setLaunchDate(LocalDateTime.parse(line.split(" ")[2], FORMATTER));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return testResult;
    }

    private int clean(String s) {
        return Integer.parseInt(s.replaceAll("\\D+", ""));
    }
}
