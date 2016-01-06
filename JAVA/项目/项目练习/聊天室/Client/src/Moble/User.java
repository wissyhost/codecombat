package Moble;

import java.io.Serializable;
import java.net.InetAddress;
import java.util.ArrayList;

/**
 * Created by wissy on 2015/12/9.
 */
public class User implements Serializable {
    private int id;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String passwd;
    private String name;
    private String ip;
    private InetAddress inetAddress ;

    public ArrayList<Content> getoMessage() {
        return oMessage;
    }

    public void setoMessage(ArrayList<Content> oMessage) {
        this.oMessage = oMessage;
    }

    private ArrayList<Content> oMessage=new ArrayList<Content>();

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public void setInetAddress(InetAddress inetAddress) {
        this.inetAddress = inetAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public User() {
    }

    private int port;
    public User( int id,String name, String passwd, boolean status,  String ip,int port, InetAddress inetAddress, ArrayList<Content> oMessage) {
        this.port = port;
        this.id = id;
        this.status = status;
        this.passwd = passwd;
        this.name = name;
        this.ip = ip;
        this.inetAddress = inetAddress;
        this.oMessage = oMessage;
    }
}
