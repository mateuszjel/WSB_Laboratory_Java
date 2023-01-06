package devices;

import creatures.Human;

import java.net.URL;

public class Phone extends Device{
    String operatingSystem="N/A";
    static final String defaultServerAddress = "127.0.0.1";
    static final Integer serverPort = 80;
    static final String defaultVersion = "1.5.2";
    private PhoneApp[] installedApplications = new PhoneApp[100];
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
        System.out.println("Telefon sprzedającego: " + seller.getCar());
        System.out.println("Telefon kupującego: " + buyer.getCar());
        System.out.println("Gotówka sprzedającego: " + seller.getCash());
        System.out.println("Gotówka kupującego: " + buyer.getCash());
    }

    public void installAnnApp(String name){
        installedApplications[applicationsCount] = new PhoneApp(name, defaultVersion,defaultServerAddress,serverPort);
        applicationsCount +=1;
    }
    public void installAnnApp(String name, String version){
        installedApplications[applicationsCount] = new PhoneApp(name, version,defaultServerAddress,serverPort);
        applicationsCount +=1;
    }
    public void installAnnApp(String name, String version, String serverAddress){
        installedApplications[applicationsCount] = new PhoneApp(name, version,serverAddress,serverPort);
        applicationsCount +=1;
    }
    public void installAnnApp(String[] appNames){
        for (String appName:appNames) {
            installedApplications[applicationsCount] = new PhoneApp(appName, defaultVersion,defaultServerAddress,serverPort);
            applicationsCount +=1;
        }
    }
    public void installAnnApp(URL url){
        installedApplications[applicationsCount] = new PhoneApp(url);
        applicationsCount +=1;
    }

    public void  getApplications(){
        for (Integer i=0; i<applicationsCount; i++){
            System.out.println(installedApplications[i]);
        }
    }
}
