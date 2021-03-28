package persistence;

import model.VendorList;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReadNonExistenceFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            VendorList vl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
        }
    }

/*    @Test
    void testReaderEmptyVendorList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyVendorList.json");
        try {
            VendorList vl = reader.read();
            assertEquals("Vendor List", vl.getName());
            assertEquals(0, vl.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }*/

}
