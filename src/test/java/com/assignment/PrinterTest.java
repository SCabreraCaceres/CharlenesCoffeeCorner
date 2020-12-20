package com.assignment;

import static org.junit.jupiter.api.Assertions.*;

import com.assignment.Printer;
import com.assignment.Receipt;
import com.assignment.beverage.SmallCoffee;
import org.junit.jupiter.api.Test;

class PrinterTest {
    public static final String ITEM = "Item";
    public static final String QTY = "Qty";
    public static final String PRICE = "Price";
    public static final String TOTAL = "Total";
    public static final String TAX = "Tax";
    public static final String SMALL_COFFEE = "Small Coffee";

    @Test
    void printsTicket(){
        Receipt receipt = new Receipt();
        SmallCoffee smallCoffee = new SmallCoffee();
        receipt.addProduct(smallCoffee);
        String text = Printer.printReceipt(receipt);
        assertTrue(text.contains(ITEM));
        assertTrue(text.contains(QTY));
        assertTrue(text.contains(PRICE));
        assertTrue(text.contains(TOTAL));
        assertTrue(text.contains(TAX));
        assertTrue(text.contains(SMALL_COFFEE));
    }

}