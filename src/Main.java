import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Human me = new Human();
        me.firstName = "Mateusz";
//        myCar(me);
//        myPet(me);
        System.out.println(me.getSalary());
        System.out.println(me.getSalary());
        System.out.println(me.getSalary());
        System.out.println(me.getSalary());
        mySalary(me);

    }

    static void mySalary(Human human){
        while(true){
            System.out.println("Co chcesz zrobić:");
            System.out.println("1. Odczytać wartość wynagrodzenia");
            System.out.println("2. Zmienić wynagrodzenie");
            String input = scanner.next();
            switch (input){
                case "1" -> System.out.println(human.getSalary());
                case "2" -> {
                    System.out.println("Podaj wartość wynagrodzenia:");
                    human.setSalary(Double.valueOf(scanner.next()));
                }
                default -> System.out.println("Nie zrozumiałem możesz powtórzyć");
            }
        }
    }


    static void myCar(Human human){
        System.out.println("Podaj producenta samochodu:");
        String carProducer = scanner.next();
        System.out.println("Podaj model samochodu:");
        String carModel = scanner.next();

        human.car = new Car(carProducer, carModel);
        System.out.println("Samochód producenta:"+ human.car.producer + ", model: " + human.car.model );
        System.out.println(human.car);
    }

    static void myPet(Human human){
        System.out.println("Podaj typ zwierzęcia:");
        String petSpecie = scanner.next();
        Animal pet = new Animal(petSpecie);

        pet.name = "Czarek";
        human.pet = pet;

        System.out.println(human.pet.name);

        while(true){
            System.out.println("Co chcesz zrobić:");
            System.out.println("1. Nakarmić zwierzę");
            System.out.println("2. Iść na spacer");
            String input = scanner.next();
            switch (input){
                case "1" -> human.pet.feed();
                case "2" -> human.pet.takeForAWalk();
                default -> System.out.println("Nie zrozumiałem możesz powtórzyć");
            }
        }
    }
}