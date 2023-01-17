package creatures;

import creatures.Animal;
import creatures.Pet;
import devices.Car;
import java.util.ArrayList;
import devices.Phone;

import java.time.LocalDateTime;

public class Human extends Animal {
    private static final Integer DEFAULT_GARAGE_SIZE =5;
    final private String firstName, lastName;
    private Double salary = 0.0;
    private Double cash = 0.0;
    private String[] salaryHistory = new String[100];
    private Integer salaryHistoryLength = 0;
    private Pet pet;
    private Car[] garage;
    private Phone phone;

    public Human(String firstName, String lastName, Integer garageSize){
        super("homo sapiens");
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = 0.0;
        this.garage = new Car[garageSize];
    }

    public Human(String firstName, String lastName){
        this(firstName,lastName, DEFAULT_GARAGE_SIZE);
    }

    public Integer getGarageSize(){
        return this.garage.length;
    }
    public Car getCar(Integer parkingNumber) {
        return this.garage[parkingNumber];
    }

    public void setCar(Car car, Integer parkingNumber) {
        garage[parkingNumber] = car;
    }

    public Double getGarageValue(){
        Double garageValue = 0.0;
        for (Car car:garage) {
            garageValue += car.getValue();
        }
        return garageValue;
    }

    public Car[] sortCarsByYear(){
        Car helper;
        for (int i = 0; i < this.garage.length; i++) {
            for (int j=i;j < this.garage.length; j++) {
                if (this.garage[j].getYearOfProduction() < this.garage[i].getYearOfProduction()){
                    helper = this.garage[j];
                    this.garage[j] = this.garage[i];
                    this.garage[i] = helper;
                }
            }
        }
        return garage;
    }

    public Integer buyCar(Car car) {
        Integer carIndex = null;
        System.out.println(car.getValue());
        if (car.getValue()/12 >= this.salary){
            System.out.println("Nie zakupiono samochodu, zapisz się na studia i znajdź nową robotę albo idź po podwyżkę");
        } else {
            for (int i = 0; i < this.getGarageSize(); i++) {
                if (this.getCar(i) == null) {
                    this.setCar(car, i);
                    carIndex = i;
                    break;
                }
            }
            if (carIndex == null) {
                System.out.println("Brak miejsca w garażu");
            } else {
                if (car.getValue() < this.salary){
                    System.out.println("Udało się zakupić samochód za gotówkę");
                }else{
                    System.out.println("Udało się zakupić samochód na kredyt");
                }
            }
        }
        return carIndex;
    }

    public String getSalary(){
        salaryHistory[salaryHistoryLength] = LocalDateTime.now() + " odczytano wartość: " + salary + "\n";
        String result = "Aktualna wypłata wynosi: " + salary + "zł\nHistoria pobrania i zmian danych o wypłacie:\n";
        for (int i = 0; i<salaryHistoryLength; i++){
            result += salaryHistory[i];
        }
        salaryHistoryLength += 1;
        return result;
    }

    public void setSalary(Double salary){
        if (salary < 0){
            System.out.println("Wypłata nie może być liczbą ujemną");
        }
        salaryHistory[salaryHistoryLength] = LocalDateTime.now() + " zmieniono wartość na: " + salary + "\n";
        salaryHistoryLength +=1;
        System.out.println("Należy odebrać aneks do umowy z kadr.");
        System.out.println("ZUS i US otrzymały informację o zmianie wartości wynagrodzenia.");
        this.salary = salary;
    }

    public Double getCash(){
        return this.cash;
    }
    public void addCash(Double value){
        this.cash += value;
    }
    public void removeCash(Double value){
        this.cash -= value;
    }

    public void  giveSalary(){
        this.addCash(this.salary);
    }

    public Pet getPet(){
        return this.pet;
    }
    public void setPet(Pet pet){
        this.pet = pet;
    }

    public Phone getPhone() {
        return phone;
    }
    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String toString(){
        return "Imię: " + this.firstName + ", Nazwisko: " + this.lastName ;
    }

}
