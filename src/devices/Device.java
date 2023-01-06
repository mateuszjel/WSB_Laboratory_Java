package devices;

public abstract class Device {
    protected final String producer, model;
    protected final Integer yearOfProduction;
    protected final Double value;
    protected Double batteryStatus;


    public Device(String producer, String model, Integer yearOfProduction, Double value) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.value = value;
        this.batteryStatus = 0.0;
    }

    abstract void recharge(Integer percentage);
    abstract void turnOn(Integer timeSeconds) throws InterruptedException;
}
