package devices;

import creatures.Human;

public abstract class Car extends Device {
    private String millage, color, motorType;
    protected Double fuelTank = 0.0;
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
        return "Producent: " + this.producer + ", model: " + this.model + ", wartość:" + this.value + ", rok produkcji: " + this.yearOfProduction;
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

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        Integer sellerGarageIndex = null;
        Integer buyerGarageFreeSlot = null;
        for (int i=0;i < seller.getGarageSize(); i++){
            if (seller.getCar(i) != null && seller.getCar(i).hashCode()==this.hashCode()){
                sellerGarageIndex = i;
                break;
            }
        }
        if (sellerGarageIndex == null){
            System.out.println("Sprzedający nie posiada samochodu");
            return;
        }
        for (int i=0;i < buyer.getGarageSize(); i++){
            if (buyer.getCar(i) == null){
                buyerGarageFreeSlot = i;
                break;
            }
        }
        if (buyerGarageFreeSlot == null){
            System.out.println("Kupujący nie posiada wolnych miejsc w garażu");
            return;
        }

        if (buyer.getCash() < price){
            System.out.println("Kupujący nie posiada wystarczającej ilości gotówki");
            return;
        }

        buyer.removeCash(price);
        buyer.setCar(seller.getCar(sellerGarageIndex), buyerGarageFreeSlot);
        seller.setCar(null, sellerGarageIndex);
        seller.addCash(price);
        System.out.println("Samochód został sprzedany za "+ price + " zł");
        System.out.println("Samochód sprzedającego: " + seller.getCar(sellerGarageIndex));
        System.out.println("Samochód kupującego: " + buyer.getCar(buyerGarageFreeSlot));
        System.out.println("Gotówka sprzedającego: " + seller.getCash());
        System.out.println("Gotówka kupującego: " + buyer.getCash());
    }

    public abstract void refuel();
}
