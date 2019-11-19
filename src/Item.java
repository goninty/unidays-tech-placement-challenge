public class Item {
    private char name;
    private double price;

    public Item(char name, double price) {
        this.name = name;
        this.price = price;
    }

    public char getName() {
        return name;
    }

    // return the price of this item itself, no delivery stuff here
    public double getPrice() {
        return price;
    }
}
