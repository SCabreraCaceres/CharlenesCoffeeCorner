package com.assignment;

import java.math.BigDecimal;

public abstract class Product {
    Boolean free = false;

    public abstract BigDecimal getPrice();

    public void makeFree(){
        free = true;
    }

    public abstract String getName();
}
