import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

class UnidaysDiscountChallengeTest {
    private static HashMap<Item, Discount> pricingRules;
    // instantiate items
    private static Item itemA = new Item('A', 8.00);
    private static Item itemB = new Item('B', 12.00);
    private static Item itemC = new Item('C', 4.00);
    private static Item itemD = new Item('D', 7.00);
    private static Item itemE = new Item('E', 5.00);

    private UnidaysDiscountChallenge example;
    private Price result;
    private double expectedTotal;
    private double expectedDelivery;

    @BeforeAll()
    static void initAll() {
        System.out.println("Creating the pricing rules...");
        // add items to the pricingRules map as well as mapping the items to their relevant discounts
        pricingRules = new HashMap<>();
        pricingRules.put(itemA, null);
        pricingRules.put(itemB, new Discount(2, 20.00, itemB.getPrice()));
        pricingRules.put(itemC, new Discount(3, 10.00, itemC.getPrice()));
        pricingRules.put(itemD, new Discount(2, 7.00, itemD.getPrice()));
        pricingRules.put(itemE, new Discount(3, 10.00, itemE.getPrice()));
    }

    @BeforeEach
    void initEach() {
        System.out.println("Instantiating an example object with the pricing rules...");
        example = new UnidaysDiscountChallenge(pricingRules);
    }

    @AfterEach
    void finishEach() {
        result = example.CalculateTotalPrice();
        assertAll("Should return summed price of items and delivery charge separately",
                () -> assertEquals(expectedTotal, result.getTotal()),
                () -> assertEquals(expectedDelivery, result.getDeliveryCharge())
        );

        System.out.println("Tearing down our example object and our result value...");
        example = null;
        result = null;
    }

    /**
     * All of the example tests have been implemented below.
     */

    @Test
    void addNone() {
        expectedTotal = 0;
        expectedDelivery = 0;
        System.out.println("Adding nothing to basket...");
    }

    @Test
    void addA() {
        expectedTotal = 8;
        expectedDelivery = 7;
        System.out.println("Adding A to basket...");
        example.AddToBasket(itemA);
    }

    @Test
    void addB() {
        expectedTotal = 12;
        expectedDelivery = 7;
        System.out.println("Adding B to basket...");
        example.AddToBasket(itemB);
    }

    @Test
    void addC() {
        expectedTotal = 4;
        expectedDelivery = 7;
        System.out.println("Adding C to basket...");
        example.AddToBasket(itemC);
    }

    @Test
    void addD() {
        expectedTotal = 7;
        expectedDelivery = 7;
        System.out.println("Adding D to basket...");
        example.AddToBasket(itemD);
    }

    @Test
    void addE() {
        expectedTotal = 5;
        expectedDelivery = 7;
        System.out.println("Adding E to basket...");
        example.AddToBasket(itemE);
    }

    @Test
    void addBB() {
        expectedTotal = 20;
        expectedDelivery = 7;
        System.out.println("Adding BB to basket...");
        example.AddToBasket(itemB);
        example.AddToBasket(itemB);
    }

    @Test
    void addBBB() {
        expectedTotal = 32;
        expectedDelivery = 7;
        System.out.println("Adding BBB to basket...");
        example.AddToBasket(itemB);
        example.AddToBasket(itemB);
        example.AddToBasket(itemB);
    }

    @Test
    void addBBBB() {
        expectedTotal = 40;
        expectedDelivery = 7;
        System.out.println("Adding BBBB to basket...");
        example.AddToBasket(itemB);
        example.AddToBasket(itemB);
        example.AddToBasket(itemB);
        example.AddToBasket(itemB);
    }

    @Test
    void addCCC() {
        expectedTotal = 10;
        expectedDelivery = 7;
        System.out.println("Adding CCC to basket...");
        example.AddToBasket(itemC);
        example.AddToBasket(itemC);
        example.AddToBasket(itemC);
    }

    @Test
    void addCCCC() {
        expectedTotal = 14;
        expectedDelivery = 7;
        System.out.println("Adding CCCC to basket...");
        example.AddToBasket(itemC);
        example.AddToBasket(itemC);
        example.AddToBasket(itemC);
        example.AddToBasket(itemC);
    }

    @Test
    void addDD() {
        expectedTotal = 7;
        expectedDelivery = 7;
        System.out.println("Adding DD to basket...");
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
    }

    @Test
    void addDDD() {
        expectedTotal = 14;
        expectedDelivery = 7;
        System.out.println("Adding DDD to basket...");
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
    }

    @Test
    void addEE() {
        expectedTotal = 10;
        expectedDelivery = 7;
        System.out.println("Adding EE to basket...");
        example.AddToBasket(itemE);
        example.AddToBasket(itemE);
    }

    @Test
    void addEEE() {
        expectedTotal = 10;
        expectedDelivery = 7;
        System.out.println("Adding EEE to basket...");
        example.AddToBasket(itemE);
        example.AddToBasket(itemE);
        example.AddToBasket(itemE);
    }

    @Test
    void addEEEE() {
        expectedTotal = 15;
        expectedDelivery = 7;
        System.out.println("Adding EEEE to basket...");
        example.AddToBasket(itemE);
        example.AddToBasket(itemE);
        example.AddToBasket(itemE);
        example.AddToBasket(itemE);
    }

    @Test
    void addDDDDDDDDDDDDDD() {
        expectedTotal = 49;
        expectedDelivery = 7;
        System.out.println("Adding DDDDDDDDDDDDDD to basket...");
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
    }

    @Test
    void addBBBBCCC() {
        expectedTotal = 50;
        expectedDelivery = 0;
        System.out.println("Adding BBBBCCC to basket...");
        example.AddToBasket(itemB);
        example.AddToBasket(itemB);
        example.AddToBasket(itemB);
        example.AddToBasket(itemB);
        example.AddToBasket(itemC);
        example.AddToBasket(itemC);
        example.AddToBasket(itemC);
    }

    @Test
    void addABBCCCDDEE() {
        expectedTotal = 55;
        expectedDelivery = 0;
        System.out.println("Adding ABBCCCDDEE to basket...");
        example.AddToBasket(itemA);
        example.AddToBasket(itemB);
        example.AddToBasket(itemB);
        example.AddToBasket(itemC);
        example.AddToBasket(itemC);
        example.AddToBasket(itemC);
        example.AddToBasket(itemD);
        example.AddToBasket(itemD);
        example.AddToBasket(itemE);
        example.AddToBasket(itemE);
    }

    @Test
    void addEDCBAEDCBC() {
        expectedTotal = 55;
        expectedDelivery = 0;
        System.out.println("Adding EDCBAEDCBC to basket...");
        example.AddToBasket(itemE);
        example.AddToBasket(itemD);
        example.AddToBasket(itemC);
        example.AddToBasket(itemB);
        example.AddToBasket(itemA);
        example.AddToBasket(itemE);
        example.AddToBasket(itemD);
        example.AddToBasket(itemC);
        example.AddToBasket(itemB);
        example.AddToBasket(itemC);
    }
}