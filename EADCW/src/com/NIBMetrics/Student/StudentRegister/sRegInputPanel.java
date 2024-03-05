package com.NIBMetrics.Student.StudentRegister;

import javax.swing.*;
import java.awt.*;

public class sRegInputPanel extends JPanel {
    private JLabel name, batch, password, conPassword;
    private JTextField nameFild;
    private JComboBox batchCMB;
    private JPasswordField passwordField, conPasswordField;
    public sRegInputPanel() {
        setLayout(new GridLayout(9,1,5,5));

        initializeUI();
    }
    private void initializeUI() {

        name = new JLabel("Student ID :");
        batch = new JLabel("Batch");
        password = new JLabel("Password :");
        conPassword = new JLabel("Conform Password :");
        nameFild = new JTextField(12);
        batchCMB = new JComboBox<>();
        passwordField = new JPasswordField(12);
        conPasswordField = new JPasswordField(12);

        add(name);
        add(nameFild);
        add(batch);
        add(batchCMB);
        add(password);
        add(passwordField);
        add(conPassword);
        add(conPasswordField);

        //empty space
        add(Box.createVerticalStrut(2));

    }
}
