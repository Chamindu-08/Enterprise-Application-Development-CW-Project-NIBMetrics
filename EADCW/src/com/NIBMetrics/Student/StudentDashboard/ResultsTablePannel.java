package com.NIBMetrics.Student.StudentDashboard;

import com.NIBMetrics.DBConnection.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultsTablePannel extends JPanel {
    private JTable table;
    private String uName;
    public ResultsTablePannel(String uName) {
        this.uName=uName;

        setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(new Object[]{"Subject","Course work", "Exam", "Final Grade","Point"});

        fetchDataFromDatabase(model);

        table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane,BorderLayout.CENTER);

        setVisible(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void fetchDataFromDatabase(DefaultTableModel model) {
        try {
            DBConnection DBC = new DBConnection();
            Connection connection = DBC.DBConnection();

            if (connection != null) {
                String studentID = uName;

                String query = "SELECT s.subjectName, m.cwGrade, m.examGrade, m.finalGrade, s.cradit " +
                        "FROM subjects s " +
                        "INNER JOIN marks m ON s.subjectId = m.subjectId " +
                        "WHERE studentID = '" + studentID + "'";

                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query);

                while (rs.next()) {
                    String subjectName = rs.getString("subjectName");
                    String cwGrade = rs.getString("cwGrade");
                    String examGrade = rs.getString("examGrade");
                    String finalGrade = rs.getString("finalGrade");
                    String cradit = rs.getString("cradit");

                    model.addRow(new Object[]{subjectName, cwGrade, examGrade, finalGrade, cradit});
                }

                rs.close();
                statement.close();
                connection.close();
            } else {
                System.out.println("Failed database connection.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
