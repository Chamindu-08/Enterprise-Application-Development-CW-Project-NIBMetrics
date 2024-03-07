package com.NIBMetrics.Admin.AdminProfile;

import com.NIBMetrics.DBConnection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class apInputpanel extends JPanel {
    private JLabel lecId,lecName,email,contact,nic,password,conPassword;
    private JTextField lecIdFild,lecNameFild,contactFild,emailFild,nicFild;
    private JPasswordField passwordField,conPasswordFild;
    private String uName;

    public apInputpanel(String uName) {
        this.uName=uName;
        setLayout(new GridLayout(8,2,5,5));

        initializeUI();
        fillTextFields();
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

    private void fillTextFields() {
        try {
            DBConnection dbc = new DBConnection();
            Connection connection = dbc.DBConnection();

            String query = "SELECT lectureID, lectureName, lectureContactNo, lectureEmail, lectureNIC FROM lecture WHERE lectureEmail = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, uName);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                lecIdFild.setText(resultSet.getString("lectureID"));
                lecNameFild.setText(resultSet.getString("lectureName"));
                contactFild.setText(resultSet.getString("lectureContactNo"));
                emailFild.setText(resultSet.getString("lectureEmail"));
                nicFild.setText(resultSet.getString("lectureNIC"));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data from the database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JTextField getLecNameFild() {
        return lecNameFild;
    }

    public JTextField getContactFild() {
        return contactFild;
    }

    public JTextField getNicFild() {
        return nicFild;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JPasswordField getConPasswordFild() {
        return conPasswordFild;
    }
}
