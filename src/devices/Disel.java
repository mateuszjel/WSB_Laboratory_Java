package devices;

public class Disel extends Car {
    public Disel(String producer, String model, Integer yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value, "disel");
    }

    @Override
    public void refuel() {
        this.fuelTank = 100.0;
    }
}
