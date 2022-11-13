package creatures;

public class Pet extends Animal {
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
}
