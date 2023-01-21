package Q1;

import java.util.HashMap;

public class SuperMarketCatalog {
    private HashMap<String, Double> catalog = new HashMap<>();

    public void addProduct(String name, double price) {
        catalog.put(name, price);
    }

    public double getPrice(String name) {
        return catalog.get(name);
    }
}