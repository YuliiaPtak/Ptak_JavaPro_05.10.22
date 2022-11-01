import java.util.Arrays;

public class ArrayGenerator {
    private final float[] floats;
    private final float[] firstHalfArray;
    private final float[] secondHalfArray;
    private final int firstHalfSize;
    private final int secondHalfSize;

    private long startTime;

    public ArrayGenerator(int valuesSize) {
        floats = new float[valuesSize];
        firstHalfSize = valuesSize / 2;
        firstHalfArray = new float[firstHalfSize];
        secondHalfSize = (valuesSize % 2 == 0 ? firstHalfSize : firstHalfSize + 1);
        secondHalfArray = new float[secondHalfSize];
    }

    public void createTwoArrays() {
        startTime = System.currentTimeMillis();

        Arrays.fill(floats, 1);

        System.arraycopy(floats, 0, firstHalfArray, 0, firstHalfSize);
        System.arraycopy(floats, firstHalfSize, secondHalfArray, 0, secondHalfSize);
    }

    public float[] getFirstHalfArray() {
        return firstHalfArray;
    }

    public float[] getSecondHalfArray() {
        return secondHalfArray;
    }

    public long getStartTime() {
        return startTime;
    }
}
