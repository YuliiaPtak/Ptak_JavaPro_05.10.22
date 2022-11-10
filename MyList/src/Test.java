public class Test {
    public static void main(String[] args) {
        ArrayListNew arrayListNew = new ArrayListNew();

        for (int i = 0; i < 10; i++) {
            arrayListNew.add(i);
        }

        System.out.println("ArrayList:");
        System.out.println(arrayListNew + "\nsize = " + arrayListNew.size());
        System.out.println("Remove 5");
        arrayListNew.remove(5);
        System.out.println(arrayListNew + "\nsize = " + arrayListNew.size() + "\narrayList[3] = " + arrayListNew.get(3));
        System.out.println("isEmpty = " + arrayListNew.isEmpty());
        System.out.println("Clear:");
        arrayListNew.clear();
        System.out.println("isEmpty = " + arrayListNew.isEmpty() + "\nsize = " + arrayListNew.size());

        System.out.println("\nLinkedList:");

        LinkedListNew linkedListNew = new LinkedListNew();

        for (int i = 0; i < 10; i++) {
            linkedListNew.add(i);
        }

        System.out.println(linkedListNew + "\nsize = " + linkedListNew.size());
        System.out.println("Remove 5");
        linkedListNew.remove(5);
        System.out.println(linkedListNew + "\nsize = " + linkedListNew.size() + "\narrayList[3] = " + linkedListNew.get(3));
        System.out.println("isEmpty = " + linkedListNew.isEmpty());
        System.out.println("Clear:");
        linkedListNew.clear();
        System.out.println("isEmpty = " + linkedListNew.isEmpty() + "\nsize = " + linkedListNew.size());
    }
}
