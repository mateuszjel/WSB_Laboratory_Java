public class Phone {
    final String producer, model;
    final Integer productionYear;
    String operatingSystem="N/A";

    public Phone(String producer, String model, Integer pruductionYear) {
        this.producer = producer;
        this.model = model;
        this.productionYear = pruductionYear;
    }

    public void setOperatingSystem(String system){
        this.operatingSystem = system;
    }

    public String toString(){
        return "Producer: " + this.producer + " Model: " + this.model + "Operating system: "+this.operatingSystem;
    }
}
