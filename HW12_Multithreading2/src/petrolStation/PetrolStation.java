package petrolStation;

import java.util.concurrent.atomic.AtomicInteger;

public class PetrolStation implements GasStation {
    private volatile int amountOfFuelAtCistern;
    private volatile int availableAmountOfFuel;

    private final int numberOfDispensers;
    private final AtomicInteger numberOfBusyDispensers = new AtomicInteger(0);

    public PetrolStation(int amountOfFuel, int numberOfDispensers) {
        amountOfFuelAtCistern = amountOfFuel;
        availableAmountOfFuel = amountOfFuel;

        this.numberOfDispensers = numberOfDispensers;
    }

    @Override
    public void doRefuel(int petrolRequest, String name) {
        new Thread(() -> startService(petrolRequest, name)).start();
    }

    public void startService(int petrolRequest, String name) {
        if (isOverFlowed()) {
            waitInLine();
        }

        numberOfBusyDispensers.incrementAndGet();

        try {
            createOrder(name, petrolRequest);
        } catch (TooBigOrderException e) {
            System.out.println(e.getMessage());
            leavePetrolStation();
            return;
        }

        fillUpTheCar(petrolRequest);

        System.out.println(name + " has got " + petrolRequest + ", amount of fuel at cistern left: " + amountOfFuelAtCistern);
        leavePetrolStation();
    }

    private boolean isOverFlowed() {
        return numberOfBusyDispensers.get() >= numberOfDispensers;
    }

    private void createOrder(String name, int petrolRequest) throws TooBigOrderException {
        System.out.println(name + " ordered " + petrolRequest + " liters");

        if (petrolRequest > availableAmountOfFuel) {
            throw new TooBigOrderException(name + "\'s order is too big");
        }

        decreaseAvailableAmountOfFuel(petrolRequest);
    }

    private void fillUpTheCar(int petrolRequest) {
        try {
            Thread.sleep((long) (Math.random() * 10000 + 3000));
            decreaseAmountOfFuelAtCistern(petrolRequest);
        } catch (InterruptedException e) {
            leavePetrolStation();
            throw new RuntimeException(e);
        }
    }

    private synchronized void decreaseAmountOfFuelAtCistern(int petrolRequest) {
        amountOfFuelAtCistern -= petrolRequest;
    }

    private synchronized void decreaseAvailableAmountOfFuel(int petrolRequest) {
        availableAmountOfFuel -= petrolRequest;
    }

    private synchronized void waitInLine() {
        if (isOverFlowed()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private synchronized void leavePetrolStation() {
        numberOfBusyDispensers.decrementAndGet();
        notify();
    }
}
