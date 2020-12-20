package com.assignment;

import static java.lang.String.format;

public class Printer {
    public static final int QUANTITY = 1; // TODO implement quantity logic

    public static String printReceipt(Receipt receipt) {
        StringBuilder f = new StringBuilder(format("%-15s %5s %10s\n", "Item", "Qty", "Price"));
        f.append(format("%-15s %5s %10s\n", "----", "---", "-----"));
        for (Product product : receipt.getProducts()) {
            f.append(format("%-15.15s %5d %10.2f\n", product.getName(), QUANTITY, product.getPrice()));
        }
        f.append(format("%-15s %5s %10.2f\n", "Tax", "", 0.0)); // TODO add taxes logic
        f.append(format("%-15s %5s %10s\n", "", "", "-----"));
        f.append(format("%-15s %5s %10.2f\n", "Total", "", receipt.getTotalAmount()));
        return f.toString();
    }
}
