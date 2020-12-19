import java.math.BigDecimal;

public class OrangeJuice implements Product {
    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(3.95);
    }
}
