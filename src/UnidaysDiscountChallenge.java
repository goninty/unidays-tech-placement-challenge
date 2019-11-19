import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Provides methods for adding items to a basket, then calculates the total basket price as well as delivery.
 * @author Andrew Morton
 */
public class UnidaysDiscountChallenge {
    private HashMap<Item, Discount> pricingRules;
    private ArrayList<Item> basket = new ArrayList<>();

    /**
     * Constructor, sets the pricing rules.
     * @param pricingRules The pricing rules, held as a HashMap in which Item objects map to their corresponding Discount objects.
     */
    public UnidaysDiscountChallenge(HashMap<Item, Discount> pricingRules) {
        this.pricingRules = pricingRules;
    }

    /**
     * Adds an item to the basket.
     * @param item The Item object to add to the basket.
     * @return True if the addition succeeded, false if it failed.
     */
    public boolean AddToBasket(Item item) {
        try {
            basket.add(item);
            return true;
        } catch (Exception e) {
            System.out.println("Item " + item.getName() + " was unable to be added to your basket.");
            return false;
        }
    }

    /**
     * Calculates the total final price of the basket, with discounts applied.
     * @return A price object, with the basket price (including discounts) and the delivery price.
     */
    public Price CalculateTotalPrice() {
        double totalPrice = 0;
        double deliveryCharge = 0;

        for (Item i : basket) {
            totalPrice += i.getPrice(); // sum item's price, no discounts applied yet
        }

        totalPrice -= applyDiscounts(); // deduct the required amount in order to apply all discounts

        if (totalPrice > 0 && totalPrice < 50) { // if total cost w/o delivery is less than £50, charge for delivery
            deliveryCharge = 7;
        }

        return new Price(totalPrice, deliveryCharge);
    }

    /**
     * Calculates the discounts to apply to the current basket.
     * @return The amount to deduct from the current basket in order to apply the discounts.
     */
    private double applyDiscounts() {
        double fullAmountToDeduct = 0;

        // the HashMap holds the items as keys and discounts as values
        for (HashMap.Entry<Item, Discount> i : pricingRules.entrySet()) { // iterate through pricingRules
            if (i.getValue() != null) { // if a discount actually exists for the item
                int frequency = Collections.frequency(basket, i.getKey()); // check the number of times an item appears in the basket

                if (frequency >= i.getValue().getNumberForDiscount()) { // if the number for the discount is met (eg 2 for BOGOF)
                    // we must check the number of times the discount can be applied
                    // done by dividing the frequency by the number of items required for a discount, and flooring the result
                    // eg if we have a "2 for £20" offer but have 5 occurrences of that item
                    // we'd do floor(5/2) = 2, so we'd apply the discount twice
                    int numberOfDiscounts = Math.floorDiv(frequency, i.getValue().getNumberForDiscount());
                    // then calculate the full amount to deduct
                    // by multiplying the amount of discounts to apply by the amountToDeduct of a single discount occurrence
                    fullAmountToDeduct += numberOfDiscounts * i.getValue().getAmountToDeduct();
                }
            }
        }

        return fullAmountToDeduct;
    }
}