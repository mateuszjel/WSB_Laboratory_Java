public class Car {
    final String producer;
    final String model;
    String millage, color;
    Integer power;
    Car(String producent, String model ){
        this.producer = producent;
        this.model = model;
    }

    public String toString(){
        return "Producer: " + this.producer + " Model: " + this.model;
    }
}
