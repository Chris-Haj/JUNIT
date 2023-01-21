package Q1;

//JUNIT TESTS FOR Q1 PACKAGE CLASSES (Checkout.java and SuperMarketCatalog.java)

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CatalogTesterClass {

    private static Checkout checkout;
    private static SuperMarketCatalog catalog;

    @BeforeAll
    static void setUpBeforeClass() {
        catalog = new SuperMarketCatalog();
        checkout = new Checkout(catalog);
        catalog.addProduct("Apple", 1.0);
        catalog.addProduct("Banana", 2.0);
        catalog.addProduct("Cherry", 0.5);

    }

    @Test
    void testAddProduct() {
        checkout.addProduct("Apple", 1);
        assertEquals(1, checkout.getTotalItems());
    }

    @Test
    void testRemoveProduct() {
        checkout.addProduct("Apple", 1);
        checkout.removeProduct("Apple");
        assertEquals(0, checkout.getTotalItems());
    }

    @Test
    void testChangeQuantity() {
        checkout.addProduct("Apple", 1);
        checkout.changeQuantity("Apple", 2);
        assertEquals(2, checkout.getQuantity("Apple"));
    }

    @Test
    void testChangePrice() {
        checkout.changePrice("Apple", 2.0);
        assertEquals(2.0, catalog.getPrice("Apple"), 0.0);
    }

    @Test
    void testSetDiscount() {
        checkout.addProduct("Apple", 1);
        checkout.addProduct("Banana", 1);
        checkout.addProduct("Cherry", 1);
        checkout.setDiscount(0.5);
        double expectedTotal = (1.0 + 2.0 + 0.5) * 0.5;
        assertEquals(expectedTotal, checkout.getTotalPrice(), 0.0);
    }

    @Test
    void testGetTotalPrice() {
        checkout.addProduct("Apple", 1);
        checkout.addProduct("Banana", 1);
        checkout.addProduct("Cherry", 1);
        assertEquals(3.5, checkout.getTotalPrice(), 0.0);
    }

    @Test
    void testGetTotalItems() {
        checkout.addProduct("Apple", 1);
        checkout.addProduct("Banana", 1);
        checkout.addProduct("Cherry", 1);
        assertEquals(3, checkout.getTotalItems());
    }

    @Test
    void testGetQuantity() {
        checkout.addProduct("Apple", 1);
        checkout.addProduct("Banana", 1);
        checkout.addProduct("Cherry", 1);
        assertEquals(1, checkout.getQuantity("Apple"));
    }

    @Test
    void testGetPrice() {
        checkout.addProduct("Apple", 1);
        checkout.addProduct("Banana", 1);
        checkout.addProduct("Cherry", 1);
        assertEquals(1.0, catalog.getPrice("Apple"), 0.0);
    }

    @Test
    void testAddProductToCatalog() {
        catalog.addProduct("Apple", 1.0);
        assertEquals(1.0, catalog.getPrice("Apple"), 0.0);
    }

    @Test
    void testGetPriceFromCatalog() {
        catalog.addProduct("Apple", 1.0);
        assertEquals(1.0, catalog.getPrice("Apple"), 0.0);
    }
}
