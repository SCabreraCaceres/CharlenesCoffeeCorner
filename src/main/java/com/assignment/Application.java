package com.assignment;

import static com.assignment.Printer.printReceipt;

import com.assignment.beverage.MediumCoffee;
import com.assignment.beverage.OrangeJuice;
import com.assignment.beverage.SmallCoffee;
import com.assignment.extra.ExtraMilk;
import com.assignment.snacks.BaconRoll;

public class Application {
    public static void main(String[] args) {
        // Implementation of test case 13
        Order order = createOrder();

        // Client owns a stamps card with four stamps, so he gets a free beverage
        order.addAFreeBeverageWithStampsCard();
        order.sendOrder();

        System.out.println(printReceipt(order));
    }

    private static Order createOrder() {
        Order order = new Order();
        SmallCoffee smallCoffee = new SmallCoffee();
        MediumCoffee mediumCoffee = new MediumCoffee();
        OrangeJuice orangeJuice = new OrangeJuice();
        BaconRoll baconRoll = new BaconRoll();
        ExtraMilk extraMilk = new ExtraMilk();
        order.addProduct(smallCoffee);
        order.addProduct(mediumCoffee);
        order.addProduct(orangeJuice);
        order.addProduct(baconRoll);
        order.addProduct(extraMilk);

        return order;
    }
}
