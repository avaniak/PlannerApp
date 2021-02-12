package model;

import com.sun.org.apache.xpath.internal.objects.XString;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DecorVendorList {
    ArrayList<String> decorList = new ArrayList<>();

    public ArrayList<String> addVendors(String vendorName) {
        decorList.add(vendorName);
        return decorList;

    }

}
