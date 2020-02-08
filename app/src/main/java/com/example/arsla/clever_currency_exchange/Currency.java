package com.example.arsla.clever_currency_exchange;

public class Currency {

    protected String name;
    //private String name;

    protected double multiplier;


    public Currency(String name, double multiplier) {
        this.name = name;
        this.multiplier = multiplier;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }


    @Override
    public String toString(){

        return getName();
    }



}
