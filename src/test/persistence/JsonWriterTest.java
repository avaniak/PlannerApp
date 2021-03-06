package persistence;

import model.Category;
import model.Vendor;
import model.VendorList;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            VendorList vl = new VendorList("Vendor List");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
        }
    }

    @Test
    void testWriterEmptyVendorList() {
        try {
            VendorList vl = new VendorList("Vendor List");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyVendorList.json");
            writer.open();
            writer.write(vl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyVendorList.json");
            vl = reader.read();
            assertEquals("Vendor List", vl.getName());
            assertEquals(0, vl.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralVendorList() {
        try {
            VendorList vl = new VendorList("Vendor List");
            vl.addVendors(new Vendor("Red Carpet Decor", Category.DECOR));
            vl.addVendors(new Vendor("Flora", Category.FLORIST));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralVendorList.json");
            writer.open();
            writer.write(vl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralVendorList.json");
            vl = reader.read();
            assertEquals("Vendor List", vl.getName());
            assertEquals(2, vl.getSize());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }


}
