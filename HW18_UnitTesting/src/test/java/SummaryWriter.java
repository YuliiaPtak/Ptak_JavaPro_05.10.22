import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SummaryWriter extends SummaryGeneratingListener {
    private static final String FILE_PATH = "test.log";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy.MM.dd.HH:mm:ss.SSS");

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        super.testPlanExecutionFinished(testPlan);

        TestExecutionSummary summary = getSummary();
        print(summary);
    }

    private void print(TestExecutionSummary summary) {
        try {
            File file = createFile();
            print(summary, new BufferedOutputStream(new FileOutputStream(file)));
            print(summary, new BufferedOutputStream(System.out));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private void print(TestExecutionSummary summary, BufferedOutputStream stream) {
        try (PrintWriter printWriter = new PrintWriter(stream)) {
            summary.printTo(printWriter);
            printWriter.print("Launch date: " + LocalDateTime.now().format(FORMATTER));
        }
    }

    private File createFile() throws IOException {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            return file;
        }
        file.createNewFile();
        return file;
    }
}
