import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void testProductConstructorAndGetters() {
        Product p = new Product("Бат", "Printer", "P001", 5, 200000);
        assertEquals("Бат", p.getFromName());
        assertEquals("Printer", p.getProductName());
        assertEquals("P001", p.getCode());
        assertEquals(5, p.getQuantity());
        assertEquals(200000, p.getPrice());
        assertEquals(LocalDate.now(), p.getDate());
    }
}