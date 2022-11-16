public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        int firstIndex = 0;
        int lasIndex = array.length - 1;
        int middleIndex = lasIndex / 2;

        while(true) {
            if(array[middleIndex] == target) {
                return middleIndex;
            }

            if (firstIndex == lasIndex) {
                break;
            }

            if(array[middleIndex] > target) {
                lasIndex = firstIndex != middleIndex ? middleIndex - 1 : middleIndex;
            } else if(array[middleIndex] < target) {
                firstIndex = middleIndex + 1;
            }
            middleIndex = (lasIndex + firstIndex) / 2;
        }
        return -1;
    }
}

