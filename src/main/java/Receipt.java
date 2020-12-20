
import static java.util.Comparator.comparing;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final List<Product> products = new ArrayList<>();

    public BigDecimal getTotalAmount() {
        return products.stream()
                .filter(product -> !product.free)
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void checkExtras() {
        if(freeExtra()) {
            products.stream()
                    .filter(product -> product instanceof ExtraMilk)
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
