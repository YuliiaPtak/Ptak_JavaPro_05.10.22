import java.util.Arrays;

public class ArrayUtils {

    public static int[] getNumbersAfterLastFour(int[] source) {
        int target = 4;
        if (hasNumber(source, target)) {
            return Arrays.copyOfRange(source, lastIndexOf(source, target) + 1, source.length);
        }
        return new int[]{};
    }

    public static boolean isConsistOfFourAndOne(int[] source) {
        for (int i : source) {
            if (i == 1 || i == 4) {
                continue;
            }
            return false;
        }
        return hasNumber(source, 1) && hasNumber(source, 4);
    }

    private static boolean hasNumber(int[] source, int target) {
        return lastIndexOf(source, target) >= 0;
    }

    private static int lastIndexOf(int[] source, int target) {
        for (int i = source.length - 1; i > 0; i--) {
            if (target == source[i]) {
                return i;
            }
        }
        return -1;
    }
}
