public class Dog extends Animal {
    private static int instanceCounter;

    public Dog(String name) {
        super(name, 500, 10);
        instanceCounter++;
    }

    void run(int meters) {
        if (meters > runLimit || meters < 0) {
            System.out.println(name + " can't run such distance.");
        } else {
            System.out.println(name + " ran " + meters + " meters.");
        }
    }

    void swim(int meters) {
        if (meters > swimLimit || meters < 0) {
            System.out.println(name + " can't swim such distance.");
        } else {
            System.out.println(name + " swam " + meters + " meters.");
        }
    }

    public static int getInstanceCounter() {
        return instanceCounter;
    }
}