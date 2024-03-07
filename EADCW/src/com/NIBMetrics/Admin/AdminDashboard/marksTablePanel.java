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
    public marksTablePanel() {

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

                ResultSet rs = statement.executeQuery("SELECT * FROM marks");

                while (rs.next()) {
                    String stuID = rs.getString("studentId");
                    String cwg = rs.getString("cwGrade");
                    String eg = rs.getString("examGrade");
                    String fg = rs.getString("finalGrade");

                    model.addRow(new Object[]{stuID, cwg, eg, fg});
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
