package devices;

public class Electric  extends Car{
    public Electric(String producer, String model, Integer yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value, "elektryczny");
    }

    @Override
    public void refuel() {
        this.batteryStatus = 100.0;
    }
}
