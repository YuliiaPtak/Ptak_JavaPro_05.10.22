public interface MyList {
    boolean add(Object o);

    boolean remove(Object o);

    Object[] toArray();

    boolean isEmpty();

    int size();

    void clear();

    Object get(int index);
}
