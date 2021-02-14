package model;

import java.util.ArrayList;

public class DecorVendorList {
    ArrayList<String> decorList = new ArrayList<>();

    // MODIFIES: this
    // EFFECTS: helped function for adding decor vendor name to list
    public ArrayList<String> addVendors(String vendorName) {
        decorList.add(vendorName);
        return decorList;
    }

    // MODIFIES: this
    // EFFECTS: helper function for deleting decor vendor name from list
    public ArrayList<String> removeVendors(String vendorName) {
        decorList.remove(vendorName);
        return decorList;
    }

}
