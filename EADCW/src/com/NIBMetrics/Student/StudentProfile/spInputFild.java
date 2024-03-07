package com.NIBMetrics.Student.StudentProfile;

import com.NIBMetrics.DBConnection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class spInputFild extends JPanel {
    private JLabel sId,sName,email,contact,batch,password,conPassword;
    private JTextField sIdFild,sNameFild,contactFild,emailFild,batchCMB;
    private JPasswordField passwordField,conPasswordFild;
    private String uName;

    public spInputFild(String uName) {
        this.uName=uName;
        setLayout(new GridLayout(8,2,5,5));

        initializeUI();
        fillTextFields();
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
        batchCMB = new  JPasswordField(12);

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

    private void fillTextFields() {
        try {
            DBConnection dbc = new DBConnection();
            Connection connection = dbc.DBConnection();

            String query = "SELECT studentId, studentName, studentContactNo, studentEmail, batchId FROM student WHERE studentId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, uName);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                sIdFild.setText(resultSet.getString("studentId"));
                sNameFild.setText(resultSet.getString("studentName"));
                contactFild.setText(resultSet.getString("studentContactNo"));
                emailFild.setText(resultSet.getString("studentEmail"));
                batchCMB.setText(resultSet.getString("batchId"));
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data from the database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JTextField getsNameFild() {
        return sNameFild;
    }

    public JTextField getContactFild() {
        return contactFild;
    }

    public JTextField getEmailFild() {
        return emailFild;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JPasswordField getConPasswordFild() {
        return conPasswordFild;
    }
}
