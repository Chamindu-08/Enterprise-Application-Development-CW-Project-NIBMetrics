package com.NIBMetrics.Student.StudentProfile;

import com.NIBMetrics.DBConnection.DBConnection;
import com.NIBMetrics.Student.StudentNavBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentProfileScreen extends JFrame {
    private JPanel navBar;
    private spInputFild filterPanel;
    private JPanel title2;
    private String uName;
    private JButton saveBtn;
    public StudentProfileScreen() throws HeadlessException {
        this("Admin | Dashboard","");
    }

    public StudentProfileScreen(String title,String uName) throws HeadlessException{
        super(title);
        this.uName=uName;
        navBar = new StudentNavBar(uName);
        title2 = new spTitalePanel();
        filterPanel = new spInputFild(uName);
        saveBtn = new JButton("Save");

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProfile();
                getRootPane().getParent().setVisible(false);
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

        //change button size
        JPanel saveBtnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        saveBtnPanel.add(saveBtn);
        saveBtnPanel.setPreferredSize(new Dimension(saveBtnPanel.getPreferredSize().width, 35));
        saveBtnPanel.setBackground(new Color(20, 33, 61));

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
        title2.setBackground(new Color(20, 33, 61));

        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());
        body.add(title2, BorderLayout.NORTH);
        body.add(filterPanel, BorderLayout.CENTER);
        body.add(saveBtnPanel, BorderLayout.SOUTH);

        container.add(navBar, BorderLayout.NORTH);
        container.add(body, BorderLayout.CENTER);
        container.add(emptyPanel, BorderLayout.SOUTH);
        container.add(emptyPanelEast, BorderLayout.EAST);
        container.add(emptyPanelWest, BorderLayout.WEST);

        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void updateProfile() {

        String enteredUsername = filterPanel.getsNameFild().getText();
        String enteredContactNo = filterPanel.getContactFild().getText();
        String enteredEmail = filterPanel.getEmailFild().getText();
        String enteredPassword = new String(filterPanel.getPasswordField().getPassword());
        String enteredComPassword = new String(filterPanel.getConPasswordFild().getPassword());

        if (enteredPassword.isEmpty() && enteredComPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!enteredPassword.equals(enteredComPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            DBConnection dbc = new DBConnection();
            Connection connection = dbc.DBConnection();

            String query = "UPDATE student SET studentName = ?, studentContactNo = ?, studentEmail = ?, studentPassword = ? WHERE studentId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, enteredUsername);
            preparedStatement.setString(2, enteredContactNo);
            preparedStatement.setString(3, enteredEmail);
            preparedStatement.setString(4, enteredPassword);
            preparedStatement.setString(5, uName);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Profile updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                getRootPane().getParent().setVisible(false);
                new StudentProfileScreen("Admin | Profile", uName).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Profile update failed", "Error", JOptionPane.ERROR_MESSAGE);
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error updating profile", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
