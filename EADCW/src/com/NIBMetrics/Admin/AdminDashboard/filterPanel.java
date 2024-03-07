package com.NIBMetrics.Admin.AdminDashboard;

import com.NIBMetrics.DBConnection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class filterPanel extends JPanel {
    private JComboBox<String> programCMB, batchCMB, subjectCMB;
    private JLabel program, batch, subject;

    public filterPanel() {
        setLayout(new GridLayout(4, 2, 5, 5));
        initializeUI();
        loadCMBValues();
    }

    private void loadCMBValues() {
        try {
            DBConnection DBC = new DBConnection();
            Connection connection = DBC.DBConnection();

            if (connection != null) {
                Statement statement = connection.createStatement();

                ResultSet programResultSet = statement.executeQuery("SELECT courseID FROM course");
                while (programResultSet.next()) {
                    String programValue = programResultSet.getString("courseID");
                    programCMB.addItem(programValue);
                }

                ResultSet batchResultSet = statement.executeQuery("SELECT batchID FROM batch");
                while (batchResultSet.next()) {
                    String batchValue = batchResultSet.getString("batchID");
                    batchCMB.addItem(batchValue);
                }

                ResultSet subjectResultSet = statement.executeQuery("SELECT subjectName FROM subjects");
                while (subjectResultSet.next()) {
                    String subjectValue = subjectResultSet.getString("subjectName");
                    subjectCMB.addItem(subjectValue);
                }

                programResultSet.close();
                batchResultSet.close();
                subjectResultSet.close();
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
        program = new JLabel("Program");
        programCMB = new JComboBox<>();
        batch = new JLabel("Batch");
        batchCMB = new JComboBox<>();
        subject = new JLabel("Subject");
        subjectCMB = new JComboBox<>();

        program.setForeground(Color.white);
        batch.setForeground(Color.white);
        subject.setForeground(Color.white);
        add(program);
        add(programCMB);
        add(batch);
        add(batchCMB);
        add(subject);
        add(subjectCMB);

        // empty space
        add(Box.createVerticalStrut(2));
    }

    public JComboBox<String> getProgramCMB() {
        return programCMB;
    }

    public JComboBox<String> getBatchCMB() {
        return batchCMB;
    }

    public JComboBox<String> getSubjectCMB() {
        return subjectCMB;
    }
}
