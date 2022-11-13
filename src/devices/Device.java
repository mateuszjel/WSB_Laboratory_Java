package devices;

public class Device {
    protected final String producer, model;
    protected final Integer yearOfProduction;
    protected final Double value;


    public Device(String producer, String model, Integer yearOfProduction, Double value) {
        this.producer = producer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.value = value;
    }
}
