package com.NIBMetrics.Student.StudentLogin;

import javax.swing.*;
import java.awt.*;

public class sInputPanel extends JPanel {
    private JLabel name,password;
    private JTextField nameFild;
    private JPasswordField passwordField;
    public sInputPanel() {
        setLayout(new GridLayout(5,1,5,5));

        initializeUI();
    }
    private void initializeUI() {

        name = new JLabel("User Name :");
        password = new JLabel("Enter your Password :");
        nameFild = new JTextField(12);
        passwordField = new JPasswordField(12);

        add(name);
        add(nameFild);
        add(password);
        add(passwordField);

        //empty space
        add(Box.createVerticalStrut(2));
    }

    public JTextField getNameFild() {
        return nameFild;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }
}
