package devices;

public class Phone extends Device{
    String operatingSystem="N/A";

    public Phone(String producer, String model, Integer yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value);
    }

    public void setOperatingSystem(String system){
        this.operatingSystem = system;
    }

    public String toString(){
        return "Producent: " + this.producer + ", model: " + this.model + ", rok produkcji: " + this.yearOfProduction + ", system operacyjny: "+this.operatingSystem;
    }
}
