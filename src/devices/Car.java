package devices;

public class Car {
    final String producer;
    final String model;
    private Double value;
    String millage, color;
    Integer power;

    public Car(String producer, String model, Double value){
        this.producer = producer;
        this.model = model;
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public String toString(){
        return "Producent: " + this.producer + ", model: " + this.model + ", wartość:" + this.value;
    }
}
