package persistence;

import model.Category;
import model.Vendor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkVendor(String name, Category category, Vendor vendor) {
        assertEquals(name, vendor.getName());
        assertEquals(category, vendor.getCategory());
    }
}
