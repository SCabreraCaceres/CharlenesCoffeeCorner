import java.math.BigDecimal;

public class BaconRoll implements Product{
    @Override
    public BigDecimal getPrice() {
        return BigDecimal.valueOf(4.50);
    }
}
