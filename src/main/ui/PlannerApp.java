package ui;

import model.DecorVendorList;
import java.util.Scanner;

// Planner application
public class PlannerApp {

    private Scanner input;
    private DecorVendorList decorList;


    // EFFECTS: runs the application
    public PlannerApp() {
        runPlanner();
    }

    // MODIFIES: this
    // EFFECTS: run the planner app & let admin choose options
    // source: TellerApp (customized for the Planner App to allow admin to select actions on the console)

    private void runPlanner() {
        boolean keepGoing = true;

        String command = null;

        initialize();

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

    // MODIFIES: this
    // EFFECTS: run the planner app & let user choose options

    private void admincrudcommands(String command) {
        switch (command) {
            case "c":
                createVendor();
                break;
            case "r":
                retrieveVendor();
                break;
            case "u":
                updateVendor();
                break;
            case "d":
                deleteVendor();
                break;
            default:
                System.out.println("Selection not valid, choose again");
                break;
        }
    }


    // MODIFIES: this
    // EFFECTS: initialize new scanner
    private void initialize() {
        input = new Scanner(System.in);

    }

    // EFFECTS: display of the operations for the decor vendor list for admin
    private void adminOptions() {
        System.out.print("\nc : create decor vendor list");
        System.out.print("\nr : retrieve decor vendor list");
        System.out.print("\nu : update decor vendor list");
        System.out.print("\nd : delete decor vendor");
        System.out.print("\nq : quit");
        System.out.print("\n===========================================");
        System.out.print("\nEnter an option: ");
    }

    // MODIFIES: this
    // EFFECTS: creates a new decor vendor array list
    private void createVendor() {
        decorList = new DecorVendorList();
        System.out.print("\nlist successfully created!");
        System.out.print("\n===========================================");
    }

    // EFFECTS: retrieves newly created decor vendor array list
    private void retrieveVendor() {
        decorList.isEmpty();
    }

    // MODIFIES: this
    // EFFECTS: allows admin to delete name added to the decor vendor array list
    private DecorVendorList deleteVendor() {
        System.out.print("\n===========================================");
        System.out.print("\nremove vendor from the list: ");

        String command = null;
        command = input.nextLine();
        command = command.toLowerCase();
        decorList.removeVendors(command);
        System.out.print("\n===========================================");
        System.out.print("\nVendor removed from list successfully!");
        return decorList;
    }

    // REQUIRES: business name for the decor vendor
    // MODIFIES: this
    // EFFECTS: allows admin to update & add names to newly created decor vendor array list

    private DecorVendorList updateVendor() {
        System.out.println("\n===========================================");
        System.out.print("\nAdd new decor vendor to list: ");
        String command = input.nextLine();
        command = command.toLowerCase();
        decorList.addVendors(command);
        System.out.print("\nVendor(s) added successfully!");
        System.out.print("\n===========================================");
        return decorList;
    }

}
