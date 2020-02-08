package com.example.arsla.clever_currency_exchange;

public class RUB extends Currency {
    public RUB(String name, double multiplier) {
        super(name, multiplier);
    }

    @Override
    public String toString(){

        return getName();
    }
}
