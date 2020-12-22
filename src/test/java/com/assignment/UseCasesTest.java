package com.assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.assignment.extra.ExtraMilk;
import com.assignment.snacks.BaconRoll;
import com.assignment.beverage.MediumCoffee;
import com.assignment.beverage.OrangeJuice;
import com.assignment.beverage.SmallCoffee;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UseCasesTest {

    @Test
    @DisplayName("Use case 1")
    void buysSmallCoffeeNoExtrasGetsReceipt(){
        SmallCoffee smallCoffee = new SmallCoffee();
        Order order = new Order();
        order.addProduct(smallCoffee);

        order.sendOrder();

        assertEquals(BigDecimal.valueOf(2.50), order.getTotalAmount());
    }

    @Test
    @DisplayName("Use case 2")
    void buysMediumCoffeeNoExtrasGetsReceipt(){
        MediumCoffee mediumCoffee = new MediumCoffee();
        Order order = new Order();
        order.addProduct(mediumCoffee);

        order.sendOrder();

        assertEquals(BigDecimal.valueOf(3), order.getTotalAmount());
    }

    @Test
    @DisplayName("Use case 4")
    void buysSmallCoffeeAndBaconRollGetsReceipt(){
        SmallCoffee smallCoffee = new SmallCoffee();
        BaconRoll baconRoll = new BaconRoll();
        Order order = new Order();
        order.addProduct(smallCoffee);
        order.addProduct(baconRoll);

        order.sendOrder();

        assertEquals(BigDecimal.valueOf(7.0), order.getTotalAmount());
    }

    @Test
    @DisplayName("Use case 7")
    void buysSmallCoffeeAndOrangeJuiceGetsReceipt(){
        SmallCoffee smallCoffee = new SmallCoffee();
        OrangeJuice orangeJuice = new OrangeJuice();
        Order order = new Order();
        order.addProduct(smallCoffee);
        order.addProduct(orangeJuice);

        order.sendOrder();

        assertEquals(BigDecimal.valueOf(6.45), order.getTotalAmount());
    }

    @Test
    @DisplayName("Use case 10")
    void buysSmallCoffeeAndBaconRollAndOrangeJuiceGetsReceipt(){
        SmallCoffee smallCoffee = new SmallCoffee();
        BaconRoll baconRoll = new BaconRoll();
        OrangeJuice orangeJuice = new OrangeJuice();
        Order order = new Order();
        order.addProduct(smallCoffee);
        order.addProduct(baconRoll);
        order.addProduct(orangeJuice);

        order.sendOrder();

        assertEquals(BigDecimal.valueOf(10.95), order.getTotalAmount());
    }

    @Test
    @DisplayName("Use case 11")
    void withExtra(){
        Order order = createOrder();

        order.sendOrder();

        assertEquals(BigDecimal.valueOf(10.95), order.getTotalAmount());
    }

    @Test
    @DisplayName("Use case 12")
    void withExtraAndFourStamps(){
        Order order = createOrder();

        order.addAFreeBeverageWithStampsCard();
        order.sendOrder();

        assertEquals(BigDecimal.valueOf(8.45), order.getTotalAmount());
    }

    private Order createOrder() {
        SmallCoffee smallCoffee = new SmallCoffee();
        BaconRoll baconRoll = new BaconRoll();
        OrangeJuice orangeJuice = new OrangeJuice();
        ExtraMilk extraMilk = new ExtraMilk();
        Order order = new Order();
        order.addProduct(smallCoffee);
        order.addProduct(baconRoll);
        order.addProduct(orangeJuice);
        order.addProduct(extraMilk);
        return order;
    }
    // TODO Implement test cases 3, 5, 6, 8, 9
}
