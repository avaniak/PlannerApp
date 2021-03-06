//package model;
//
//import org.json.JSONObject;
//import persistence.Writable;
//
//import java.util.ArrayList;
//
//public class DecorVendorList implements Writable {
//    ArrayList<String> decorList = new ArrayList<>();
//
//    // MODIFIES: this
//    // EFFECTS: helped function for adding decor vendor name to list
//    public ArrayList<String> addVendors(String vendorName) {
//        decorList.add(vendorName);
//        return decorList;
//    }
//
//    // MODIFIES: this
//    // EFFECTS: helper function for deleting decor vendor name from list
//    public ArrayList<String> removeVendors(String vendorName) {
//        decorList.remove(vendorName);
//        return decorList;
//    }
//
//    // EFFECTS: Print messages if retrieved list is empty
//    public boolean isEmpty() {
//        if (decorList.isEmpty()) {
//            System.out.print("\nThis list is empty, please add some vendors");
//            System.out.print("\n===========================================");
//            return true;
//        } else {
//            System.out.println(decorList);
//            return false;
//        }
//    }
//
//    // EFFECTS: gets the size of list
//    public int getSize() {
//        return decorList.size();
//    }
//
//    // EFFECTS: check whether list contains the given string
//    public boolean listcontains(String vendorName) {
//        return decorList.contains(vendorName);
//    }
//
//    @Override
//    public JSONObject toJson() {
//        return null;
//    }
//}
