package com.NIBMetrics.Admin.AdminRegister;

import com.NIBMetrics.Admin.*;
import com.NIBMetrics.Admin.AdminDashboard.AdminDashboardScreen;
import com.NIBMetrics.Admin.AdminLogin.AdminLoginScreen;
import com.NIBMetrics.Admin.AdminLogin.InputPannel;
import com.NIBMetrics.Admin.AdminLogin.SideImagePanel;
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

public class AdminRegisterScreen extends JFrame{
    private RegInputPanel inputPanel;
    private JPanel navBar;
    private JPanel registerHeader;
    private JPanel sideImg;
    private JButton registerBtn;

    public AdminRegisterScreen() throws HeadlessException {
        this("Admin | Sing in");
    }

    public AdminRegisterScreen(String title) throws HeadlessException{
        super(title);
        navBar = new LRNavBar();
        registerHeader = new RegiserHeader();
        inputPanel = new RegInputPanel();
        sideImg = new SideImagePanel();

        registerBtn = new JButton("Register");
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerAdmin();
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

    private void registerAdmin() {
        String enteredUsername = inputPanel.getNameFild().getText();
        String enteredPassword = new String(inputPanel.getPasswordField().getPassword());
        String enteredComPassword = new String(inputPanel.getConPasswordField().getPassword());
        String lectureID = generateLectureID();

        if (enteredUsername.isEmpty() || enteredPassword.isEmpty() || enteredComPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            DBConnection dbc = new DBConnection();
            Connection connection = dbc.DBConnection();

            if (enteredPassword.equals(enteredComPassword)) {

                String query = "INSERT INTO lecture(lectureId,lectureEmail,lecturePassword)\n" +
                        "VALUE (?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, lectureID);
                preparedStatement.setString(2, enteredUsername);
                preparedStatement.setString(3, enteredPassword);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Admin registered successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    new AdminLoginScreen().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to register admin", "Error", JOptionPane.ERROR_MESSAGE);
                }

                preparedStatement.close();
                connection.close();
            } else {
                JOptionPane.showMessageDialog(this, "Passwords don't match", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private String generateLectureID() {
        String lectureID = "";
        try {
            DBConnection dbc = new DBConnection();
            Connection connection = dbc.DBConnection();

            String query = "SELECT MAX(lectureID) AS maxID FROM lecture";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String maxID = resultSet.getString("maxID");
                if (maxID != null) {
                    int num = Integer.parseInt(maxID.substring(1)) + 1;
                    lectureID = "L" + String.format("%02d", num);
                } else {
                    lectureID = "L01";
                }
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return lectureID;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AdminRegisterScreen();
        });
    }
}
