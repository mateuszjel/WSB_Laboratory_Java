package devices;

public class Car extends Device {
    private String millage, color, motorType;
    private Integer power;

    public Car(String producer, String model, Integer yearOfProduction, Double value, String motorType){
        super(producer, model, yearOfProduction, value);
        this.motorType = motorType;
    }

    @Override
    public void recharge(Integer percentage) {
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

    @Override
    public void turnOn(Integer timeSeconds) {
        while (this.batteryStatus >= 3 && timeSeconds > 0){
            timeSeconds -=1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.batteryStatus -= 2;
            System.out.println("Status baterii samochodu wynosi " + this.batteryStatus +"%");
        }
        if (this.batteryStatus <= 3){
            System.out.println("Bateria baterii samochodu wynosi mniej niż 3% zabezpieczenie przed całkowitym rozładowniem");
        }
    }
}
