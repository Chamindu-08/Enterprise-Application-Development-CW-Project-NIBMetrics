package com.NIBMetrics.Admin.MarkUpdate;

import com.NIBMetrics.DBConnection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class muFilterPanel extends JPanel{
    private JComboBox programCMB, batchCMB, subjectCMB, studentIDCMB;
    private JLabel program, batch, subject, sID, cw, em, fg;
    private JTextField cwFild, emFild, fgFild;
    public muFilterPanel() {
        setLayout(new GridLayout(8,2,5,5));
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

                ResultSet studentResultSet = statement.executeQuery("SELECT studentID FROM student");
                while (studentResultSet.next()) {
                    String studentValue = studentResultSet.getString("studentID");
                    studentIDCMB.addItem(studentValue);
                }

                programResultSet.close();
                batchResultSet.close();
                subjectResultSet.close();
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
    private void initializeUI() {
        program = new JLabel("Programe");
        programCMB = new JComboBox<>();
        batch = new JLabel("Batch");
        batchCMB = new JComboBox<>();
        subject = new JLabel("Subject");
        subjectCMB = new JComboBox<>();
        sID = new JLabel("Studnet ID");
        studentIDCMB = new JComboBox<>();
        cw = new JLabel("Course work");
        cwFild = new JTextField();
        em = new JLabel("Exam");
        emFild = new JTextField();
        fg = new JLabel("Final Grade");
        fgFild = new JTextField();

        program.setForeground(Color.white);
        batch.setForeground(Color.white);
        subject.setForeground(Color.white);
        sID.setForeground(Color.white);
        cw.setForeground(Color.white);
        em.setForeground(Color.white);
        fg.setForeground(Color.white);

        add(program);
        add(programCMB);
        add(batch);
        add(batchCMB);
        add(subject);
        add(subjectCMB);
        add(sID);
        add(studentIDCMB);
        add(cw);
        add(cwFild);
        add(em);
        add(emFild);
        add(fg);
        add(fgFild);

        //empty space
        add(Box.createVerticalStrut(2));
    }

    public JComboBox getProgramCMB() {
        return programCMB;
    }

    public JComboBox getBatchCMB() {
        return batchCMB;
    }

    public JComboBox getSubjectCMB() {
        return subjectCMB;
    }

    public JComboBox getStudentIDCMB() {
        return studentIDCMB;
    }

    public JTextField getCwFild() {
        return cwFild;
    }

    public JTextField getEmFild() {
        return emFild;
    }

    public JTextField getFgFild() {
        return fgFild;
    }
}
