package Q1;

import java.util.HashMap;

public class SuperMarketCatalog {
    private HashMap<String, Double> catalog = new HashMap<>();

    public void addProduct(String name, double price) {
        catalog.put(name, price);
    }

    public double getPrice(String name) {
        if (!catalog.containsKey(name))
            return 0;
        else
            return catalog.get(name);
    }
}