package com.example.arsla.clever_currency_exchange;

public class USD extends Currency {

    public USD(String name, double multiplier) {
        super(name, multiplier);
    }


    @Override
    public String toString(){

        return getName();
    }
}
