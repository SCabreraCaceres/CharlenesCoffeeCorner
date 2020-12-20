package com.assignment;

import static java.util.Comparator.comparing;

import com.assignment.beverage.Beverage;
import com.assignment.extra.ExtraMilk;
import com.assignment.snacks.BaconRoll;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final List<Product> products = new ArrayList<>();
    private boolean freeBeverage = false;

    public List<Product> getProducts() {
        return products;
    }

    public BigDecimal getTotalAmount() {
        return products.stream()
                .filter(product -> !product.free)
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void checkExtras() {
        if(freeExtra()) {
            products.stream()
                    .filter(product -> product instanceof ExtraMilk)
                    .min(comparing(Product::getPrice))
                    .ifPresent(Product::makeFree);
        }
    }

    public void checkFreeBeverage() {
        if(freeBeverage) {
            products.stream()
                    .filter(product -> product instanceof Beverage)
                    .min(comparing(Product::getPrice))
                    .ifPresent(Product::makeFree);
        }
    }

    public void freeBeverage(){
        freeBeverage = true;
    }

    private boolean freeExtra() {
        boolean snack = false;
        boolean beverage = false;

        for (Product product : products) {
            if(product instanceof BaconRoll){
                snack = true;
            }
            if(product instanceof Beverage){
                beverage = true;
            }
        }
        return snack && beverage;
    }

}
