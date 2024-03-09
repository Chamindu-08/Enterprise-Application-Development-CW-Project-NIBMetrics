package com.NIBMetrics.Admin.MarkUpdate;

import com.NIBMetrics.Admin.AdminNavBar;
import com.NIBMetrics.Admin.AdminProfile.AdminProfileScreen;
import com.NIBMetrics.DBConnection.DBConnection;
import com.NIBMetrics.Student.StudentDashboard.StudentDashboardScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MarkUpdateScreen extends JFrame {
    private JPanel navBar;
    private muFilterPanel filterBar;
    private JPanel titale2;
    private JButton saveBtn;
    private String uName;
    public MarkUpdateScreen() throws HeadlessException {
        this("Admin | Dashboard","");
    }

    public MarkUpdateScreen(String title,String uName) throws HeadlessException{
        super(title);
        this.uName=uName;
        navBar = new AdminNavBar(uName);
        filterBar = new muFilterPanel();
        titale2 = new muTitlePanel();
        saveBtn = new JButton("Submit");

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMark();
                getRootPane().getParent().setVisible(false);
            }
        });

        initializeUI();
    }

    private void initializeUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(new Color(20, 33, 61));

        //change button color and text color
        saveBtn.setBackground(Color.BLUE);
        saveBtn.setForeground(Color.white);

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
        titale2.setBackground(new Color(20, 33, 61));

        //change button size
        JPanel saveBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        saveBtnPanel.add(saveBtn);
        saveBtnPanel.setPreferredSize(new Dimension(saveBtnPanel.getPreferredSize().width, 35));
        saveBtnPanel.setBackground(new Color(20, 33, 61));

        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());
        body.add(filterBar, BorderLayout.CENTER);
        body.add(saveBtnPanel, BorderLayout.SOUTH);
        body.add(titale2, BorderLayout.NORTH);

        container.add(body, BorderLayout.CENTER);
        container.add(navBar, BorderLayout.NORTH);
        container.add(emptyPanelWest, BorderLayout.WEST);
        container.add(emptyPanelEast, BorderLayout.EAST);
        container.add(emptyPanel, BorderLayout.SOUTH);

        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void updateMark() {
        String selectedProgram = (String) filterBar.getProgramCMB().getSelectedItem();
        String selectedBatch = (String) filterBar.getBatchCMB().getSelectedItem();
        String selectedSubject = (String) filterBar.getSubjectCMB().getSelectedItem();
        String selectedStudent = (String) filterBar.getStudentIDCMB().getSelectedItem();
        String cwMark = filterBar.getCwFild().getText();
        String examMark = filterBar.getEmFild().getText();
        String finalMark = filterBar.getFgFild().getText();

        if (selectedProgram.isEmpty() || selectedBatch.isEmpty() || selectedSubject.isEmpty() || selectedStudent.isEmpty() || cwMark.isEmpty() || examMark.isEmpty() || finalMark.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            DBConnection dbc = new DBConnection();
            Connection connection = dbc.DBConnection();

            //get subjectID form db
            String subjectIdQuery = "SELECT subjectID FROM subjects WHERE subjectName = ?";
            PreparedStatement subjectIdStatement = connection.prepareStatement(subjectIdQuery);
            subjectIdStatement.setString(1, selectedSubject);
            ResultSet subjectIdResult = subjectIdStatement.executeQuery();

            String subjectId = null;
            if (subjectIdResult.next()) {
                subjectId = subjectIdResult.getString("SubjectID");
            } else {
                JOptionPane.showMessageDialog(this, "Subject not found in the database", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            subjectIdResult.close();
            subjectIdStatement.close();

            //marks update queary
            String query = "UPDATE marks SET cwGrade = ?, examGrade = ?, finalGrade = ? WHERE studentId = ? AND subjectId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cwMark);
            preparedStatement.setString(2, examMark);
            preparedStatement.setString(3, finalMark);
            preparedStatement.setString(4, selectedStudent);
            preparedStatement.setString(5, subjectId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Marks updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                getRootPane().getParent().setVisible(false);
                new MarkUpdateScreen("Admin | Result Update", uName).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update marks", "Error", JOptionPane.ERROR_MESSAGE);
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
