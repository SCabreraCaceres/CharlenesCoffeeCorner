package com.assignment;

import static java.lang.String.format;

public class Printer {
    private static final int QUANTITY = 1;
    private static final String CURRENCY = "CHF";

    public static String printReceipt(Receipt receipt) {
        StringBuilder f = new StringBuilder(format("%-15s\n", "Thanks for visiting Charlene's Coffee Shop"));
        f.append(format("%-15s\n", "********************************"));
        f.append(format("%-15s %5s %10s\n", "Item", "Qty", "Price"));
        f.append(format("%-15s %5s %10s\n", "----", "---", "-----"));
        for (Product product : receipt.getProducts()) {
            f.append(format("%-15.15s %5d %10.2f %-15.15s\n", product.getName(), QUANTITY, product.getPrice(),
                    showFreeItem(product)));
        }
        f.append(format("%-15s %5s %10s\n", "", "", "-----"));
        f.append(format("%-15s %5s %10.2f %3s\n", "Total", "", receipt.getTotalAmount(), CURRENCY));
        return f.toString();
    }

    private static String showFreeItem(Product product){
       return product.isFree() ? "**free item" : "";
    }
}
