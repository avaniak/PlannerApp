package ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;


public class AdminLogin implements ActionListener {
    private static JLabel userlabel;
    private static JTextField userText;
    private static JLabel passwordlabel;
    private static JTextField passwordtext;
    private static JLabel success;
    private static JPanel panel;
    private static JFrame frame;

    private static JButton loginButton;

    // EFFECTS: Creates the admin login window
    public AdminLogin() {
        panel = new JPanel();
        frame = new JFrame();

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        userLabel(panel);
        passwordLabel(panel);

        // LOGIN BUTTON
        loginButton = new JButton("Admin Login");
        loginButton.setBounds(120, 80, 120, 25);
        loginButton.setFocusable(false);
        panel.add(loginButton);
        loginButton.addActionListener(this);

        // MESSAGE AFTER LOGIN
        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    // REQUIRES: panel
    // MODIFIES: this
    // EFFECTS: set up the password label + dimensions
    private void passwordLabel(JPanel panel) {
        // PASSWORD TEXT
        passwordlabel = new JLabel("Password");
        passwordlabel.setBounds(10, 50, 80, 25);
        panel.add(passwordlabel);
        passwordtext = new JPasswordField();
        passwordtext.setBounds(100, 50, 165, 25);
        panel.add(passwordtext);
    }

    // REQUIRES: panel
    // MODIFIES: this
    // EFFECTS: set up the username label + dimensions
    private void userLabel(JPanel panel) {
        // USERNAME TEXT
        userlabel = new JLabel("User");
        userlabel.setBounds(10, 20, 80, 25);
        panel.add(userlabel);
        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);
    }


    // REQUIRES: correct input in user and password text field
    // EFFECTS: Opens MainJFrame Window after correct username + password is entered
    //          closes the admin login window
    //          throws FileNotFound and ioException

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordtext.getText();

        if (user.equals("Avani") && password.equals("210")) {
            success.setText("Login Successful!");
            frame.dispose();
            try {
                new MainJFrame();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "File not Found");
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(null, "File not Found");
            }

        } else {
            System.out.println("Please try again");
        }
    }
}

