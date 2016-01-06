package Moble;


import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wissy on 2015/12/8.
 */
public class Content implements Serializable{
    public static  final String receive="receive";

    public String getCmd() {
        return cmd;
    }

    public Content() {
    }

    public void setCmd(String cmd) {

        this.cmd = cmd;
    }


    private String cmd;
    private Object value1;               //昵称
    private Object value2;         //聊天内容
    private Object value3;
    private Object value4;
    private int number;
    private InetAddress serverAddress;
    private InetAddress sendAddress;

    public Object getValue1() {
        return value1;
    }

    public void setValue1(Object value1) {
        this.value1 = value1;
    }

    public Object getValue2() {
        return value2;
    }

    public void setValue2(Object value2) {
        this.value2 = value2;
    }

    public Object getValue3() {
        return value3;
    }

    public void setValue3(Object value3) {
        this.value3 = value3;
    }

    public Object getValue4() {
        return value4;
    }

    public void setValue4(Object value4) {
        this.value4 = value4;
    }

    public InetAddress getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(InetAddress serverAddress) {
        this.serverAddress = serverAddress;
    }

    public InetAddress getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(InetAddress sendAddress) {
        this.sendAddress = sendAddress;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Content(String cmd, Object value1, Object value2, Object value3, Object value4, InetAddress serverAddress, InetAddress sendAddress) {
        this.cmd = cmd;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;

        this.value4 = value4;
        this.serverAddress = serverAddress;
        this.sendAddress = sendAddress;
    }
}
