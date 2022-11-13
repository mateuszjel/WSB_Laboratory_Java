package creatures;

public class FarmAnimal extends Animal implements Edible{


    public FarmAnimal(String specie){
        super(specie);
    }

    @Override
    public void beEaten() throws Exception {
        this.isAlive = false;
        this.weight = 0.0;
        System.out.println("Właśnie zjadłeś zwierzę");
    }

    @Override
    public boolean isPoisoned() {
        switch (this.species){
            case "rabbit", "hamster" -> {return false;}
            default -> {return true;}
        }
    }
}
