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

    @Test
    void buysSmallCoffeeAndBaconRollGetsReceipt(){
        SmallCoffee smallCoffee = new SmallCoffee();
        BaconRoll baconRoll = new BaconRoll();
        Receipt receipt = new Receipt();
        receipt.addProduct(smallCoffee);
        receipt.addProduct(baconRoll);

        assertEquals(receipt.getTotalAmount(), BigDecimal.valueOf(7.0));
    }

    @Test
    void buysSmallCoffeeAndOrangeJuiceGetsReceipt(){
        SmallCoffee smallCoffee = new SmallCoffee();
        OrangeJuice orangeJuice = new OrangeJuice();
        Receipt receipt = new Receipt();
        receipt.addProduct(smallCoffee);
        receipt.addProduct(orangeJuice);

        assertEquals(receipt.getTotalAmount(), BigDecimal.valueOf(6.45));
    }

    @Test
    void buysSmallCoffeeAndBaconRollAndOrangeJuiceGetsReceipt(){
        SmallCoffee smallCoffee = new SmallCoffee();
        BaconRoll baconRoll = new BaconRoll();
        OrangeJuice orangeJuice = new OrangeJuice();
        Receipt receipt = new Receipt();
        receipt.addProduct(smallCoffee);
        receipt.addProduct(baconRoll);
        receipt.addProduct(orangeJuice);

        assertEquals(receipt.getTotalAmount(), BigDecimal.valueOf(10.95));
    }

    // TODO Implement test cases 3, 5, 6, 8, 9
}
