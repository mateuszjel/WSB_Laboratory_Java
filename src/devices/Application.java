package devices;

import java.net.URL;

public class Application {
    private String name;
    private String version;
    private Double price;
    private String serverAddress;
    private Integer serverPort;
    private URL urlAddress;
    public Application(String name, String version, String serverAddress, Integer serverPort, Double price){
        this.name = name;
        this.version = version;
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
        this.price = price;
    }

    public Application(URL url, Double price){
        this.urlAddress = url;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }

    public Double getPrice(){
        return this.price;
    }

    @Override
    public String toString() {
        return "PhoneApp{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", serverAddress='" + serverAddress + '\'' +
                ", serverPort=" + serverPort +
                ", urlAddress=" + urlAddress +
                ", price=" + price +
                '}';
    }
}
