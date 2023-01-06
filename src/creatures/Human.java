package creatures;

import creatures.Animal;
import creatures.Pet;
import devices.Car;
import devices.Device;
import devices.Phone;

import java.time.LocalDateTime;

public class Human extends Animal {
    final private String firstName, lastName;
    private Double salary = 0.0;
    private Double cash = 0.0;
    private String[] salaryHistory = new String[100];
    private Integer salaryHistoryLength = 0;
    private Pet pet;
    private Car car;
    private Phone phone;

    public Human(String firstName, String lastName){
        super("homo sapiens");
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = 0.0;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void buyCar(Car car) {
        System.out.println(car.getValue());

        if (car.getValue()/12 >= this.salary){
            System.out.println("Nie zakupiono samochodu, zapisz się na studia i znajdź nową robotę albo idź po podwyżkę");
            return;
        }
        if (car.getValue() < this.salary){
            System.out.println("Udało się zakupić samochód za gotówkę");
            this.car = car;
        }
        else if (car.getValue()/12 < this.salary){
            System.out.println("Udało się zakupić samochód na kredyt");
        }
        this.car = car;
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
