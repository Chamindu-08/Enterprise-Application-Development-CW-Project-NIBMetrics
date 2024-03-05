package com.NIBMetrics.Student.StudentDashboard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultsTablePannel extends JPanel {
    private JTable table;
    public ResultsTablePannel() {

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
        // JDBC connection parameters
        String url = "jdbc:mysql://localhost:3350/nibm";
        String username = "root";
        String password = "MySql@1nibm57";

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute a query to retrieve data
            ResultSet rs = statement.executeQuery("SELECT * FROM contactsdetails");

            // Iterate through the result set and add data to the model
            while (rs.next()) {
                int ID;
                String name;
                String number;
                model.addRow(new Object[]{
                        ID = rs.getInt("ID"),
                        name = rs.getString("Name"),
                        number = rs.getString("PhoneNumber"),
                });
            }

            // Close the resources
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
