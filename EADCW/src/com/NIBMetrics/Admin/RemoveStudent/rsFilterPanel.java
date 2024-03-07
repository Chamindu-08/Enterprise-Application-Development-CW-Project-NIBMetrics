package com.NIBMetrics.Admin.RemoveStudent;

import com.NIBMetrics.DBConnection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class rsFilterPanel extends JPanel {
    private JComboBox programCMB, batchCMB, studentIDCMB;
    private JLabel program, batch, sID;

    public rsFilterPanel() {
        setLayout(new GridLayout(4,2,5,5));
        initializeUI();
        loadCMBValues();
    }

    private void initializeUI() {
        program = new JLabel("Programe");
        programCMB = new JComboBox<>();
        batch = new JLabel("Batch");
        batchCMB = new JComboBox<>();
        sID = new JLabel("Studnet ID");
        studentIDCMB = new JComboBox<>();

        program.setForeground(Color.white);
        batch.setForeground(Color.white);
        sID.setForeground(Color.white);

        add(program);
        add(programCMB);
        add(batch);
        add(batchCMB);
        add(sID);
        add(studentIDCMB);

        //empty space
        add(Box.createVerticalStrut(2));
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

                ResultSet studentResultSet = statement.executeQuery("SELECT studentID FROM student");
                while (studentResultSet.next()) {
                    String studentValue = studentResultSet.getString("studentID");
                    studentIDCMB.addItem(studentValue);
                }

                programResultSet.close();
                batchResultSet.close();
                studentResultSet.close();
                statement.close();
            } else {
                System.out.println("Failed database connection.");
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JComboBox getProgramCMB() {
        return programCMB;
    }

    public JComboBox getBatchCMB() {
        return batchCMB;
    }

    public JComboBox getStudentIDCMB() {
        return studentIDCMB;
    }
}
