package devices;

import creatures.Human;

import java.util.ArrayList;

public abstract class Car extends Device {
    private String millage, color, motorType;
    private ArrayList<Human> owners = new ArrayList<Human>();
    protected Double fuelTank = 0.0;
    private Integer power;

    public Car(String producer, String model, Integer yearOfProduction, Double value, String motorType){
        super(producer, model, yearOfProduction, value);
        this.motorType = motorType;
    }

    public void addOwner(Human newOwner){
        owners.add(newOwner);
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

    public Boolean wasOwner(Human human){
        for(Human owner: this.owners){
            if(owner.hashCode() == human.hashCode()){
                return true;
            }
        }
        return false;
    }

    public Boolean wasSell(Human seller, Human buyer){
        if (this.owners.size() < 2){
            return false;
        }
        for(int i=1;i < this.owners.size(); i++){
            if(this.owners.get(i).hashCode() == buyer.hashCode() && this.owners.get(i-1).hashCode() == seller.hashCode()){
                return true;
            }
        }
        return false;
    }

    public Integer getTransactionsCount(){
        if (this.owners.size() == 0){
            return 0;
        }
        return this.owners.size()-1;
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
        if (sellerGarageIndex == null || this.owners.get(this.owners.size() - 1).hashCode() != seller.hashCode()){
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

        this.owners.add(buyer);
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
