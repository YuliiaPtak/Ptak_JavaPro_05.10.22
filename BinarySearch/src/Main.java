import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[1_000_000];
        int target = 2;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100_000);
        }

        Arrays.sort(array);

        int index = BinarySearch.binarySearch(array, target);

        System.out.println("index = "  + index + ", value = " + array[index] + ", target = " + target);
    }
}
