package petrolStation;

public class PetrolStation implements GasStation {
    private volatile int litersAtCistern;
    private volatile int amountForCreatingOrder;

    public PetrolStation(int amount) {
        this.litersAtCistern = amount;
        amountForCreatingOrder = amount;
    }

    @Override
    public void doRefuel(int request, String name) {
        try {
            createOrder(name, request);
        } catch (TooBigOrderException e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            Thread.sleep((long) (Math.random() * 10000 + 3000));
            decreaseAmount(request);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(name + " has got " + request + ", liters at cistern " + litersAtCistern);
    }

    private synchronized void decreaseAmount(int request) {
        litersAtCistern -= request;
    }

    private synchronized void createOrder(String name, int request) throws TooBigOrderException {
        System.out.println(name + " ordered " + request + " liters");
        if (request > amountForCreatingOrder) {
            throw new TooBigOrderException(name + "\'s order is too big");
        }
        amountForCreatingOrder -= request;
        System.out.println(amountForCreatingOrder + " liters left");
    }
}
