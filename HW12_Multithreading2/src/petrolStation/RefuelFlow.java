package petrolStation;

public class RefuelFlow implements Runnable {
    private final int order;
    private final GasStation gasStation;
    private final String name;

    public RefuelFlow(int order, GasStation gasStation, String name) {
        this.order = order;
        this.gasStation = gasStation;
        this.name = name;
    }

    @Override
    public void run() {
        gasStation.doRefuel(order, name);
    }
}

