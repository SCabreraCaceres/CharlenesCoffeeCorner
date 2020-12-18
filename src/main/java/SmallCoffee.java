import java.math.BigDecimal;

public class SmallCoffee implements Product{
    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(2.50);
    }
}
