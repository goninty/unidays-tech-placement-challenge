public class Discount {
    private int numberForDiscount; // the number of times an item must be in the basket to apply the discount
    private double amountToDeduct; // the amount of money to deduct from the price if the discount is utilised

    public Discount(int numberForDiscount, double discountPrice, double itemPrice) {
        this.numberForDiscount = numberForDiscount;
        this.amountToDeduct = itemPrice * numberForDiscount - discountPrice;
    }

    public int getNumberForDiscount() {
        return numberForDiscount;
    }

    public double getAmountToDeduct() {
        return amountToDeduct;
    }
}
