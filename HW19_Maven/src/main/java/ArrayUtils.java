public class ArrayUtils {
    public static int findMinValue(int[] source) {
        int target = source[0];
        for (int i = 1; i < source.length; i++) {
            target = Math.min(target, source[i]);
        }
        return target;
    }

    public static int findMaxValue(int[] source) {
        int target = source[0];
        for (int i = 1; i < source.length; i++) {
            target = Math.max(target, source[i]);
        }
        return target;
    }
}
