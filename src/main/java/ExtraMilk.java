import java.math.BigDecimal;

public class ExtraMilk extends Product {

    public static final String NAME = "Extra Milk";

    public BigDecimal getPrice() {
        return BigDecimal.valueOf(0.30);
    }

    public String getName() {
        return NAME;
    }

}
