package petrolStation;

public class Main {

    public static void main(String[] args) {
        GasStation petrolStation = new PetrolStation(50, 3);

        petrolStation.doRefuel(15, "Bob");
        petrolStation.doRefuel(4, "Kirk");
        petrolStation.doRefuel(300, "David");
        petrolStation.doRefuel(7, "Jack");
        petrolStation.doRefuel(9, "Rick");
    }
}
