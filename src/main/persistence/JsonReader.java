package persistence;

import ui.exceptions.StringEmptyException;
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

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it
    //          throws IOException if an error occurs reading data from file
    public VendorList read() throws IOException, StringEmptyException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseVendorList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses Vendorlist from JSON object and returns it
    private VendorList parseVendorList(JSONObject jsonObject) throws StringEmptyException {
        String name = jsonObject.getString("name");
        VendorList vl = new VendorList("Vendor List");
        addVendors(vl, jsonObject);
        return vl;
    }

    // MODIFIES: VendorList vl
    // EFFECTS: parses vendors from JSON Object and adds them to Vendor List
    private void addVendors(VendorList vl, JSONObject jsonObject) throws StringEmptyException {
        JSONArray jsonArray = jsonObject.getJSONArray("vendor list");
        for (Object json : jsonArray) {
            JSONObject nextvendor = (JSONObject) json;
            addVendor(vl, nextvendor);
        }
    }

    // MODIFIES: VendorList vl
    // EFFECTS: parses vendors from JSON Object and adds it to Vendor List
    private void addVendor(VendorList vl, JSONObject jsonObject) throws StringEmptyException {
        String name = jsonObject.getString("name");
        Category category = Category.valueOf(jsonObject.getString("category"));
        Vendor vendor = new Vendor(name, category);
        vl.addVendors(vendor);
    }


}