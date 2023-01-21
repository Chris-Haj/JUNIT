package Q1;

import java.util.HashMap;

public class Checkout {
    private HashMap<String, Integer> cart = new HashMap<>();
    private SuperMarketCatalog catalog;
    private double discount = 0.0;

    public Checkout(SuperMarketCatalog catalog) {
        this.catalog = catalog;
    }

    public void addProduct(String name, int quantity) {
        double price = catalog.getPrice(name);
        if (price != 0) {
            if (cart.containsKey(name)) {
                quantity += cart.get(name);
            }
            cart.put(name, quantity);
        }
    }

    public void removeProduct(String name) {
        cart.remove(name);
    }

    public void changeQuantity(String name, int quantity) {
        double price = catalog.getPrice(name);
        if (price != 0) {
            cart.put(name, quantity);
        }
    }

    public void changePrice(String name, double price) {
        catalog.addProduct(name, price);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getTotalItems() {
        return cart.size();
    }

    public double getTotalPrice() {
        double total = 0;
        for (String name : cart.keySet()) {
            double price = catalog.getPrice(name);
            int quantity = cart.get(name);
            total += price * quantity;
        }
        total = total - (total * discount);
        return total;
    }

    public int getQuantity(String name) {
        return cart.get(name);
    }
}