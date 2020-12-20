import java.math.BigDecimal;

public class SmallCoffee extends Beverage {

    public static final String NAME = "Small Coffee";

    public BigDecimal getPrice() {
        return BigDecimal.valueOf(2.50);
    }

    public String getName() {
        return NAME;
    }

}
