public class Cat extends Animal {
    private static int instanceCounter;

    public Cat(String name) {
        super(name, 200, 0);
        instanceCounter++;
    }

    public void run(int meters) {
        if (meters > runLimit || meters < 0) {
            System.out.println(name + " can't run such distance.");
        } else {
            System.out.println(name + " ran " + meters + " meters.");
        }
    }

    public void swim(int meters) {
        System.out.println(name + " refuses to swim.");
    }

    public static int getInstanceCounter() {
        return instanceCounter;
    }
}
