import java.util.Arrays;

public class LinkedListNew implements MyList {
    private Node first;
    private Node last;
    private int size;

    @Override
    public boolean add(Object o) {
        Node lastNode = last;
        Node newNode = new Node(lastNode, o, null);
        last = newNode;
        if (lastNode == null)
            first = newNode;
        else
            lastNode.next = newNode;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node current = first; current != null; current = current.next) {
                if (current.value == null) {
                    unlink(current);
                    return true;
                }
            }
        } else {
            for (Node current = first; current != null; current = current.next) {
                if (o.equals(current.value)) {
                    unlink(current);
                    return true;
                }
            }
        }
        return false;
    }

    private void unlink(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.value = null;
        size--;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size];
        Node current = first;

        for (int i = 0; current != null; i++) {
            objects[i] = current.value;
            current = current.next;
        }
        return objects;
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
        for (Node current = first; current != null; ) {
            Node next = current.next;
            current.value = null;
            current.next = null;
            current.prev = null;
            current = next;
        }

        first = last = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for size " + size);
        }

        Node currentElement = first;
        for (int i = 0; i < index; i++) {
            currentElement = currentElement.next;
        }
        return currentElement.value;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    public static class Node {
        private Node prev;
        private Object value;
        private Node next;

        public Node(Node prev, Object value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }
}
