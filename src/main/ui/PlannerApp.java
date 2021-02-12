package ui;

import model.DecorVendorList;
import model.Vendor;

import java.util.ArrayList;

import java.util.Scanner;

public class PlannerApp {
//    private DecorVendorList decorlist;
    private Vendor vendor;
    private Scanner input;
    private ArrayList decorList;


    // EFFECTS: runs the planner application
    public PlannerApp() {
        runPlanner();
    }

    // MODIFIES: this
    // EFFECTS: run the planner app & let user choose options
    // source: TellerApp (customized for the Planner App to allow admin to select actions on the console)

    private void runPlanner() {
        boolean keepGoing = true;
        String command = null;

        initialize();

        while (keepGoing) {
            adminOptions();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                admincrudcommands(command);
            }
        }
        System.out.println("\nThank You!");
    }

    private void admincrudcommands(String command) {
        if (command.equals("c")) {
            createVendor();
        } else if (command.equals("r")) {
            retrieveVendor();
        } else if (command.equals("u")) {
            updateVendor();
        } else if (command.equals("d")) {
            deleteVendor();
        } else {
            System.out.println("Selection not valid, choose again");
        }
    }

    // MODIFIES: this
    // EFFECTS: initialize new vendor
    private void initialize() {
        input = new Scanner(System.in);
    }

    private void adminOptions() {
        System.out.print("\nc : create decor vendor list");
        System.out.print("\nr : retrieve decor vendor list");
        System.out.print("\nu : update decor vendor list");
        System.out.print("\nd : delete decor vendor");
        System.out.print("\nq : quit");
        System.out.print("\n===========================================");
        System.out.print("\nEnter an option: ");


    }

    private void createVendor() {
        decorList = new ArrayList();
        System.out.print("\nlist successfully created!");

    }

    private ArrayList retrieveVendor() {
        return decorList;

    }

    private ArrayList updateVendor() {
        System.out.print("\n===========================================");
        System.out.print("\nAdd new decor vendor to list: ");

        String command = null;
        command = input.nextLine();
        command = command.toLowerCase();
        decorList = addVendors(command);
        return decorList;
    }

    private ArrayList deleteVendor() {
        System.out.print("\n===========================================");
        System.out.print("\nremove vendor from the list: ");

        String command = null;
        command = input.next();
        command = command.toLowerCase();
        decorList = removeVendors(command);
        return decorList;

    }

    private ArrayList removeVendors(String vendorName) {
        decorList.remove(vendorName);
        return decorList;
    }

    private ArrayList getDecorList () {
        return decorList;
    }

    private ArrayList addVendors(String vendorName) {
        decorList.add(vendorName);
        return decorList;
    }


}

//    private DecorVendorList selectVendor() {
//        String selection = "";
//
//        while (selection.equals("d")) {
//            System.out.println("d -> Decor Vendor List");
//            selection = input.next();
//            selection = selection.toLowerCase();
//        }
//        if (selection.equals("d")) {
//            return decorlist;
//        }
//        return null;
//    }

