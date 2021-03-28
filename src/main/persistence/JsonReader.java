package persistence;

import model.Category;
import model.Vendor;
import model.VendorList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    public JsonReader(String source) {
        this.source = source;
    }

    public VendorList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseVendorList(jsonObject);
    }

    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    private VendorList parseVendorList(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        VendorList vl = new VendorList("Vendor List");
        addVendors(vl, jsonObject);
        return vl;
    }

    private void addVendors(VendorList vl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("vendor list");
        for (Object json : jsonArray) {
            JSONObject nextvendor = (JSONObject) json;
            addVendor(vl, nextvendor);
        }
    }

    private void addVendor(VendorList vl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Category category = Category.valueOf(jsonObject.getString("category"));
        Vendor vendor = new Vendor(name, category);
        vl.addVendors(vendor);
    }


}