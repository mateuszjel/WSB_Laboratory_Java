package creatures;

public class Pet extends Animal implements Sellable {
    private String name;

    public Pet(String specie){
        super(specie);
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getPet() == null){
            System.out.println("Sprzedający nie posiada zwierzęcia");
            return;
        }
        if (buyer.getCash() < price){
            System.out.println("Kupujący nie posiada wystarczającej ilości gotówki");
            return;
        }
        buyer.removeCash(price);
        buyer.setPet(seller.getPet());
        seller.setPet(null);
        seller.addCash(price);
        System.out.println("Zwierzę zostało sprzedane za "+ price + " zł");
        System.out.println("Zwierzę sprzedającego: " + seller.getPet());
        System.out.println("Zwierzę kupującego: " + buyer.getPet());
        System.out.println("Gotówka sprzedającego: " + seller.getCash());
        System.out.println("Gotówka kupującego: " + buyer.getCash());
    }
}
