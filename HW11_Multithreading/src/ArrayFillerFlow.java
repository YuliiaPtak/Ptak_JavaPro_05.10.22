public class ArrayFillerFlow implements Runnable {
    private final float[] values;

    public ArrayFillerFlow(float[] values) {
        this.values = values;
    }

    @Override
    public void run() {
        for (int i = 0; i < values.length; i++) {
            values[i] = (float) (values[i] * Math.sin(0.2f + i / 5.0) * Math.cos(0.2f + i / 5.0) * Math.cos(0.4f + i / 2.0));
        }
    }

    public float[] getValues() {
        return values;
    }
}
