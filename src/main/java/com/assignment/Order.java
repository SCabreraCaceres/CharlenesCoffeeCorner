package com.assignment;

import static java.util.Comparator.comparing;

import com.assignment.beverage.Beverage;
import com.assignment.extra.ExtraMilk;
import com.assignment.snacks.BaconRoll;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Product> products = new ArrayList<>();
    private BigDecimal amount;
    private boolean freeBeverage = false;

    public List<Product> getProducts() {
        return products;
    }

    public void sendOrder() {
        checkFreeExtra();
        checkFreeBeverage();
        amount = products.stream()
                .filter(product -> !product.free)
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalAmount() {
        return amount;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addAFreeBeverageWithStampsCard(){
        freeBeverage = true;
    }

    private void checkFreeExtra() {
        if(freeExtra()) {
            products.stream()
                    .filter(product -> product instanceof ExtraMilk)
                    .min(comparing(Product::getPrice))
                    .ifPresent(Product::makeFree);
        }
    }

    private void checkFreeBeverage() {
        if(freeBeverage) {
            products.stream()
                    .filter(product -> product instanceof Beverage)
                    .min(comparing(Product::getPrice))
                    .ifPresent(Product::makeFree);
        }
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
