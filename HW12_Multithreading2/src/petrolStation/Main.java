package petrolStation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        GasStation petrolStation = new PetrolStation(50);

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new RefuelFlow(15, petrolStation, "Bob"));
        executor.execute(new RefuelFlow(36, petrolStation, "Kirk"));
        executor.execute(new RefuelFlow(33, petrolStation, "David"));
        executor.execute(new RefuelFlow(7, petrolStation, "Jack"));
        executor.execute(new RefuelFlow(9, petrolStation, "Rick"));

        executor.shutdown();
    }
}
