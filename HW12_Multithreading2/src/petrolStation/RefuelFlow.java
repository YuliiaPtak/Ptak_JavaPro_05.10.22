package petrolStation;

public class RefuelFlow implements Runnable {
    private final int order;
    private final PetrolStation petrolStation;
    private final String name;

    public RefuelFlow(int order, PetrolStation petrolStation, String name) {
        this.order = order;
        this.petrolStation = petrolStation;
        this.name = name;
    }

    @Override
    public void run() {
        petrolStation.doRefuel(order, name);
    }
}

