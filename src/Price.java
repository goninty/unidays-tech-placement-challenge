/**
 * Holds the price information for a basket.
 * @author Andrew Morton
 */
public class Price {
    private double total = 0; // item prices summed together
    private double deliveryCharge = 0; // delivery charge

    /**
     * Constructor, sets total price and delivery charge.
     * @param total The total price of all items in the basket summed up (no delivery charge).
     * @param deliveryCharge The delivery charge to be applied to this basket.
     */
    public Price(double total, double deliveryCharge) {
        this.total = total;
        this.deliveryCharge = deliveryCharge;
    }

    /**
     * Get the total summed price of all items w/o delivery fee.
     * @return The total summed price of the items.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Get the delivery charge.
     * @return The delivery charge for this basket.
     */
    public double getDeliveryCharge() {
        return deliveryCharge;
    }
}
