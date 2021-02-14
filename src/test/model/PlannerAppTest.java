package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.*;

class PlannerAppTest {

    DecorVendorList testdecorlist;

    @BeforeEach
    public void setup() {
        testdecorlist = new DecorVendorList();
    }

    @Test
    public void testaddonevendor() {
        testdecorlist.addVendors("Red Carpet Decor");
        assertTrue(testdecorlist.listcontains("Red Carpet Decor"));
    }


    @Test
    public void testaddmultiplevendors() {
        testdecorlist.addVendors("Red Carpet Decor");
        testdecorlist.addVendors("Beautiful Events");
        testdecorlist.addVendors("Always & Forever Events");
        assertEquals(3, testdecorlist.getSize());
    }

    @Test
    public void testremoveonevendorlastadded() {
        testdecorlist.addVendors("Red Carpet Decor");
        testdecorlist.addVendors("Beautiful Events");
        testdecorlist.removeVendors("Beautiful Events");
        assertEquals(1, testdecorlist.getSize());
        assertFalse(testdecorlist.listcontains("Beautiful Events"));
    }

    @Test
    public void testremoveonevendorfirstadded() {
        testdecorlist.addVendors("Red Carpet Decor");
        testdecorlist.addVendors("Beautiful Events");
        testdecorlist.addVendors("Always & Forever Events");
        testdecorlist.removeVendors("Red Carpet Decor");
        assertEquals(2, testdecorlist.getSize());
        assertFalse(testdecorlist.listcontains("Red Carpet Decor"));
    }

    @Test
    public void testremoveonevendormiddle() {
        testdecorlist.addVendors("Red Carpet Decor");
        testdecorlist.addVendors("Beautiful Events");
        testdecorlist.addVendors("Always & Forever Events");
        testdecorlist.removeVendors("Beautiful Events");
        assertEquals(2, testdecorlist.getSize());
        assertFalse(testdecorlist.listcontains("Beautiful Events"));
    }

    @Test
    public void testremovemultiplevendors() {
        testdecorlist.addVendors("Red Carpet Decor");
        testdecorlist.addVendors("Beautiful Events");
        testdecorlist.addVendors("Always & Forever Events");
        testdecorlist.addVendors("Universal Decor");
        testdecorlist.removeVendors("Beautiful Events");
        testdecorlist.removeVendors("Always & Forever Events");
        assertEquals(2, testdecorlist.getSize());
        assertFalse(testdecorlist.listcontains("Beautiful Events"));
        assertFalse(testdecorlist.listcontains("Always & Forever Events"));

    }

    @Test
    public void testremoveallvendors() {
        testdecorlist.addVendors("Red Carpet Decor");
        testdecorlist.addVendors("Beautiful Events");
        testdecorlist.addVendors("Always & Forever Events");
        testdecorlist.removeVendors("Red Carpet Decor");
        testdecorlist.removeVendors("Beautiful Events");
        testdecorlist.removeVendors("Always & Forever Events");
        assertEquals(0, testdecorlist.getSize());
    }

    @Test
    public void testlistempty() {
        testdecorlist.addVendors("Red Carpet Decor");
        testdecorlist.removeVendors("Red Carpet Decor");
        assertEquals(0, testdecorlist.getSize());
        assertTrue(testdecorlist.isEmpty());
    }

    @Test
    public void testlistnotempty() {
        testdecorlist.addVendors("Red Carpet Decor");
        testdecorlist.addVendors("Beautiful Events");
        testdecorlist.removeVendors("Red Carpet Decor");
        assertEquals(1, testdecorlist.getSize());
        assertFalse(testdecorlist.isEmpty());
    }
}