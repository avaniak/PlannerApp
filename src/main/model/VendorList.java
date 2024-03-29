package model;

import exceptions.NameNotFoundException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.Iterator;

public class VendorList implements Writable, Iterable<Vendor> {
    private String name;
    ArrayList<Vendor> vendorList;

    // CONSTRUCTOR
    public VendorList(String name) {
        this.name = name;
        vendorList = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: helped function for adding decor vendor name to list
    public ArrayList<Vendor> addVendors(Vendor vendor) {
        vendorList.add(vendor);
        return vendorList;
    }

    // EFFECTS: Gets name
    public String getName() {
        return name;
    }


    // MODIFIES: this
    // EFFECTS: helper function for deleting decor vendor name from list
    //          throws NameNotFoundException if user leaves text field empty
    public void removeVendors(String name) throws NameNotFoundException {
        Vendor found = null;
        for (Vendor v : vendorList) {
            if (name.equals(v.getName())) {
                found = v;
            }
        }
        if (found != null) {
            vendorList.remove(found);
        } else {
            throw new NameNotFoundException();
//            System.out.println(name + " not found");
        }
    }

    // EFFECTS: Print messages if retrieved list is empty
    public boolean retrieveVendor() {
        if (vendorList.isEmpty()) {
            System.out.print("\nThis list is empty, please add some vendors");
            System.out.print("\n===========================================");
            return true;
        } else {
            for (Vendor v : vendorList) {
                System.out.println(v.getCategory() + " : " + v.getName());
            }
            return false;
        }
    }

    // EFFECTS: gets the size of list
    public int getSize() {
        return vendorList.size();
    }

    public boolean isEmpty() {
        return vendorList.isEmpty();
    }

    // EFFECTS: check whether list contains the given string
    public boolean listcontains(Vendor vendor) {
        return vendorList.contains(vendor.getName());
    }

    // EFFECTS: create + return new JSON Object and add name + category

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("vendor list", vendorlisttoJson());
        return json;
    }

    // Return vendors in the VendorList as a JSON array
    private JSONArray vendorlisttoJson() {
        JSONArray jsonArray = new JSONArray();

        for (Vendor v : vendorList) {
            jsonArray.put(v.toJson());
        }
        return jsonArray;
    }

    // EFFECTS: iterates through the vendors in the vendor list array
    @Override
    public Iterator<Vendor> iterator() {
        return vendorList.iterator();
    }
}


