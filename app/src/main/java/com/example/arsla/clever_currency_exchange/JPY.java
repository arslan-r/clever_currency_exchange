package com.example.arsla.clever_currency_exchange;

public class JPY extends Currency {

    public JPY(String name, double multiplier) {
        super(name, multiplier);
    }

    @Override
    public String toString(){

        return getName();
    }


}
