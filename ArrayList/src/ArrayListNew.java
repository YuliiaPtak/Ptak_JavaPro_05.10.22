import java.util.Arrays;

public class ArrayListNew implements MyList {
    private int size;
    private Object[] objects = new Object[10];

    @Override
    public boolean add(Object o) {
        if (size == objects.length) {
            Object[] newArray = Arrays.copyOf(objects, objects.length * 2);
            newArray[size++] = o;
            objects = newArray;
            return true;
        }
        objects[size++] = o;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int i = 0;

        if (o == null) {
            for (; i < size; i++)
                if (objects[i] == null)
                    break;
        } else {
            for (; i < size; i++)
                if (o.equals(objects[i]))
                    break;
        }

        int newSize;

        if ((newSize = size - 1) > i)
            System.arraycopy(objects, i + 1, objects, i, newSize - i);
        objects[size = newSize] = null;

        return true;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(objects, size);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            objects[i] = null;
        }
        size = 0;
    }

    @Override
    public Object get(int index) {
        return objects[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
