import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Inventory;
import com.example.Product;

class InventoryTest {

    private Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
    }

    @Test
    void testAddNewProduct() {
        Product p = new Product("Бат", "Printer", "P001", 5, 200000);
        inventory.addProduct(p);

        assertEquals(1, inventory.getProducts().size());
        assertEquals(5, inventory.getProducts().get(0).getQuantity());
    }

    @Test
    void testAddExistingProductIncreasesQuantity() {
        Product p1 = new Product("Бат", "Printer", "P001", 5, 200000);
        Product p2 = new Product("Бат", "Printer", "P001", 3, 200000);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        assertEquals(1, inventory.getProducts().size());
        assertEquals(8, inventory.getProducts().get(0).getQuantity());
    }

    @Test
    void testGetProductSuccessfully() {
        Product p = new Product("Бат", "Monitor", "M001", 10, 300000);
        inventory.addProduct(p);

        Product requested = new Product("Сараа", "Monitor", "M001", 5, 300000);
        boolean success = inventory.getProduct(requested);

        assertTrue(success);
        assertEquals(5, inventory.getProducts().get(0).getQuantity());
    }

    @Test
    void testGetProductFailsIfInsufficientStock() {
        Product p = new Product("Бат", "Monitor", "M001", 2, 300000);
        inventory.addProduct(p);

        Product requested = new Product("Сараа", "Monitor", "M001", 5, 300000);
        boolean success = inventory.getProduct(requested);

        assertFalse(success);
        assertEquals(2, inventory.getProducts().get(0).getQuantity());
    }

}
