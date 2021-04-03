package ui;

import ui.exceptions.ListNotFoundException;
import exceptions.NameNotFoundException;
import ui.exceptions.StringEmptyException;
import model.Category;
import model.Vendor;
import model.VendorList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;


public class MainJFrame extends JFrame {

    // GUI BUTTON PANEL COMPONENTS
    private final JTextArea textArea = new JTextArea();
    private final JLabel nameLabel = new JLabel("Add Vendor Name: ");
    private final JTextField nameTextField = new JTextField(15);
    private final JTextField messagebox = new JTextField(20);
    private final JComboBox vendorCategories = new JComboBox(Category.values());

    // CREATE BUTTONS
    private final JButton createVendorList = new JButton("Create Vendor");
    private final JButton updateVendorList = new JButton("Update Vendor");
    private final JButton deleteVendorList = new JButton("Delete Vendor");
    private final JButton saveVendorList = new JButton("Save");
    private final JButton loadVendorList = new JButton("Load");
    private VendorList vendorList;

    // JSON WRITER & READER
    private final JsonWriter jsonWriter;
    private final JsonReader jsonReader;
    private static final String JSON_STORE = "./data/vendorlist.json";


    // EFFECTS: Create MainJFrame Window with Text Area
    public MainJFrame() throws FileNotFoundException, IOException {

        // EFFECTS: Set main text area dimensions
        setMainTextAreaDimensions();

        // Create panels in main text area
        JPanel flow1Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel flow2Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel flow3Panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel gridPanel = new JPanel(new GridLayout(3, 1));


        // Make text area read only
        textArea.setEditable(false);
        messagebox.setEditable(false);


        // EFFECTS: helper to select Vendor from JComboBox (Drop down menu)
        selectVendorfromDropdown();

        // EFFECTS: helper to create a new Vendor List
        createVendorListButton();

        // EFFECTS: helper to update Vendor List
        updateVendorListButton();

        // EFFECTS: helper to save Vendor List
        saveVendorListButton();

        // EFFECTS: helper to load Vendor List
        loadVendorListButton();

        // EFFECTS: helper to delete Vendor from Vendor List
        deleteVendorListButton();

        // EFFECTS: Add Panels to the Main Window
        addPanelsToMain(flow1Panel, flow2Panel, flow3Panel, gridPanel);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

    }

