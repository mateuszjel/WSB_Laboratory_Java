package devices;

public class Car extends Device {
    String millage, color;
    Integer power;

    public Car(String producer, String model, Integer yearOfProduction, Double value){
        super(producer, model, yearOfProduction, value);
    }

    public Double getValue() {
        return this.value;
    }

    public String toString(){
        return "Producent: " + this.producer + ", model: " + this.model + ", wartość:" + this.value;
    }
}
