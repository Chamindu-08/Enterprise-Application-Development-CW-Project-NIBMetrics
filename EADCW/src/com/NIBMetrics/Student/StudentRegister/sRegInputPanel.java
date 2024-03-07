package com.NIBMetrics.Student.StudentRegister;

import com.NIBMetrics.DBConnection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class sRegInputPanel extends JPanel {
    private JLabel name, batch, password, conPassword;
    private JTextField nameFild;
    private JComboBox batchCMB;
    private JPasswordField passwordField, conPasswordField;
    public sRegInputPanel() {
        setLayout(new GridLayout(9,1,5,5));

        initializeUI();

        loadCMBValues();
    }

    private void loadCMBValues() {
        try {
            DBConnection DBC = new DBConnection();
            Connection connection = DBC.DBConnection();

            if (connection != null) {
                Statement statement = connection.createStatement();

                ResultSet batchResultSet = statement.executeQuery("SELECT batchID FROM batch");
                while (batchResultSet.next()) {
                    String batchValue = batchResultSet.getString("batchID");
                    batchCMB.addItem(batchValue);
                }

                batchResultSet.close();
                statement.close();
            } else {
                System.out.println("Failed database connection.");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public JTextField getNameFild() {
        return nameFild;
    }

    public JComboBox getBatchCMB() {
        return batchCMB;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JPasswordField getConPasswordField() {
        return conPasswordField;
    }
}
