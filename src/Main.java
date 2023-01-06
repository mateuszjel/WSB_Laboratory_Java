import creatures.Animal;
import creatures.Human;
import creatures.Pet;
import devices.Car;
import devices.Phone;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Human me = new Human("Mateusz", "Kowalski");
//        myCar(me);
        myPet(me);
//        mySalary(me);
//        carComparison();
//        printToStringFunction();
//        useDeviceBaterry();
//        sellPet(me);
//        sellCar(me);
    }

    static void sellCar(Human seller){
        Human buyer = new Human("Adam", "Nowak");
        buyer.setSalary(3000.0);
        buyer.giveSalary();
        seller.setSalary(50000.0);
        seller.buyCar(new Car("Mitsubishi", "Lancer",2014, 40000.0, "elektryczny"));
        seller.getCar().sell(seller,buyer,2000.0);
    }

    static void  sellPet(Human seller){
        Human buyer = new Human("Adam", "Nowak");
        buyer.setSalary(3000.0);
        buyer.giveSalary();
        seller.setPet(new Pet("pies"));
        seller.getPet().sell(seller,buyer,2000.0);




    }

    static void useDeviceBaterry(){
        Car car = new Car("Mitsubishi", "Lancer",2014, 40000.0, "elektryczny");
        Phone phone = new Phone("Vivo","Y33s", 2021, 1200.0);
        car.recharge(50);
        phone.recharge(50);
        phone.turnOn(5);
        car.turnOn(20);
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
        Car car = new Car("Mitsubishi", "Lancer",2014, 40000.0, "benzyna");
        Human human = new Human("Jan", "Kowalski");
        Animal animal = new Pet("papuga");
        Phone phone = new Phone("Vivo","Y33s", 2021, 1200.0);
        System.out.println("Samochód: "+ car);
        System.out.println("Człowiek: "+ human);
        System.out.println("Zwierzę: "+ animal);
        System.out.println("Telefon: "+ phone);
    }

    static void carComparison(){
        Car car1 = new Car("Mitsubishi", "Lancer",2014,40000.0, "benzyna");
        Car car2 = new Car("Mitsubishi", "Lancer",2014, 40000.0, "benzyna");
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
        System.out.println("Podaj rok produkcji:");
        Integer yearOfProduction = Integer.parseInt(scanner.next());
        System.out.println("Podaj wartość samochodu:");
        String carValue = scanner.next();
        System.out.println("Podaj typ silnika:");
        String motorType = scanner.next();

        human.buyCar(new Car(carProducer, carModel, yearOfProduction, Double.valueOf(carValue), motorType));
//        System.out.println("Samochód producenta:"+ human.car.producer + ", model: " + human.car.model );
        System.out.println(human.getCar());
    }

    static void myPet(Human human){
        System.out.println("Podaj typ zwierzęcia:");
        String petSpecie = scanner.next();
        Pet pet = new Pet(petSpecie);

        pet.setName("Czarek");
        human.setPet(pet);

        System.out.println(human.getPet().getName());

        while(true){
            System.out.println("Co chcesz zrobić:");
            System.out.println("1. Nakarmić zwierzę");
            System.out.println("2. Iść na spacer");
            String input = scanner.next();
            switch (input){
                case "1" -> human.getPet().feed();
                case "2" -> human.getPet().takeForAWalk();
                default -> System.out.println("Nie zrozumiałem możesz powtórzyć");
            }
        }
    }
}