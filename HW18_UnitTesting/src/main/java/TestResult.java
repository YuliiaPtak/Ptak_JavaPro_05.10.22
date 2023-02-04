import java.time.LocalDateTime;

public class TestResult {
    private int totalNumberOfTests;
    private int numberOfSuccessfulTests;
    private int numberOfFailedTests;
    private LocalDateTime launchDate;

    public int getTotalNumberOfTests() {
        return totalNumberOfTests;
    }

    public int getNumberOfSuccessfulTests() {
        return numberOfSuccessfulTests;
    }

    public int getNumberOfFailedTests() {
        return numberOfFailedTests;
    }

    public LocalDateTime getLaunchDate() {
        return launchDate;
    }

    public void setTotalNumberOfTests(int totalNumberOfTests) {
        this.totalNumberOfTests = totalNumberOfTests;
    }

    public void setNumberOfSuccessfulTests(int numberOfSuccessfulTests) {
        this.numberOfSuccessfulTests = numberOfSuccessfulTests;
    }

    public void setNumberOfFailedTests(int numberOfFailedTests) {
        this.numberOfFailedTests = numberOfFailedTests;
    }

    public void setLaunchDate(LocalDateTime launchDate) {
        this.launchDate = launchDate;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "totalNumberOfTests=" + totalNumberOfTests +
                ", numberOfSuccessfulTests=" + numberOfSuccessfulTests +
                ", numberOfFailedTests=" + numberOfFailedTests +
                ", launchDate=" + launchDate +
                '}';
    }
}
