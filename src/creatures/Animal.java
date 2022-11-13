package creatures;

public class Animal {
    private static final Double DEFAULT_DOG_WEIGHT = 10.0;
    private static final Double DEFAULT_CAT_WEIGHT = 7.0 ;
    private static final Double DEFAULT_BIRD_WEIGHT = 4.0 ;
    private static final Double DEFAULT_HOMO_SAPIENS_WEIGHT = 75.0 ;
    protected String species;
    protected Boolean isAlive;
    protected Double weight;

    public Animal(String specie){
        this.species = specie;
        this.isAlive = true;
        switch (specie){
            case "pies" -> this.weight = DEFAULT_DOG_WEIGHT;
            case "kot" -> this.weight = DEFAULT_CAT_WEIGHT;
            case "papuga" -> this.weight = DEFAULT_BIRD_WEIGHT;
            case "homo sapiens" -> this.weight = DEFAULT_HOMO_SAPIENS_WEIGHT;
            default -> {
                System.out.println("Niepoprawna nazwa zwierzęcia");
                System.exit(0);
            }
        }
    }

    public void feed(){
        this.weight += 0.5;
        if(this.isAlive){
            System.out.println("Dzięki za żarcie");
            System.out.println("Waga zwierzaka wynosi: " + this.weight );
            return;
        }
        System.out.println("Wszystko dobrze z głową?");
    }

    public void takeForAWalk(){
        if(this.isAlive){
            this.weight -= 0.5;
            System.out.println("Dzięki za spacer");
            System.out.println("Waga zwierzaka wynosi: " + this.weight );
        }
        else {
            System.out.println("Dzwonię na policję...");
            return;
        }
        if(this.weight < 0){
            this.isAlive = false;
            System.out.println("Zwierzę zdechło");
            System.out.println("Dzwonię na policję...");
        }
    }

    public String toString(){
        return "Gatunek: " + this.species + ", żyje: " + this.isAlive + ", waga:" + this.weight;
    }
}
