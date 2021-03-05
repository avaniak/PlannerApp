package model;

import org.json.JSONObject;
import persistence.Writable;

public class Vendor implements Writable {
    private String name;
    private Category category;

    // CONSTRUCTOR
    public Vendor(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("category", category);
        return json;
    }
}

