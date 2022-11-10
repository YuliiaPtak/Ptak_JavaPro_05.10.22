package occurenceCalculator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 1, 1, 6, 1, 2, 2, 2, 2, 3, 3, 4};
        List<Integer> integers = OccurrenceCalculator.toList(ints);

        System.out.println(OccurrenceCalculator.findUnique(integers));

        List<String> strings = new ArrayList<>();

        strings.add("bird");
        strings.add("bird");
        strings.add("cat");
        strings.add("fox");

        OccurrenceCalculator.calcOccurrence(strings);
        System.out.println(OccurrenceCalculator.findOccurrence(strings));
    }
}
