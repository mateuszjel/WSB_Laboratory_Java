package devices;

import java.net.URL;

public class PhoneApp {
    private String name;
    private String version;
    private String serverAddress;
    private Integer serverPort;
    private URL urlAddress;
    public PhoneApp(String name, String version, String serverAddress, Integer serverPort){
        this.name = name;
        this.version = version;
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    public PhoneApp(URL url){
        this.urlAddress = url;
    }

    @Override
    public String toString() {
        return "PhoneApp{" +
                "name='" + name + '\'' +
                ", version='" + version + '\'' +
                ", serverAddress='" + serverAddress + '\'' +
                ", serverPort=" + serverPort +
                ", urlAddress=" + urlAddress +
                '}';
    }
}
