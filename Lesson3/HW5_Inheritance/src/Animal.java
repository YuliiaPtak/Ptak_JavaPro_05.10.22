abstract class Animal {
    protected String name;
    protected int runLimit;
    protected int swimLimit;
    private static int instanceCounter;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        instanceCounter++;
    }

    abstract void run(int meters);

    abstract void swim(int meters);

    public static int getInstanceCounter() {
        return instanceCounter;
    }
}