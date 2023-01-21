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
//        catalog.addProduct("Apple", 1.0);
//        catalog.addProduct("Banana", 2.0);
//        catalog.addProduct("Cherry", 0.5);
    }

    @Test
    void AddProduct3Test() {
        checkout.addProduct("Apple", 1);
        checkout.addProduct("Banana", 1);
        checkout.addProduct("Cherry", 1);
        assertEquals(3.5, checkout.getTotalPrice(), 0.0);
    }

    @Test
    void EmptyCartTest() {
        assertEquals(0, checkout.getTotalItems());
    }

    @Test
    void AddRemoveTest() {
        checkout.addProduct("Apple", 1);
        checkout.removeProduct("Apple");
        assertEquals(0, checkout.getTotalItems());
    }

    @Test
    void AddTwoProdsTest() {
        checkout.addProduct("Apple", 2);
        assertEquals(2, checkout.getTotalItems());
    }

    @Test
    void SetDiscountTest() {
        checkout.addProduct("Apple", 1);
        checkout.addProduct("Banana", 1);
        checkout.addProduct("Cherry", 1);
        checkout.setDiscount(0.5);
        double expectedTotal = (1.0 + 2.0 + 0.5) * 0.5;
        assertEquals(expectedTotal, checkout.getTotalPrice(), 0.0);
    }

    //Test, change twice amount of product and check if quantity is correct
    @Test
    void ChangeQuantityTest() {
        checkout.addProduct("Apple", 1);
        checkout.changeQuantity("Apple", 2);
        checkout.changeQuantity("Apple", 4);
        assertEquals(4, checkout.getQuantity("Apple"));
    }

    //Test, give 0 for a product that does not exist
    @Test
    void DoesNotExistTest() {
        assertEquals(0, checkout.getQuantity("Orange"));
    }
}
