package com.NIBMetrics.Admin.RemoveStudent;

import com.NIBMetrics.Admin.AdminNavBar;
import com.NIBMetrics.DBConnection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRemoveScreen extends JFrame{
    private JPanel navBar;
    private rsFilterPanel filterBar;
    private JPanel title1;
    private JButton removeBtn;
    private String uName;
    public StudentRemoveScreen() throws HeadlessException {
        this("Admin | Dashboard","");
    }

    public StudentRemoveScreen(String title,String uName) throws HeadlessException{
        super(title);
        this.uName=uName;
        navBar = new AdminNavBar(uName);
        filterBar = new rsFilterPanel();
        title1 = new rsTitlePanel();
        removeBtn = new JButton("Remove");

        removeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeStudent();
            }
        });

        initializeUI();
    }

    private void initializeUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(new Color(20, 33, 61));

        //change remove button color and font color
        removeBtn.setBackground(Color.BLUE);
        removeBtn.setForeground(Color.white);

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
        filterBar.setBackground(new Color(20, 33, 61));
        title1.setBackground(new Color(20, 33, 61));

        //change button size
        JPanel removeBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        removeBtnPanel.add(removeBtn);
        removeBtnPanel.setPreferredSize(new Dimension(removeBtnPanel.getPreferredSize().width, 35));
        removeBtnPanel.setBackground(new Color(20, 33, 61));

        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());
        body.add(title1, BorderLayout.NORTH);
        body.add(filterBar, BorderLayout.CENTER);
        body.add(removeBtnPanel, BorderLayout.SOUTH);

        container.add(body, BorderLayout.CENTER);
        container.add(navBar, BorderLayout.NORTH);
        container.add(emptyPanelWest, BorderLayout.WEST);
        container.add(emptyPanelEast, BorderLayout.EAST);
        container.add(emptyPanel, BorderLayout.SOUTH);

        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void removeStudent() {
        String selectedProgram = (String) filterBar.getProgramCMB().getSelectedItem();
        String selectedBatch = (String) filterBar.getBatchCMB().getSelectedItem();
        String selectedStudent = (String) filterBar.getStudentIDCMB().getSelectedItem();

        if (selectedProgram.isEmpty() || selectedBatch.isEmpty() || selectedStudent.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            DBConnection dbc = new DBConnection();
            Connection connection = dbc.DBConnection();

            String removeMarksQuery = "DELETE FROM marks WHERE studentId = ?";
            PreparedStatement removeMarksStatement = connection.prepareStatement(removeMarksQuery);
            removeMarksStatement.setString(1, selectedStudent);
            int marksRowsAffected = removeMarksStatement.executeUpdate();

            String removeStudentQuery = "DELETE FROM student WHERE studentId = ?";
            PreparedStatement removeStudentStatement = connection.prepareStatement(removeStudentQuery);
            removeStudentStatement.setString(1, selectedStudent);
            int studentRowsAffected = removeStudentStatement.executeUpdate();

            if (studentRowsAffected > 0 && marksRowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Student removed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to remove student", "Error", JOptionPane.ERROR_MESSAGE);
            }

            removeStudentStatement.close();
            removeMarksStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
