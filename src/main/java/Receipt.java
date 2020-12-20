import static java.lang.String.format;
import static java.util.Comparator.comparing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    public static final int QUANTITY = 1; // TODO implement quantity logic
    private final List<Product> products = new ArrayList<>();
    private boolean freeBeverage = false;

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

    public String printReceipt() {
        StringBuilder f = new StringBuilder(format("%-15s %5s %10s\n", "Item", "Qty", "Price"));
        f.append(format("%-15s %5s %10s\n", "----", "---", "-----"));
        for (Product product : products) {
            f.append(format("%-15.15s %5d %10.2f\n", product.getName(), QUANTITY, product.getPrice()));
        }
        f.append(format("%-15s %5s %10.2f\n", "Tax", "", 0.0)); // TODO add taxes logic
        f.append(format("%-15s %5s %10s\n", "", "", "-----"));
        f.append(format("%-15s %5s %10.2f\n", "Total", "", getTotalAmount()));
        return f.toString();
    }
}
