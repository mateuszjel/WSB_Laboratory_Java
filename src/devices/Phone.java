package devices;

import creatures.Human;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class Phone extends Device{
    String operatingSystem="N/A";
    static final String defaultServerAddress = "127.0.0.1";
    static final Integer serverPort = 80;
    static final String defaultVersion = "1.5.2";
    private Application[] installedApplications = new Application[100];
    private Integer applicationsCount = 0;

    public Phone(String producer, String model, Integer yearOfProduction, Double value) {
        super(producer, model, yearOfProduction, value);
    }

    @Override
    public void recharge(Integer percentage) {
        this.batteryStatus += percentage;
        if (batteryStatus > 100.0){
            System.out.println("Bateria została przeładowana");
            this.batteryStatus = 100.0;
        }
    }

    public void setOperatingSystem(String system){
        this.operatingSystem = system;
    }

    public String toString(){
        return "Producent: " + this.producer + ", model: " + this.model + ", rok produkcji: " + this.yearOfProduction + ", system operacyjny: "+this.operatingSystem;
    }

    @Override
    public void turnOn(Integer timeSeconds) {
        while (this.batteryStatus > 0 && timeSeconds > 0){
            timeSeconds -=1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.batteryStatus -= 1;
            System.out.println("Status baterii telefonu wynosi " + this.batteryStatus +"%");
        }
        if (this.batteryStatus <= 0){
            System.out.println("Bateria telefonu rozładowana");
        }
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.getPhone() == null){
            System.out.println("Sprzedający nie posiada zwierzęcia");
            return;
        }
        if (buyer.getCash() < price){
            System.out.println("Kupujący nie posiada wystarczającej ilości gotówki");
            return;
        }
        buyer.removeCash(price);
        buyer.setPhone(seller.getPhone());
        seller.setPhone(null);
        seller.addCash(price);
        System.out.println("Telefon został sprzedany za "+ price + " zł");
        System.out.println("Telefon sprzedającego: " + seller.getPhone());
        System.out.println("Telefon kupującego: " + buyer.getPhone());
        System.out.println("Gotówka sprzedającego: " + seller.getCash());
        System.out.println("Gotówka kupującego: " + buyer.getCash());
    }

    public void installAnnApp(String name, Human owner, Double price){
        this.installAnnApp(name, owner, price, defaultVersion);
    }
    public void installAnnApp(String name, Human owner, Double price, String version){
        this.installAnnApp(name, owner, price, version, defaultServerAddress);
    }
    public void installAnnApp(String name, Human owner, Double price, String version, String serverAddress){
        if (owner.getCash() < price){
            System.out.println("Nie udało się zakupić aplikacji, brak wystarczajacej ilości gotówki.");
            return;
        }
        owner.removeCash(price);
        installedApplications[applicationsCount] = new Application(name, version,serverAddress,serverPort, price);
        applicationsCount +=1;
    }
    public void installAnnApp(String[] appNames, Human owner, Double price){
        for (String appName:appNames) {
            this.installAnnApp(appName, owner, price);
        }
    }
    public void installAnnApp(URL url, Human owner, Double price){
        if (owner.getCash() < price){
            System.out.println("Nie udało się zakupić aplikacji, brak wystarczajacej ilości gotówki.");
            return;
        }
        owner.removeCash(price);
        installedApplications[applicationsCount] = new Application(url, price);
        applicationsCount +=1;
    }

    public Application getApplication(Integer index){
        return this.installedApplications[index];
    }

    public void  getApplications(){
        for (Integer i=0; i<applicationsCount; i++){
            System.out.println(installedApplications[i]);
        }
    }

    public void getFreeApplications(){
        System.out.println("Darmowe aplikacje:");
        for (int i=0; i< this.applicationsCount; i++) {
            if (this.installedApplications[i].getPrice() == 0.0){
                System.out.println(this.installedApplications[i]);
            }
        }
    }
    public void sortApplicationsByName(){
        System.out.println("Aplikacje posortowane alfabetycznie:");
        Application[] apps = new Application[this.applicationsCount];
        int count = 0;
        for (int i=0;i < this.applicationsCount;i++) {
            if (this.installedApplications[i].getName() != null){
                apps[count] = this.installedApplications[i];
                count += 1;
            }
        }
        for (int i=0; i < count; i++) {
            for (int j=i; j < count; j++) {
                if (apps[j].getName().compareTo(apps[i].getName()) < 0){
                    Application helper = apps[i];
                    apps[i] = apps[j];
                    apps[j] = helper;
                }
            }
        }
        for (int i=0; i < count; i++) {
            System.out.println(apps[i]);
        }
    }

    public void sortApplicationsByPrice(){
        System.out.println("Aplikacje posortowane po cenie:");
        Application[] apps = new Application[this.applicationsCount];
        int count = 0;
        for (int i=0;i < this.applicationsCount;i++) {
            apps[count] = this.installedApplications[i];
            count += 1;
        }
        for (int i=0; i < count; i++) {
            for (int j=i; j < count; j++) {
                if (apps[j].getPrice() < apps[i].getPrice() ){
                    Application helper = apps[i];
                    apps[i] = apps[j];
                    apps[j] = helper;
                }
            }
        }
        for (int i=0; i < count; i++) {
            System.out.println(apps[i]);
        }
    }

    public Double getAllApplicationsValue(){
        Double value = 0.0;
        for (Application app: this.installedApplications) {
                value += app.getPrice();
        }
        return value;
    }

    public Boolean isApplicationInstalled(Application app){
        for (Application installedApp: this.installedApplications){
            if (installedApp.hashCode() == app.hashCode()){
                return true;
            }
        }
        return false;
    }
    public Boolean isApplicationInstalled(String name){
        for (int i=0; i< this.applicationsCount; i++){
            if (this.installedApplications[i].getName().equals(name)){
                return true;
            }
        }
        return false;
    }
}
