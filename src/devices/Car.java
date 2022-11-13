package devices;

public class Car extends Device {
    private String millage, color, motorType;
    private Integer power;

    public Car(String producer, String model, Integer yearOfProduction, Double value, String motorType){
        super(producer, model, yearOfProduction, value);
        this.motorType = motorType;
    }

    @Override
    void recharge(Integer percentage) {
        if(motorType != "elektryczny"){
            System.out.println("Ładować można tylko elektryczne samochody");
            return;
        }
        this.batteryStatus += percentage;
    }

    public Double getValue() {
        return this.value;
    }

    public String toString(){
        return "Producent: " + this.producer + ", model: " + this.model + ", wartość:" + this.value;
    }
}
