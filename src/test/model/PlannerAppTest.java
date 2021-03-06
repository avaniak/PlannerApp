package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlannerAppTest {

    VendorList testvendorlist;
    VendorList name;
    String vendorname;
    Category category;

    @BeforeEach
    public void setup() {
        testvendorlist = new VendorList("Vendor List");
    }

    @Test
    void testconstructor() {
        assertEquals("Vendor List", testvendorlist.getName());
        assertTrue(testvendorlist.isEmpty());
    }

    @Test
    public void testaddonevendor() {
        testvendorlist.addVendors(new Vendor("Red Carpet Decor", Category.DECOR));
        assertEquals(1, testvendorlist.getSize());
    }


    @Test
    public void testaddmultiplevendors() {
        testvendorlist.addVendors(new Vendor("Red Carpet Decor", Category.DECOR));
        testvendorlist.addVendors(new Vendor("Beautiful Events", Category.DECOR));
        testvendorlist.addVendors(new Vendor("Always & Forever Events", Category.DECOR));
        assertEquals(3, testvendorlist.getSize());
    }

    @Test
    public void testremoveonevendorlastadded() {
        testvendorlist.addVendors(new Vendor("Red Carpet Decor", Category.DECOR));
        testvendorlist.addVendors(new Vendor("Beautiful Events", Category.DECOR));
        testvendorlist.removeVendors("Beautiful Events");
        assertEquals(1, testvendorlist.getSize());
        assertFalse(testvendorlist.listcontains(new Vendor("Beautiful Events", Category.DECOR)));
    }

    @Test
    public void testremoveonevendorfirstadded() {
        testvendorlist.addVendors(new Vendor("Red Carpet Decor", Category.DECOR));
        testvendorlist.addVendors(new Vendor("Beautiful Events", Category.DECOR));
        testvendorlist.addVendors(new Vendor("Always & Forever Events", Category.DECOR));
        testvendorlist.removeVendors("Always & Forever Events");
        assertEquals(2, testvendorlist.getSize());
        assertFalse(testvendorlist.listcontains(new Vendor("Always & Forever Events", Category.DECOR)));
    }

    @Test
    public void testremoveonevendormiddle() {
        testvendorlist.addVendors(new Vendor("Red Carpet Decor", Category.DECOR));
        testvendorlist.addVendors(new Vendor("Beautiful Events", Category.DECOR));
        testvendorlist.addVendors(new Vendor("Always & Forever Events", Category.DECOR));
        testvendorlist.removeVendors("Beautiful Events");
        assertEquals(2, testvendorlist.getSize());
        assertFalse(testvendorlist.listcontains(new Vendor("Beautiful Events", Category.DECOR)));
    }

    @Test
    public void testremovemultiplevendors() {
        testvendorlist.addVendors(new Vendor("Red Carpet Decor", Category.DECOR));
        testvendorlist.addVendors(new Vendor("Beautiful Events", Category.DECOR));
        testvendorlist.addVendors(new Vendor("Always & Forever Events", Category.DECOR));
        testvendorlist.addVendors(new Vendor("Flora", Category.FLORIST));
        testvendorlist.removeVendors("Beautiful Events");
        testvendorlist.removeVendors("Flora");
        assertEquals(2, testvendorlist.getSize());
        assertFalse(testvendorlist.listcontains(new Vendor("Beautiful Events", Category.DECOR)));
        assertFalse(testvendorlist.listcontains(new Vendor("Flora", Category.FLORIST)));

    }

    @Test
    public void testremoveallvendors() {
        testvendorlist.addVendors(new Vendor("Red Carpet Decor", Category.DECOR));
        testvendorlist.addVendors(new Vendor("Beautiful Events", Category.DECOR));
        testvendorlist.addVendors(new Vendor("Always & Forever Events", Category.DECOR));
        testvendorlist.removeVendors("Red Carpet Decor");
        testvendorlist.removeVendors("Beautiful Events");
        testvendorlist.removeVendors("Always & Forever Events");
        assertEquals(0, testvendorlist.getSize());
    }

    @Test
    public void testlistempty() {
        testvendorlist.addVendors(new Vendor("Red Carpet Decor", Category.DECOR));
        testvendorlist.removeVendors("Red Carpet Decor");
        assertEquals(0, testvendorlist.getSize());
        assertTrue(testvendorlist.isEmpty());
        assertTrue(testvendorlist.retrieveVendor());
    }

    @Test
    public void testlistnotempty() {
        testvendorlist.addVendors(new Vendor("Beautiful Events", Category.DECOR));
        testvendorlist.addVendors(new Vendor("Flora", Category.FLORIST));
        testvendorlist.removeVendors("Beautiful Events");
        assertEquals(1, testvendorlist.getSize());
        assertFalse(testvendorlist.isEmpty());
        assertFalse(testvendorlist.retrieveVendor());
    }

    @Test
    public void testremovevendornotinlist() {
        testvendorlist.addVendors(new Vendor("Beautiful Events", Category.DECOR));
        testvendorlist.addVendors(new Vendor("Always & Forever Events", Category.DECOR));
        assertEquals(2, testvendorlist.getSize());
        testvendorlist.removeVendors("Red Carpet Decor");
        assertEquals(2, testvendorlist.getSize());
    }
}