    // EFFECTS: Set up Main text area dimensions
    private void setMainTextAreaDimensions() {
        setVisible(true);
        setSize(700, 500);
        setLocation(200, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // REQUIRES: Panels + Grid Panels
    // MODIFIES: this
    // EFFECTS: Add both bottom and main panels to the Main text Area
    private void addPanelsToMain(JPanel flow1Panel, JPanel flow2Panel, JPanel flow3Panel, JPanel gridPanel) {
        addBottomPanel(flow1Panel, flow2Panel, flow3Panel, gridPanel);
        addPanelToMain(gridPanel);
    }

    // REQUIRES: Panels + Grid Panels
    // MODIFIES: this
    // EFFECTS: Adds the flow panel to the Bottom Panel
    private void addBottomPanel(JPanel flow1Panel, JPanel flow2Panel, JPanel flow3Panel, JPanel gridPanel) {
        flow1Panel.add(messagebox);
        flow2Panel(flow2Panel);
        flow3Panel(flow3Panel);
        gridPanel(flow1Panel, flow2Panel, flow3Panel, gridPanel);
    }

    // REQUIRES: Grid Panel
    // MODIFIES: this
    // EFFECTS: Add Text Area and Grid Panel to Main Layout
    private void addPanelToMain(JPanel gridPanel) {
        add(textArea, BorderLayout.CENTER);
        add(gridPanel, BorderLayout.SOUTH);
    }

    // REQUIRES: flow panels
    // MODIFIES: this
    // EFFECTS: Create the grid panel with flow panels
    private void gridPanel(JPanel flow1Panel, JPanel flow2Panel, JPanel flow3Panel, JPanel gridPanel) {
        gridPanel.add(flow1Panel);
        gridPanel.add(flow2Panel);
        gridPanel.add(flow3Panel);
    }

    // REQUIRES: flow panels
    // MODIFIES: this
    // EFFECTS: Create the grid panel with flow panels
    private void flow3Panel(JPanel flow3Panel) {
        flow3Panel.add(nameLabel);
        flow3Panel.add(nameTextField);
        flow3Panel.add(vendorCategories);
    }

    // REQUIRES: flow2panel
    // MODIFIES: this
    // EFFECTS: create flow2Panel and add buttons to it
    private void flow2Panel(JPanel flow2Panel) {
        flow2Panel.add(createVendorList);
        flow2Panel.add(updateVendorList);
        flow2Panel.add(deleteVendorList);
        flow2Panel.add(saveVendorList);
        flow2Panel.add(loadVendorList);
    }

    // BUTTON FUNCTIONS

    // REQUIRES: button
    // MODIFIES: this
    // EFFECTS: Loads the previously saved Vendor List when Load Button is clicked
    private void loadVendorListButton() {
        loadVendorList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    vendorList = jsonReader.read();
                    displayVendorList();
                    messagebox.setText("Previous Vendor List Loaded");
                    System.out.println("Loaded " + " from " + JSON_STORE);
                    JOptionPane.showMessageDialog(null, "Vendor List Loaded!");
                    messagebox.setText("Vendor List Loaded!");

                } catch (IOException | StringEmptyException en) {
                    System.out.println("Unable to read from file " + JSON_STORE);
                }
            }
        });
    }

    // REQUIRES: non-empty list
    // EFFECTS: Displays updated vendor list in the main text area
    private void displayVendorList() {
        textArea.setText("");
        for (Vendor v : vendorList) {
            textArea.append(v.getName() + "\t" + v.getCategory() + "\n");
        }
    }

    // REQUIRES: button + user enters Vendor name in text field
    // MODIFIES: list
    // EFFECTS: Deletes vendor from the vendor list
    private void deleteVendorListButton() {
        deleteVendorList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vendorname = nameTextField.getText();
                if (vendorname.isEmpty()) {
                    try {
                        throw new StringEmptyException();
                    } catch (StringEmptyException exc) {
                        JOptionPane.showMessageDialog(null, "Vendor name cannot be empty");
                    }
                }

                try {
                    vendorList.removeVendors(nameTextField.getText());
                    displayVendorList();
                    JOptionPane.showMessageDialog(null, "Vendor Deleted");
                    messagebox.setText("Vendor Deleted!");
                } catch (NameNotFoundException nameNotFoundException) {
                    JOptionPane.showMessageDialog(null, "Vendor name not found");
                }

            }
        });
    }


    // REQUIRES: button
    // MODIFIES: list
    // EFFECTS: Saves vendor list
    private void saveVendorListButton() {
        saveVendorList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jsonWriter.open();
                    jsonWriter.write(vendorList);
                    jsonWriter.close();
                    System.out.println("Saved " + " to " + JSON_STORE);
                    JOptionPane.showMessageDialog(null, "Vendor List Saved!");
                    messagebox.setText("Vendor List Saved!");

                } catch (FileNotFoundException ex) {
                    System.out.println("Unable to write to file " + JSON_STORE);
                }
            }
        });
    }

    // REQUIRES: button + user enters Vendor name in text field
    // MODIFIES: list
    // EFFECTS: Adds vendor in the vendor list
    private void updateVendorListButton() {
        updateVendorList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                Category category = (Category) vendorCategories.getSelectedItem();
                String vendorname = nameTextField.getText();
                if (vendorList == null) {
                    try {
                        throw new ListNotFoundException();
                    } catch (ListNotFoundException | NullPointerException ex) {
                        JOptionPane.showMessageDialog(null, "List not found: Create a new list");
                    }
                }

                if (vendorname.isEmpty()) {
                    try {
                        throw new StringEmptyException();
                    } catch (StringEmptyException e) {
                        JOptionPane.showMessageDialog(null, "Vendor name cannot be empty");
                    }
                } else {
                    addVendorinTextField(category, vendorname);
                }
            }
        });
    }

    private void addVendorinTextField(Category category, String vendorname) {
        vendorList.addVendors(new Vendor(vendorname, category));
        System.out.println(nameTextField.getText());
        displayVendorList();
        messagebox.setText("Vendor Added!");
    }


    // EFFECTS: Selects category from the JComboBox
    private void selectVendorfromDropdown() {
        vendorCategories.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                messagebox.setText("You selected: " + ((JComboBox) event.getSource()).getSelectedItem());
            }
        });
    }

    // REQUIRES: button
    // EFFECTS: Creates a new vendor list
    private void createVendorListButton() {
        createVendorList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == createVendorList) {
                    vendorList = new VendorList("Vendor List");
                    messagebox.setText("New Vendor list created!");
                }
            }
        });
    }


}

