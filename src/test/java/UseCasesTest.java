import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UseCasesTest {

    public static final String ITEM = "Item";
    public static final String QTY = "Qty";
    public static final String PRICE = "Price";
    public static final String TOTAL = "Total";
    public static final String TAX = "Tax";
    public static final String SMALL_COFFEE = "Small Coffee";

    @Test
    @DisplayName("Use case 1")
    void buysSmallCoffeeNoExtrasGetsReceipt(){
        SmallCoffee smallCoffee = new SmallCoffee();
        Receipt receipt = new Receipt();
        receipt.addProduct(smallCoffee);

        assertEquals(BigDecimal.valueOf(2.50), receipt.getTotalAmount());
    }

    @Test
    @DisplayName("Use case 2")
    void buysMediumCoffeeNoExtrasGetsReceipt(){
        MediumCoffee mediumCoffee = new MediumCoffee();
        Receipt receipt = new Receipt();
        receipt.addProduct(mediumCoffee);

        assertEquals(BigDecimal.valueOf(3), receipt.getTotalAmount());
    }

    @Test
    @DisplayName("Use case 4")
    void buysSmallCoffeeAndBaconRollGetsReceipt(){
        SmallCoffee smallCoffee = new SmallCoffee();
        BaconRoll baconRoll = new BaconRoll();
        Receipt receipt = new Receipt();
        receipt.addProduct(smallCoffee);
        receipt.addProduct(baconRoll);

        assertEquals(BigDecimal.valueOf(7.0), receipt.getTotalAmount());
    }

    @Test
    @DisplayName("Use case 7")
    void buysSmallCoffeeAndOrangeJuiceGetsReceipt(){
        SmallCoffee smallCoffee = new SmallCoffee();
        OrangeJuice orangeJuice = new OrangeJuice();
        Receipt receipt = new Receipt();
        receipt.addProduct(smallCoffee);
        receipt.addProduct(orangeJuice);

        assertEquals(BigDecimal.valueOf(6.45), receipt.getTotalAmount());
    }

    @Test
    @DisplayName("Use case 10")
    void buysSmallCoffeeAndBaconRollAndOrangeJuiceGetsReceipt(){
        SmallCoffee smallCoffee = new SmallCoffee();
        BaconRoll baconRoll = new BaconRoll();
        OrangeJuice orangeJuice = new OrangeJuice();
        Receipt receipt = new Receipt();
        receipt.addProduct(smallCoffee);
        receipt.addProduct(baconRoll);
        receipt.addProduct(orangeJuice);

        assertEquals(BigDecimal.valueOf(10.95), receipt.getTotalAmount());
    }

    @Test
    @DisplayName("Use case 11")
    void withExtra(){
        SmallCoffee smallCoffee = new SmallCoffee();
        BaconRoll baconRoll = new BaconRoll();
        OrangeJuice orangeJuice = new OrangeJuice();
        ExtraMilk extraMilk = new ExtraMilk();
        Receipt receipt = new Receipt();
        receipt.addProduct(smallCoffee);
        receipt.addProduct(baconRoll);
        receipt.addProduct(orangeJuice);
        receipt.addProduct(extraMilk);

        receipt.checkExtras();

        assertEquals(BigDecimal.valueOf(10.95), receipt.getTotalAmount());
    }

    @Test
    @DisplayName("Use case 12")
    void withExtraAndFourStamps(){
        SmallCoffee smallCoffee = new SmallCoffee();
        BaconRoll baconRoll = new BaconRoll();
        OrangeJuice orangeJuice = new OrangeJuice();
        ExtraMilk extraMilk = new ExtraMilk();
        Receipt receipt = new Receipt();
        receipt.addProduct(smallCoffee);
        receipt.addProduct(baconRoll);
        receipt.addProduct(orangeJuice);
        receipt.addProduct(extraMilk);

        receipt.checkExtras();
        receipt.freeBeverage();
        receipt.checkFreeBeverage();

        assertEquals(BigDecimal.valueOf(8.45), receipt.getTotalAmount());
    }
    // TODO Implement test cases 3, 5, 6, 8, 9

    @Test
    void printsTicket(){
        Receipt receipt = new Receipt();
        SmallCoffee smallCoffee = new SmallCoffee();
        receipt.addProduct(smallCoffee);
        String text = receipt.printReceipt();
        assertTrue(text.contains(ITEM));
        assertTrue(text.contains(QTY));
        assertTrue(text.contains(PRICE));
        assertTrue(text.contains(TOTAL));
        assertTrue(text.contains(TAX));
        assertTrue(text.contains(SMALL_COFFEE));
    }
}
