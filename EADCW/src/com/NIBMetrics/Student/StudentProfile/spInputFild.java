package com.NIBMetrics.Student.StudentProfile;

import javax.swing.*;
import java.awt.*;

public class spInputFild extends JPanel {
    private JLabel sId,sName,email,contact,batch,password,conPassword;
    private JTextField sIdFild,sNameFild,contactFild,emailFild;
    private JPasswordField passwordField,conPasswordFild;
    private JComboBox batchCMB;

    public spInputFild() {
        setLayout(new GridLayout(8,2,5,5));

        initializeUI();
    }
    private void initializeUI() {

        sId = new JLabel("Student ID");
        sName = new JLabel("Student Name");
        email = new JLabel("Email");
        contact = new JLabel("Contact no");
        batch = new JLabel("Batch");
        password = new JLabel("Password");
        conPassword = new JLabel("Conform Password");

        sId.setForeground(Color.white);
        sName.setForeground(Color.white);
        email.setForeground(Color.white);
        contact.setForeground(Color.white);
        batch.setForeground(Color.white);
        password.setForeground(Color.white);
        conPassword.setForeground(Color.white);

        sIdFild = new JTextField(12);
        sNameFild = new JTextField(12);
        emailFild = new JTextField(12);
        contactFild = new JTextField(12);
        passwordField = new JPasswordField(12);
        conPasswordFild = new JPasswordField(12);
        batchCMB = new JComboBox<>();

        add(sName);
        add(sId);
        add(sNameFild);
        add(sIdFild);
        add(email);
        add(contact);
        add(emailFild);
        add(contactFild);
        add(batch);
        add(password);
        add(batchCMB);
        add(passwordField);
        add(conPassword);
        add(conPasswordFild);

        //empty space
        add(Box.createVerticalStrut(2));

    }
}
