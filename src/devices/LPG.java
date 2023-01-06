package devices;

public class LPG  extends Car{
    public LPG(String producer, String model, Integer yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value, "lpg");
    }

    @Override
    public void refuel() {
        this.fuelTank = 100.0;
    }
}
