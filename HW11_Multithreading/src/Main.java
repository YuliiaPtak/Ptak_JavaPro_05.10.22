import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int size = 1_000_000;
        float[] resultValues = new float[size];

        ArrayGenerator arrayGenerator = new ArrayGenerator(size);
        arrayGenerator.createTwoArrays();

        float[] firstHalf = arrayGenerator.getFirstHalfArray();
        float[] secondHalf = arrayGenerator.getSecondHalfArray();

        ArrayFillerFlow flow1 = new ArrayFillerFlow(firstHalf);
        ArrayFillerFlow flow2 = new ArrayFillerFlow(secondHalf);

        Thread firstThread = new Thread(flow1);
        Thread secondThread = new Thread(flow2);

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        firstHalf = flow1.getValues();
        secondHalf = flow2.getValues();

        System.arraycopy(firstHalf, 0, resultValues, 0, firstHalf.length);
        System.arraycopy(secondHalf, 0, resultValues, firstHalf.length, secondHalf.length);

        System.out.println(System.currentTimeMillis() - arrayGenerator.getStartTime());
    }
}
