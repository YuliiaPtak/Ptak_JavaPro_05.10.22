public class LinkedListNew implements MyList {
    private Node first = new Node();
    private Node last = new Node();
    private int size;

    public LinkedListNew() {
        first.next = last;
        last.prev = first;
    }

    @Override
    public boolean add(Object o) {
        Node node = new Node();
        node.value = o;

        Node tempNode = last.prev;
        tempNode.next = node;
        node.prev = tempNode;
        last.prev = node;

        size++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node currentElement = first.next;
        while (currentElement != null) {
            if (currentElement.value.equals(o)) {
                //todo unlink
                return true;
            }
            currentElement = currentElement.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
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

    }

    @Override
    public Object get(int index) {
        return null;
    }

    public void print() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public static class Node {
        private Node prev;
        private Object value;
        private Node next;
    }
}
