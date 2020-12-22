package com.assignment;

import static com.assignment.Printer.printReceipt;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.assignment.beverage.MediumCoffee;
import com.assignment.beverage.OrangeJuice;
import com.assignment.beverage.SmallCoffee;
import com.assignment.extra.ExtraMilk;
import com.assignment.snacks.BaconRoll;
import org.junit.jupiter.api.Test;

class PrinterTest {
    public static final String ITEM = "Item";
    public static final String QTY = "Qty";
    public static final String PRICE = "Price";
    public static final String TOTAL = "Total";
    public static final String SMALL_COFFEE = "Small Coffee";

    @Test
    void printsTicket(){
        Order order = createReceipt();

        String printedReceipt = printReceipt(order);

        assertTrue(printedReceipt.contains(ITEM));
        assertTrue(printedReceipt.contains(QTY));
        assertTrue(printedReceipt.contains(PRICE));
        assertTrue(printedReceipt.contains(TOTAL));
        assertTrue(printedReceipt.contains(SMALL_COFFEE));
    }

    private Order createReceipt() {
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

        order.addAFreeBeverageWithStampsCard();
        order.sendOrder();

        return order;
    }

}