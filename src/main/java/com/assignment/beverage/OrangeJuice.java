package com.assignment.beverage;

import com.assignment.beverage.Beverage;
import java.math.BigDecimal;

public class OrangeJuice extends Beverage {

    public static final String NAME = "Orange Juice";

    public BigDecimal getPrice() {
        return BigDecimal.valueOf(3.95);
    }

    public String getName() {
        return NAME;
    }

}
