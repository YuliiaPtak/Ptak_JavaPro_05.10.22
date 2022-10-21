public class ArrayValueCalculator {
    private static final int ARRAY_SIZE = 4;

    private ArrayValueCalculator() {
    }

    public static int calculateNumbers(String[][] strings) throws ArraySizeException, ArrayDataException {
        validateSize(strings);

        int result = 0;

        for (int i = 0; i < strings.length; i++) {
            String[] string = strings[i];
            for (int j = 0; j < string.length; j++) {
                String s = string[j];
                try {
                    result = result + Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Incorrect data at strings[" + i + "][" + j + "]");
                }
            }
        }

        return result;
    }

    private static void validateSize(String[][] strings) throws ArraySizeException {
        if (strings.length != ARRAY_SIZE) {
            throw new ArraySizeException("Incorrect array size, must be " + ARRAY_SIZE);
        }

        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (strings[i].length != ARRAY_SIZE) {
                throw new ArraySizeException("Incorrect array size at strings[" + i + "], must be " + ARRAY_SIZE);
            }
        }
    }
}
