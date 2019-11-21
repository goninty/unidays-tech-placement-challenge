/**
 * Holds the information on a discount that can then be linked to an item.
 * @author Andrew Morton
 */
public class Discount {
    private int numberForDiscount;
    private double amountToDeduct;

    /**
     * Constructor, sets the values of the discount object.
     * @param numberForDiscount The number of times an item must be in the basket to apply the discount.
     * @param discountPrice The amount that the discounted items (together) will cost when the discount is applied.
     * @param itemPrice The price of the item this discount is related to.
     */
    public Discount(int numberForDiscount, double discountPrice, double itemPrice) {
        this.numberForDiscount = numberForDiscount;
        // the amount to deduct is calculated
        // by finding the difference between the summed price of the items in the discount
        // and the price they should then be under the discount
        this.amountToDeduct = itemPrice * numberForDiscount - discountPrice;
        /*
        // this is calculated only for one "occurance" of this discount
        // ie if there is a "2 for £20" offer, but there are 4 of the eligible items in the basket
        // the amount to deduct here will be calculated for 2 of those items
        // however when applying the discount in the UnidaysDiscountChallenge class
        // the returned amountToDeduct value will be multiplied in order to find a totalAmountToDeduct
        */
    }

    /**
     * Getter to return the number of items that must be in the basket for the discount to be applied.
     * @return The number of items that must be in the basket for the discount to be applied.
     */
    public int getNumberForDiscount() {
        return numberForDiscount;
    }

    /**
     * Getter to return the amount to deduct.
     * @return The amount to deduct from the basket's total price (the summed price of all items, excluding delivery).
     */
    public double getAmountToDeduct() {
        return amountToDeduct;
    }
}
