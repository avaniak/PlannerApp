package ui;

import model.Category;
import model.Vendor;
import model.VendorList;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Planner application
public class PlannerApp {
    private Scanner input;
    private VendorList vendorList;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/vendorlist.json";


    // EFFECTS: runs the application
    public PlannerApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        vendorList = new VendorList("Vendor List");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runPlanner();
    }

    // MODIFIES: this
    // EFFECTS: run the planner app & let admin choose options
    // source: TellerApp (customized for the Planner App to allow admin to select actions on the console)

    private void runPlanner() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        while (keepGoing) {
            adminOptions();
            command = input.nextLine();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                admincrudcommands(command);
            }
        }
        System.out.println("\nThank You!");
    }

    // EFFECTS: display of the operations for the decor vendor list for admin
    private void adminOptions() {
        System.out.print("\nc : create new vendor list");
        System.out.print("\nr : retrieve vendor list");
        System.out.print("\nu : update vendor list");
        System.out.print("\nd : delete vendor");
        System.out.print("\ns : save vendor list from file");
        System.out.print("\nl : load vendor list from file");
        System.out.print("\nq : quit");
        System.out.print("\n===========================================");
        System.out.print("\nEnter an option: ");
    }

    // MODIFIES: this
    // EFFECTS: run the planner app & let user choose options

    private void admincrudcommands(String command) {
        if (command.equals("c")) {
            createVendor();
        } else if (command.equals("r")) {
            retrieveVendor();
        } else if (command.equals("u")) {
            updateVendor();
        } else if (command.equals("d")) {
            deleteVendor();
        } else if (command.equals("s")) {
            saveVendor();
        } else if (command.equals("l")) {
            loadVendor();
        } else {
            System.out.println("Selection not valid, choose again");
        }
    }

    // MODIFIES: this
    // EFFECTS: creates a new decor vendor array list
    private void createVendor() {
        vendorList = new VendorList("Vendor List");
        System.out.print("\nlist successfully created!");
        System.out.print("\n===========================================");
    }

    // EFFECTS: retrieves newly created decor vendor array list
    private void retrieveVendor() {
        vendorList.retrieveVendor();
    }

    // MODIFIES: this
    // EFFECTS: allows admin to delete name added to the decor vendor array list
    private VendorList deleteVendor() {
        System.out.print("\n===========================================");
        System.out.print("\nremove vendor from the list: ");
        String command = input.nextLine();
        command = command.toLowerCase();
        vendorList.removeVendors(command);
        System.out.print("\n===========================================");
        System.out.print("\nVendor removed from list successfully!");
        return vendorList;
    }

    // REQUIRES: business name for the decor vendor
    // MODIFIES: this
    // EFFECTS: allows admin to update & add names to newly created decor vendor array list

    private VendorList updateVendor() {
        Category category = readCategory();
        System.out.println("\n===========================================");
        System.out.println("\nAdd new vendor to list: ");
        input.nextLine();
        String command = input.nextLine();
        command = command.toLowerCase();
        vendorList.addVendors(new Vendor(command, category));
        System.out.print("\nVendor(s) added successfully!");
        System.out.print("\n===========================================");
        return vendorList;
    }

    private Category readCategory() {
        System.out.println("Please select the vendor: ");
        int menu = 1;
        for (Category c: Category.values()) {
            System.out.println(menu + ": " + c);
            menu++;
        }

        int menuSelection = input.nextInt();
        return Category.values()[menuSelection - 1];

    }

    private void saveVendor() {
        try {
            jsonWriter.open();
            jsonWriter.write(vendorList);
            jsonWriter.close();
            System.out.println("Saved " + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file " + JSON_STORE);
        }
    }

    private void loadVendor() {
        try {
            vendorList = jsonReader.read();
            System.out.println("Loaded " + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file " + JSON_STORE);
        }
    }

}
