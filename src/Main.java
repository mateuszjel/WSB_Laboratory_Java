import devices.Car;
import devices.Phone;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Human me = new Human("Mateusz", "Kowalski");
//        myCar(me);
//        myPet(me);
//        mySalary(me);
//        carComparison();
        printToStringFunction();
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

    static void printToStringFunction(){
        Car car = new Car("Mitsubishi", "Lancer", 40000.0);
        Human human = new Human("Jan", "Kowalski");
        Animal animal = new Animal("papuga");
        Phone phone = new Phone("Vivo","Y33s", 2021);
        System.out.println("Samochód: "+ car);
        System.out.println("Człowiek: "+ human);
        System.out.println("Zwierzę: "+ animal);
        System.out.println("Telefon: "+ phone);
    }

    static void carComparison(){
        Car car1 = new Car("Mitsubishi", "Lancer",40000.0);
        Car car2 = new Car("Mitsubishi", "Lancer",40000.0);
        System.out.println("Funkcja equals: " + car1.equals(car2));
        System.out.println("car1 hashcode: " + car1.hashCode());
        System.out.println("car2 hashcode: " + car2.hashCode());
        System.out.println("car1 print: " + car1);
        System.out.println("car2 print: " + car2);
    }

    static void myCar(Human human){
        System.out.println("Podaj producenta samochodu:");
        String carProducer = scanner.next();
        System.out.println("Podaj model samochodu:");
        String carModel = scanner.next();
        System.out.println("Podaj wartość samochodu:");
        String carValue = scanner.next();

        human.setCar(new Car(carProducer, carModel, Double.valueOf(carValue)));
//        System.out.println("Samochód producenta:"+ human.car.producer + ", model: " + human.car.model );
        System.out.println(human.getCar());
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