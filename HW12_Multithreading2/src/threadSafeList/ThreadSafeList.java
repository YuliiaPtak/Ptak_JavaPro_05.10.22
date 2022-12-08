package threadSafeList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeList<E> {
    private final List<E> threadSafeList = new ArrayList<>();

    public synchronized boolean add(E value) {
        return threadSafeList.add(value);
    }

    public synchronized E remove(int index) {
        return threadSafeList.remove(index);
    }

    public synchronized E get(int index) {
        return threadSafeList.get(index);
    }
}
