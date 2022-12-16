import Fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitBox<T extends Fruit> {
    private final List<T> fruits = new ArrayList<>();

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public void addFruits(List<T> fruits) {
        this.fruits.addAll(fruits);
    }

    public double getWeight() {
        return getWeight(fruits);
    }

    private double getWeight(List<? extends Fruit> fruits) {
        return fruits.stream().mapToDouble(Fruit::getWeight).sum();
    }

    public boolean compare(List<? extends Fruit> fruits) {
        return getWeight() == getWeight(fruits);
    }

    public void merge(List<T> fruits) {
        addFruits(fruits);
        fruits.clear();
    }

    public List<T> getFruits() {
        return fruits;
    }
}