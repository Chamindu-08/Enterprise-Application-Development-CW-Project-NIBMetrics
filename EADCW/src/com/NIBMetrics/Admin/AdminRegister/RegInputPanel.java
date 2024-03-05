package com.NIBMetrics.Admin.AdminRegister;

import javax.swing.*;
import java.awt.*;

public class RegInputPanel extends JPanel {
    private JLabel name,password,conPassword;
    private JTextField nameFild;
    private JPasswordField passwordField, conPasswordField;
    public RegInputPanel() {
        setLayout(new GridLayout(7,1,5,5));

        initializeUI();
    }
    private void initializeUI() {

        name = new JLabel("Lecture ID :");
        password = new JLabel("Password :");
        conPassword = new JLabel("Conform Password :");
        nameFild = new JTextField(12);
        passwordField = new JPasswordField(12);
        conPasswordField = new JPasswordField(12);

        add(name);
        add(nameFild);
        add(password);
        add(passwordField);
        add(conPassword);
        add(conPasswordField);

        //empty space
        add(Box.createVerticalStrut(2));

    }
}
