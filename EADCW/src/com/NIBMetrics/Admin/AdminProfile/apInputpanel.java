package com.NIBMetrics.Admin.AdminProfile;

import javax.swing.*;
import java.awt.*;

public class apInputpanel extends JPanel {
    private JLabel lecId,lecName,email,contact,nic,password,conPassword;
    private JTextField lecIdFild,lecNameFild,contactFild,emailFild,nicFild;
    private JPasswordField passwordField,conPasswordFild;

    public apInputpanel() {
        setLayout(new GridLayout(8,2,5,5));

        initializeUI();
    }
    private void initializeUI() {

        lecId = new JLabel("Lecture ID");
        lecName = new JLabel("Lecture Name");
        email = new JLabel("Email");
        contact = new JLabel("Contact no");
        nic = new JLabel("NIC");
        password = new JLabel("Password");
        conPassword = new JLabel("Conform Password");

        lecId.setForeground(Color.white);
        lecName.setForeground(Color.white);
        email.setForeground(Color.white);
        contact.setForeground(Color.white);
        nic.setForeground(Color.white);
        password.setForeground(Color.white);
        conPassword.setForeground(Color.white);

        lecIdFild = new JTextField(12);
        lecNameFild = new JTextField(12);
        emailFild = new JTextField(12);
        contactFild = new JTextField(12);
        passwordField = new JPasswordField(12);
        conPasswordFild = new JPasswordField(12);
        nicFild = new JTextField(12);

        add(lecName);
        add(lecId);
        add(lecNameFild);
        add(lecIdFild);
        add(email);
        add(contact);
        add(emailFild);
        add(contactFild);
        add(nic);
        add(password);
        add(nicFild);
        add(passwordField);
        add(conPassword);
        add(conPasswordFild);

        //empty space
        add(Box.createVerticalStrut(2));

    }
}
