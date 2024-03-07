package com.NIBMetrics.Student.StudentRegister;

import com.NIBMetrics.Admin.AdminLogin.AdminLoginScreen;
import com.NIBMetrics.Admin.LRNavBar;
import com.NIBMetrics.DBConnection.DBConnection;
import com.NIBMetrics.Student.StudentLogin.StudentLoginScreen;
import com.NIBMetrics.Student.StudentLogin.sSideImagePanel;
import com.NIBMetrics.Student.studentRegisterHeader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentRegisterScreen extends JFrame {
    private sRegInputPanel inputPanel;
    private JPanel navBar;
    private JPanel registerHeader;
    private JPanel sideImg;
    private JButton registerBtn;

    public StudentRegisterScreen() throws HeadlessException {
        this("Student | Sing in");
    }

    public StudentRegisterScreen(String title) throws HeadlessException{
        super(title);
        navBar = new LRNavBar();
        registerHeader = new studentRegisterHeader();
        inputPanel = new sRegInputPanel();;
        sideImg = new sSideImagePanel();
        registerBtn = new JButton("Register");

        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerStudent();
            }
        });

        initializeUI();
    }

    private void initializeUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(new Color(20, 33, 61));
        container.setBackground(Color.WHITE);
        registerHeader.setBackground(Color.WHITE);

        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

        //button font size, background color, font color
        registerBtn.setFont(font);
        registerBtn.setBackground(new Color(20, 33, 61));
        registerBtn.setForeground(Color.WHITE);

        //empty panel for space
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(getWidth(),50));

        JPanel emptyPanelWest = new JPanel();
        emptyPanelWest.setPreferredSize(new Dimension(50, getHeight()));

        JPanel inputSetup = new JPanel();
        inputSetup.setLayout(new BorderLayout());
        inputSetup.add(registerHeader, BorderLayout.NORTH);
        inputSetup.add(inputPanel, BorderLayout.CENTER);
        inputSetup.add(registerBtn, BorderLayout.SOUTH);

        JPanel sideImage = new JPanel();
        sideImage.setLayout(new BorderLayout());
        sideImage.add(sideImg, BorderLayout.CENTER);

        container.add(navBar, BorderLayout.NORTH);
        container.add(inputSetup, BorderLayout.CENTER);
        container.add(sideImage, BorderLayout.EAST);
        container.add(emptyPanel, BorderLayout.SOUTH);
        container.add(emptyPanelWest, BorderLayout.WEST);

        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void registerStudent() {
        String enteredUsername = inputPanel.getNameFild().getText();
        String enteredPassword = new String(inputPanel.getPasswordField().getPassword());
        String enteredComPassword = new String(inputPanel.getConPasswordField().getPassword());
        String selectedValue = (String) inputPanel.getBatchCMB().getSelectedItem();

        if (enteredUsername.isEmpty() || enteredPassword.isEmpty() || enteredComPassword.isEmpty() || selectedValue == null) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!enteredPassword.equals(enteredComPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords don't match", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            DBConnection dbc = new DBConnection();
            Connection connection = dbc.DBConnection();

            String query = "INSERT INTO student(studentId,studentPassword,batchId)\n" +
                    "VALUE (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, enteredUsername);
            preparedStatement.setString(2, enteredPassword);
            preparedStatement.setString(3, selectedValue);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Student registered successfully", "Success Regidtation", JOptionPane.INFORMATION_MESSAGE);
                new StudentLoginScreen().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to register student", "Error", JOptionPane.ERROR_MESSAGE);
            }

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentRegisterScreen();
        });
    }
}
