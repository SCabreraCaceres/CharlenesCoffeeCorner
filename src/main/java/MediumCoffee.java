import java.math.BigDecimal;

public class MediumCoffee extends Beverage {

    public static final String NAME = "Medium Coffee";

    public BigDecimal getPrice() {
        return BigDecimal.valueOf(3);
    }

    public String getName() {
        return NAME;
    }

}
