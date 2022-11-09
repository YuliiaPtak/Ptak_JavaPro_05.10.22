public class Test {
    public static void main(String[] args) {
        ArrayListNew arrayListNew = new ArrayListNew();

        for (int i = 0; i < 10; i++) {
            arrayListNew.add(i);
        }

        arrayListNew.remove(5);
        System.out.println(arrayListNew + "\n" + arrayListNew.size() + "\n" + arrayListNew.get(5) + "\n" + arrayListNew.isEmpty());

        arrayListNew.clear();
        System.out.println(arrayListNew.isEmpty());
    }
}
