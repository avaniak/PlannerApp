package model;

import org.json.JSONObject;
import persistence.Writable;

public class Vendor implements Writable {
    private String name;
    private Category category;

    // EFFECTS: Constructs a new Vendor
    public Vendor(String name, Category category) {
        this.name = name;
        this.category = category;
    }


    // EFFECTS: Gets the name of the vendor
    public String getName() {
        return name;
    }

    // EFFECTS: Gets the Category of the vendor
    public Category getCategory() {
        return category;
    }

    // EFFECTS: create + return new JSON Object and add name + category
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("category", category);
        return json;
    }
}

