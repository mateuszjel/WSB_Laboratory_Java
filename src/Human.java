import java.time.LocalDateTime;

public class Human {
    String firstName, lastName;
    private Double salary = 3200.0;
    private String[] salaryHistory = new String[100];
    private Integer salaryHistoryLength = 0;
    Animal pet;
    Car car;

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

}
