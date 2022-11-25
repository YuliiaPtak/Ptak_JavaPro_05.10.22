package petrolStation;

public class PetrolStation implements GasStation {
    private volatile int actualAmount;
    private volatile int amountForCreatingOrder;

    public PetrolStation(int amount) {
        this.actualAmount = amount;
        amountForCreatingOrder = amount;
    }

    @Override
    public void doRefuel(int request, String name) {
        try {
            createOrder(name, request);
        } catch (TooBigOrderException e) {
            return;
        }

        try {
            Thread.sleep((long) (Math.random() * 10000 + 3000));
            decreaseAmount(request);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(name + " has got " + request);
    }

    private synchronized void decreaseAmount(int request) {
        actualAmount -= request;
    }

    private synchronized void createOrder(String name, int request) throws TooBigOrderException {
        System.out.println(name + " ordered " + request + " liters");
        if (request > amountForCreatingOrder) {
            System.out.println(name + "\'s order is too big");
            throw new TooBigOrderException("too big order!");
        }
        amountForCreatingOrder -= request;
        System.out.println(amountForCreatingOrder + " liters left");
    }
}
