package threadSafeList;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeList<E> {
    private final List<E> threadSafeList = new ArrayList<>();

    public boolean add(E value) {
        synchronized (threadSafeList) {
            return threadSafeList.add(value);
        }
    }

    public E remove(int index) {
        synchronized (threadSafeList) {
            return threadSafeList.remove(index);
        }
    }

    public E get(int index) {
        return threadSafeList.get(index);
    }
}
