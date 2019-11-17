public class Item {
    private char name;
    private double price;
    private String discount; //change to something else, not string

    public Item(char name, double price, String discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public char getName() {
        return name;
    }

    // return the price of this item itself, no delivery stuff here
    public double getPrice() {
        return price;
    }

    public String getDiscount() {
        return discount;
    }
}
