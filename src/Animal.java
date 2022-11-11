public class Animal {
    private static final Double DEFAULT_DOG_WEIGHT = 10.0;
    private static final Double DEFAULT_CAT_WEIGHT = 7.0 ;
    private static final Double DEFAULT_BIRD_WEIGHT = 4.0 ;
    String species, name;
    Boolean isAlive;
    private Double weight;

    Animal(String specie){
        this.species = specie;
        this.isAlive = true;
        switch (specie){
            case "pies" -> this.weight = DEFAULT_DOG_WEIGHT;
            case "kot" -> this.weight = DEFAULT_CAT_WEIGHT;
            case "papuga" -> this.weight = DEFAULT_BIRD_WEIGHT;
            default -> {
                System.out.println("Niepoprawna nazwa zwierzęcia");
                System.exit(0);
            }
        }
    }

    void feed(){
        this.weight += 0.5;
        if(this.isAlive){
            System.out.println("Dzięki za żarcie");
            System.out.println("Waga zwierzaka wynosi: " + this.weight );
            return;
        }
        System.out.println("Wszystko dobrze z głową?");
    }

    void takeForAWalk(){
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
