import java.util.ArrayList;

public class UnidaysDiscountChallenge {
    private Item[] pricingRules;
    private ArrayList<Item> basket = new ArrayList<>();

    public UnidaysDiscountChallenge(Item[] pricingRules) {
        this.pricingRules = pricingRules;
    }

    public boolean AddToBasket(Item item) {
        try {
            basket.add(item);
            return true;
        } catch (Exception e) {
            System.out.println("Item " + item.getName() + " was unable to be added to your basket.");
            return false;
        }
    }

    public Price CalculateTotalPrice() {
        double totalPrice = 0;
        double deliveryCharge = 0;

        for (Item i : basket) {
            totalPrice += i.getPrice();
        }

        if (totalPrice < 50) { // if total cost w/o delivery is less than £50, charge for delivery
            deliveryCharge = 7;
        }

        return new Price(totalPrice, deliveryCharge);
    }

    public static void main(String[] args) {
        // setting out the pricing rules
        Item[] pricingRules = {
                new Item('A', 8.00, "None"),
                new Item('B', 12.00, "2 for 20.00"),
                new Item('C', 4.00, "3 for 10.00"),
                new Item('D', 7.00, "Buy 1 get 1 free"),
                new Item('E', 5.00, "3 for the price of 2")
        };

        UnidaysDiscountChallenge example = new UnidaysDiscountChallenge(pricingRules);

        example.AddToBasket(pricingRules[0]);

        Price result = example.CalculateTotalPrice();
        double totalPrice = result.getTotal();
        double deliveryCharge = result.getDeliveryCharge();
        double overallTotal = totalPrice + deliveryCharge;

        System.out.println("Item: " + pricingRules[0].getName());
        System.out.println("Total: " + totalPrice);
        System.out.println("Delivery charge: " + deliveryCharge);
        System.out.println("Overall total: " + overallTotal);
    }

}
