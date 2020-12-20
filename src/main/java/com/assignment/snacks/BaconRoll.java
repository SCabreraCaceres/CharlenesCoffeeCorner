package com.assignment.snacks;

import com.assignment.Product;
import java.math.BigDecimal;

public class BaconRoll extends Product {

    public static final String NAME = "Bacon Roll";

    public BigDecimal getPrice() {
        return BigDecimal.valueOf(4.50);
    }

    public String getName() {
        return NAME;
    }

}
