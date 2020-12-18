import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class UseCasesTest {

    @Test
    void buysSmallCoffeeNoExtrasGetsReceipt(){
        SmallCoffee smallCoffee = new SmallCoffee();
        Receipt receipt = new Receipt();
        receipt.addProduct(smallCoffee);

        assertEquals(receipt.getTotalAmount(), BigDecimal.valueOf(2.50));
    }

    @Test
    void buysMediumCoffeeNoExtrasGetsReceipt(){
        MediumCoffee mediumCoffee = new MediumCoffee();
        Receipt receipt = new Receipt();
        receipt.addProduct(mediumCoffee);

        assertEquals(receipt.getTotalAmount(), BigDecimal.valueOf(3));
    }

}
