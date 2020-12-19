
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final List<Product> products = new ArrayList<>();

    public BigDecimal getTotalAmount() {
        return products.stream().map(Product::getPrice)
                                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addProduct(Product product) {
        this.products.add(product);

    }
}
