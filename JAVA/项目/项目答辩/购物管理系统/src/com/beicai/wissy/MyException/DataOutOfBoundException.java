package com.beicai.wissy.MyException;

/**
 * Created by wissy on 2015/11/18.
 */
public class DataOutOfBoundException extends Exception {
    public DataOutOfBoundException() {
        super("数据超出界限异常");
    }
    public DataOutOfBoundException(String messsing) {
        super(messsing+"超出界限异常了");
    }

}
