package com.NIBMetrics.Admin.AdminDashboard;

import com.NIBMetrics.DBConnection.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class marksTablePanel extends JPanel{

    private JTable table;
    private String selectedProgram,selectedBatch,selectedSubject;
    public marksTablePanel(String programe, String batch, String subject) {
        this.selectedProgram=programe;
        this.selectedBatch=batch;
        this.selectedSubject=subject;

        setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(new Object[]{"Student ID","Course work", "Exam", "Final Grade"});

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
                Statement statement = connection.createStatement();

                String marksQuery = "SELECT studentId FROM student";
                ResultSet rs = statement.executeQuery(marksQuery);

                while (rs.next()) {
                    String stuID = rs.getString("studentId");
                    model.addRow(new Object[]{stuID});
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

    public JTable getTable() {
        return table;
    }
}
