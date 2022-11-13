package devices;

public class Phone extends Device{
    String operatingSystem="N/A";

    public Phone(String producer, String model, Integer yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value);
    }

    @Override
    void recharge(Integer percentage) {
        this.batteryStatus += percentage;
        if (batteryStatus > 100.0){
            System.out.println("Bateria została przeładowana");
            this.batteryStatus = 100.0;
        }
    }

    public void setOperatingSystem(String system){
        this.operatingSystem = system;
    }

    public String toString(){
        return "Producent: " + this.producer + ", model: " + this.model + ", rok produkcji: " + this.yearOfProduction + ", system operacyjny: "+this.operatingSystem;
    }
}
