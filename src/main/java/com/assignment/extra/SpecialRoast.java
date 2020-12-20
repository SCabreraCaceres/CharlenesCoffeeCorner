package com.assignment.extra;

import static java.math.BigDecimal.valueOf;

import com.assignment.Product;
import java.math.BigDecimal;

public class SpecialRoast extends Product {

    public static final String NAME = "Foamed Milk";
    public static final BigDecimal PRICE = valueOf(0.90);

    public String getName() {
        return NAME;
    }
    public BigDecimal getPrice() {
        return PRICE;
    }


}
