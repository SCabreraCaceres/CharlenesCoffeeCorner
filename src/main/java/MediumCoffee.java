import java.math.BigDecimal;

public class MediumCoffee implements Product {
    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(3);
    }
}
