package com.beicai.wissy.entity;

/**
 * Created by wissy on 2015/11/18.
 */
public class DVD {
    private String name;
    int states;
    String date;

    public DVD() {
    }

    public DVD(String name, int states, String date) {
        this.name = name;
        this.states = states;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStates() {
        return states;
    }

    public void setStates(int states) {
        this.states = states;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
