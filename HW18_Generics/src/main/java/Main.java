import java.util.Arrays;
import java.util.List;

public class Main<T> {
    public static void main(String[] args) {

    }

    public List<T> toList(T[] array) {
        return Arrays.stream(array).toList();
    }
}
