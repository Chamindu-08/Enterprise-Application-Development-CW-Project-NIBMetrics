package com.NIBMetrics.Admin.AdminLogin;

import javax.swing.*;
import java.awt.*;

public class InputPannel extends JPanel {
    private JLabel nameLabel, passwordLabel;
    private JTextField nameField;
    private JPasswordField passwordField;

    public InputPannel() {
        setLayout(new GridLayout(5, 1, 5, 5));
        initializeUI();
    }

    private void initializeUI() {
        nameLabel = new JLabel("User Name:");
        passwordLabel = new JLabel("Enter your Password:");
        nameField = new JTextField(12);
        passwordField = new JPasswordField(12);

        add(nameLabel);
        add(nameField);
        add(passwordLabel);
        add(passwordField);

        // empty space
        add(Box.createVerticalStrut(2));
    }

    public JTextField getNameField() {
        return nameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }
}
