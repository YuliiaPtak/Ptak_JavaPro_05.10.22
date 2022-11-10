package occurenceCalculator;

import java.util.ArrayList;
import java.util.List;

public class OccurrenceCalculator {
    public static int countOccurrence(List<String> strings, String target) {
        int occurrence = 0;

        for (String string : strings) {
            if (target.equals(string)) {
                occurrence++;
            }
        }
        return occurrence;
    }

    public static List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>();

        for (int i : array) {
            list.add(i);
        }
        return list;
    }

    public static List<Integer> findUnique(List<Integer> integers) {
        List<Integer> uniqueInts = new ArrayList<>();

        for (Integer integer : integers) {
            if (uniqueInts.contains(integer)) {
                continue;
            }
            uniqueInts.add(integer);
        }
        return uniqueInts;
    }

    public static void calcOccurrence(List<String> strings) {
        for (String unique : findUniqueStrings(strings)) {
            System.out.println(unique + ": " + countOccurrence(strings, unique));
        }
    }

    public static List<StringOccurrences> findOccurrence(List<String> strings) {
        List<StringOccurrences> occurrences = new ArrayList<>();

        for (String unique : findUniqueStrings(strings)) {
            occurrences.add(new StringOccurrences(unique, countOccurrence(strings, unique)));
        }
        return occurrences;
    }

    private static List<String> findUniqueStrings(List<String> strings) {
        List<String> uniqueStrings = new ArrayList<>();

        for (String unique : strings) {
            if (uniqueStrings.contains(unique)) {
                continue;
            }
            uniqueStrings.add(unique);
        }
        return uniqueStrings;
    }
}