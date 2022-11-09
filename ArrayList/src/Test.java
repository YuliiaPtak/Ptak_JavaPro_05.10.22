import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
//        ArrayListNew arrayListNew = new ArrayListNew();
//
//        for (int i = 0; i < 10; i++) {
//            arrayListNew.add(i);
//        }
//
//        arrayListNew.remove(5);
//        System.out.println(arrayListNew + "\n" + arrayListNew.size() + "\n" + arrayListNew.get(5) + "\n" + arrayListNew.isEmpty());
//
//        arrayListNew.clear();
//        System.out.println(arrayListNew.isEmpty());

        LinkedListNew linkedListNew = new LinkedListNew();
        linkedListNew.add(5);
        linkedListNew.add(3);
        linkedListNew.add(9);
        linkedListNew.print();
        linkedListNew.remove(9);
        linkedListNew.print();
    }
}
