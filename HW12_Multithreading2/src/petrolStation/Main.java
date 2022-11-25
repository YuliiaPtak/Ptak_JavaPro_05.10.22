package petrolStation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        PetrolStation petrolStation = new PetrolStation(50);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new RefuelFlow(1, petrolStation, "Bob"));
        executor.execute(new RefuelFlow(8, petrolStation, "Kirk"));
        executor.execute(new RefuelFlow(34, petrolStation, "David"));
        executor.execute(new RefuelFlow(55, petrolStation, "Jack"));
        executor.execute(new RefuelFlow(5, petrolStation, "Rick"));

        executor.shutdown();
    }
}
