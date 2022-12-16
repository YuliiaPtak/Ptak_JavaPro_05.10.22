import Fruits.Apple;
import Fruits.Orange;

import java.util.Arrays;
import java.util.List;

public class Main<T> {
    public static void main(String[] args) {
        FruitBox<Orange> orangeFruitBox = new FruitBox<>();
        FruitBox<Apple> appleFruitBox = new FruitBox<>();
        appleFruitBox.addFruit(new Apple(200.0));
        System.out.println(orangeFruitBox.getWeight());
        System.out.println(orangeFruitBox.compare(appleFruitBox.getFruits()));
        FruitBox<Orange> newOrangeFruitBox = new FruitBox<>();
        newOrangeFruitBox.addFruit(new Orange(200.0));
        orangeFruitBox.merge(newOrangeFruitBox.getFruits());
        System.out.println(orangeFruitBox.compare(appleFruitBox.getFruits()));
        System.out.println(orangeFruitBox.getWeight());
    }

    public List<T> toList(T[] array) {
        return Arrays.stream(array).toList();
    }
}
