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
        Receipt receipt = new Receipt();
        SmallCoffee smallCoffee = new SmallCoffee();
        MediumCoffee mediumCoffee = new MediumCoffee();
        OrangeJuice orangeJuice = new OrangeJuice();
        BaconRoll baconRoll = new BaconRoll();
        ExtraMilk extraMilk = new ExtraMilk();
        receipt.addProduct(smallCoffee);
        receipt.addProduct(mediumCoffee);
        receipt.addProduct(orangeJuice);
        receipt.addProduct(baconRoll);
        receipt.addProduct(extraMilk);
        receipt.freeBeverage();
        receipt.checkExtras();
        receipt.checkFreeBeverage();
        String printedReceipt = printReceipt(receipt);
        assertTrue(printedReceipt.contains(ITEM));
        assertTrue(printedReceipt.contains(QTY));
        assertTrue(printedReceipt.contains(PRICE));
        assertTrue(printedReceipt.contains(TOTAL));
        assertTrue(printedReceipt.contains(SMALL_COFFEE));
        System.out.println(printedReceipt);
    }

}