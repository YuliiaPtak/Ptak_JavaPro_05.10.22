public class App {
    public static void main(String[] args) {
        Animal cat = new Cat("Butch");
        cat.run(200);
        cat.swim(10);

        Animal dog = new Dog("Bob");
        dog.run(500);
        dog.swim(10);

        System.out.println();
        System.out.println(Animal.getInstanceCounter() + " animals");
        System.out.println(Cat.getInstanceCounter() + " dog");
        System.out.println(Dog.getInstanceCounter() + " cat");
    }
}
