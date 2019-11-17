public class Price {
    private double total = 0; // item prices summed together
    private double deliveryCharge = 0; // delivery charge

    public Price(double total, double deliveryCharge) {
        this.total = total;
        this.deliveryCharge = deliveryCharge;
    }

    public double getTotal() {
        return total;
    }

    public double getDeliveryCharge() {
        return deliveryCharge;
    }
}
