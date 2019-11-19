/**
 * Holds the information on an item: it's name and price.
 * @author Andrew Morton
 */
public class Item {
    private char name; // this is a character in order to be consistent with the provided pricing rules
    private double price;

    /**
     * Constructor, sets the item's name and price.
     * @param name The name of the item (eg A).
     * @param price The price of the item.
     */
    public Item(char name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Get the name of the item.
     * @return The item's name.
     */
    public char getName() {
        return name;
    }

    /**
     * Get the price of the item itself, no delivery added or discounts applied here.
     * @return The sole price of the item.
     */
    public double getPrice() {
        return price;
    }
}
