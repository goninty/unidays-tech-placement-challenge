import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class UnidaysDiscountChallenge {
    private HashMap<Item, Discount> pricingRules;
    private ArrayList<Item> basket = new ArrayList<>();

    public UnidaysDiscountChallenge(HashMap<Item, Discount> pricingRules) {
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

        totalPrice -= applyDiscounts();

        if (totalPrice > 0 && totalPrice < 50) { // if total cost w/o delivery is less than £50, charge for delivery
            deliveryCharge = 7;
        }

        return new Price(totalPrice, deliveryCharge);
    }

    private double applyDiscounts() {
        double fullAmountToDeduct = 0;

        // the hashmap holds the items as keys and discounts as values
        for (HashMap.Entry<Item, Discount> i : pricingRules.entrySet()) {
            if (i.getValue() != null) { // if a discount actually exists for the item
                int frequency = Collections.frequency(basket, i.getKey());
                if (frequency >= i.getValue().getNumberForDiscount()) {
                    int numberEligibleForDiscount = Math.floorDiv(frequency, i.getValue().getNumberForDiscount());
                    fullAmountToDeduct += numberEligibleForDiscount * i.getValue().getAmountToDeduct();
                }
            }
        }

        return fullAmountToDeduct;
    }
}