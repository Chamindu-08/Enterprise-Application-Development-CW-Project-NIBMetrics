package com.NIBMetrics.Admin.AdminDashboard;

import com.NIBMetrics.Admin.AdminNavBar;
import com.NIBMetrics.DBConnection.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminDashboardScreen extends JFrame {
    private JPanel navBar;
    private filterPanel filterPanel;
    private JPanel marksTable;
    private String uName;
    private JTable table;
    private JButton saveBtn, searchBtn;
    private String selectedProgram, selectedBatch, selectedSubject;

    public AdminDashboardScreen() throws HeadlessException {
        this("Admin | Dashboard", "");
    }

    public AdminDashboardScreen(String title, String uName) throws HeadlessException {
        super(title);
        this.uName = uName;
        navBar = new AdminNavBar(uName);
        filterPanel = new filterPanel();
        marksTable = new marksTablePanel("", "", "");
        saveBtn = new JButton("Submit");
        searchBtn = new JButton("Search");

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertMarks();
            }
        });

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getCMBValues();
                marksTablePanel mtp = new marksTablePanel(selectedProgram, selectedBatch, selectedSubject);
            }
        });

        initializeUI();
    }

    private void initializeUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(new Color(20, 33, 61));

        saveBtn.setBackground(Color.BLUE);
        saveBtn.setForeground(Color.white);

        searchBtn.setBackground(Color.BLUE);
        searchBtn.setForeground(Color.white);

        //empty panel for space
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(getWidth(), 50));

        JPanel emptyPanelWest = new JPanel();
        emptyPanelWest.setPreferredSize(new Dimension(50, getHeight()));

        JPanel emptyPanelEast = new JPanel();
        emptyPanelEast.setPreferredSize(new Dimension(50, getHeight()));

        //change background color
        emptyPanel.setBackground(new Color(20, 33, 61));
        emptyPanelWest.setBackground(new Color(20, 33, 61));
        emptyPanelEast.setBackground(new Color(20, 33, 61));
        navBar.setBackground(new Color(20, 33, 61));
        filterPanel.setBackground(new Color(20, 33, 61));
        marksTable.setBackground(new Color(20, 33, 61));

        //button panel
        JPanel nestedPanel = new JPanel();
        nestedPanel.setBackground(new Color(20, 33, 61));
        nestedPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        nestedPanel.add(searchBtn);
        nestedPanel.add(saveBtn);

        //nestedPanel add btnPanel
        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new BorderLayout());
        btnPanel.setBackground(new Color(20, 33, 61));
        btnPanel.add(nestedPanel, BorderLayout.CENTER);

        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());
        body.add(filterPanel, BorderLayout.NORTH);
        body.add(marksTable, BorderLayout.CENTER);
        body.add(btnPanel, BorderLayout.SOUTH);

        container.add(navBar, BorderLayout.NORTH);
        container.add(body, BorderLayout.CENTER);
        container.add(emptyPanel, BorderLayout.SOUTH);
        container.add(emptyPanelEast, BorderLayout.EAST);
        container.add(emptyPanelWest, BorderLayout.WEST);

        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void getCMBValues() {
        selectedProgram = (String) filterPanel.getProgramCMB().getSelectedItem();
        selectedBatch = (String) filterPanel.getBatchCMB().getSelectedItem();
        selectedSubject = (String) filterPanel.getSubjectCMB().getSelectedItem();
    }

    private void insertMarks() {
        getCMBValues();
        DefaultTableModel model = (DefaultTableModel) ((marksTablePanel) marksTable).getTable().getModel();
        int rowCount = model.getRowCount();

        try {
            DBConnection dbc = new DBConnection();
            Connection connection = dbc.DBConnection();

            if (connection != null) {
                Statement statement = connection.createStatement();

                String subjectIdQuery = "SELECT subjectId FROM subjects WHERE subjectName = '" + selectedSubject + "'";
                ResultSet subjectIdResult = statement.executeQuery(subjectIdQuery);
                String subjectId = "";

                if (subjectIdResult.next()) {
                    subjectId = subjectIdResult.getString("subjectId");
                } else {
                    System.out.println("Subject ID not found for subject: " + selectedSubject);
                    return;
                }

                //insert marks
                for (int i = 0; i < rowCount; i++) {
                    String studentId = (String) model.getValueAt(i, 0);
                    String coursework = (String) model.getValueAt(i, 1);
                    String exam = (String) model.getValueAt(i, 2);
                    String finalGrade = (String) model.getValueAt(i, 3);

                    String insertQuery = "INSERT INTO marks(studentId,subjectId,cwGrade,examGrade,finalGrade) VALUES ('" +
                            studentId + "', '" + subjectId + "', '" + coursework + "', '" + exam + "', '" + finalGrade + "')";

                    statement.executeUpdate(insertQuery);
                }

                statement.close();
                connection.close();
                JOptionPane.showMessageDialog(this, "Data saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed database connection.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error saving data to the database", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
