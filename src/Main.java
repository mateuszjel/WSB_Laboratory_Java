import creatures.Animal;
import creatures.Human;
import creatures.Pet;
import devices.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Human me = new Human("Mateusz", "Kowalski");
//        carOwner(me);
//        myCar(me);
//        myPet(me);
//        mySalary(me);
//        carComparison();
//        printToStringFunction();
//        useDeviceBaterry();
//        sellPet(me);
//        sellCar(me);
//        sortCars(me);
        phoneApps(me);
    }

    static void carOwner(Human humanOne){
        Integer carIndex = null;
        Human humanTwo = new Human("Adam", "Nowak");
        Human humanThree = new Human("Krzysztof", "Wąski");
        Car car = new Disel("Mitsubishi", "Lancer",2013, 40000.0);
        humanOne.setSalary(5000.0);
        humanTwo.setSalary(20000.0);
        humanTwo.giveSalary();
        humanThree.setSalary(10000.0);
        humanThree.giveSalary();
        humanOne.buyCar(car);
        car.sell(humanOne,humanTwo,19999.0);
        car.sell(humanTwo,humanThree,9999.0);
        System.out.println("Czy druga była właścicielem samochodu: " + car.wasOwner(humanTwo));
        System.out.println("Czy druga osoba sprzedała samochód osobie numer jeden: " + car.wasSell(humanTwo,humanOne));
        System.out.println("Czy druga osoba sprzedała samochód osobie numer trzy: " + car.wasSell(humanTwo,humanThree));
        System.out.println("Czy samochód uczestniczył w " + car.getTransactionsCount() + " tranzakcjach");
    }

    static void sortCars(Human human){
        human.setSalary(10000.0);
        human.buyCar(new Electric("Mitsubishi", "Lancer",2014, 40000.0));
        human.buyCar(new Electric("Mitsubishi", "Lancer",2013, 40000.0));
        human.buyCar(new Electric("Mitsubishi", "Lancer",2012, 40000.0));
        human.buyCar(new Electric("Mitsubishi", "Lancer",2011, 40000.0));
        human.buyCar(new Electric("Mitsubishi", "Lancer",2010, 40000.0));
        human.sortCarsByYear();
        for(int i=0; i < human.getGarageSize(); i++){
            System.out.println(human.getCar(i));
        }
    }

    static void phoneApps(Human human){
        human.setSalary(4000.0);
        human.giveSalary();
        Phone phone = new Phone("Vivo","Y33s", 2021, 1200.0);
        phone.installAnnApp("appF", human, 500.0);
        phone.installAnnApp("appE",human, 1000.0, "2.0");
        phone.installAnnApp("appD",human, 2000.0,"2.0", "java.com");
        phone.installAnnApp(new String[]{"appC","appB"}, human, 100.0);
        phone.installAnnApp("appA", human, 0.0);
        try {
            phone.installAnnApp(new URL("https://java.com/myapp/version/2.5"), human, 5000.0);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        phone.getApplications();
        System.out.println("Czy applikacja o nazwie `app3` jest zainstalowana" + phone.isApplicationInstalled("app3"));
        System.out.println("Czy applikacja jest zainstalowana" + phone.isApplicationInstalled(phone.getApplication(0)));
        phone.getFreeApplications();
        phone.sortApplicationsByName();
        phone.sortApplicationsByPrice();
    }

    static Human sellCar(Human seller){
        Human buyer = new Human("Adam", "Nowak");
        buyer.setSalary(3000.0);
        buyer.giveSalary();
        seller.setSalary(50000.0);
        Integer carIndex = seller.buyCar(new Electric("Mitsubishi", "Lancer",2014, 40000.0));
//        seller.getCar(carIndex).sell(buyer,seller,2000.0);
        seller.getCar(carIndex).sell(seller,buyer,2000.0);
        return buyer;
    }

    static void  sellPet(Human seller){
        Human buyer = new Human("Adam", "Nowak");
        buyer.setSalary(3000.0);
        buyer.giveSalary();
        seller.setPet(new Pet("pies"));
        seller.getPet().sell(seller,buyer,2000.0);




    }

    static void useDeviceBaterry(){
        Car car = new Electric("Mitsubishi", "Lancer",2014, 40000.0);
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
        Car car = new Disel("Mitsubishi", "Lancer",2014, 40000.0);
        Human human = new Human("Jan", "Kowalski");
        Animal animal = new Pet("papuga");
        Phone phone = new Phone("Vivo","Y33s", 2021, 1200.0);
        System.out.println("Samochód: "+ car);
        System.out.println("Człowiek: "+ human);
        System.out.println("Zwierzę: "+ animal);
        System.out.println("Telefon: "+ phone);
    }

    static void carComparison(){
        Car car1 = new Disel("Mitsubishi", "Lancer",2014,40000.0);
        Car car2 = new Disel("Mitsubishi", "Lancer",2014, 40000.0);
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
        human.setSalary(4000.0);

        Integer carIndex = human.buyCar(new LPG(carProducer, carModel, yearOfProduction, Double.valueOf(carValue)));
//        System.out.println("Samochód producenta:"+ human.car.producer + ", model: " + human.car.model );
        if (carIndex != null) {
            System.out.println(human.getCar(carIndex));
        }
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