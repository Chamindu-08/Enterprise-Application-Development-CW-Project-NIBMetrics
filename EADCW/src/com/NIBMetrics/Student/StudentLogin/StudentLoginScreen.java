package com.NIBMetrics.Student.StudentLogin;

import com.NIBMetrics.Admin.AdminDashboard.AdminDashboardScreen;
import com.NIBMetrics.Admin.AdminLogin.AdminLoginScreen;
import com.NIBMetrics.Admin.AdminLogin.InputPannel;
import com.NIBMetrics.Admin.AdminLogin.SideImagePanel;
import com.NIBMetrics.Admin.LRNavBar;
import com.NIBMetrics.Admin.LoginFooter;
import com.NIBMetrics.Admin.LoginHeader;
import com.NIBMetrics.DBConnection.DBConnection;
import com.NIBMetrics.Student.StudentDashboard.StudentDashboardScreen;
import com.NIBMetrics.Student.StudentNavBar;
import com.NIBMetrics.Student.studentLoginHeader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentLoginScreen extends JFrame {
    private sInputPanel inputPanel;
    private JPanel navBar;
    private JPanel loginHeader;
    private JPanel loginFooter;
    private JPanel sideImg;
    private JButton loginBtn;

    public StudentLoginScreen() throws HeadlessException {
        this("Student | Sign in");
    }

    public StudentLoginScreen(String title) throws HeadlessException{
        super(title);
        navBar = new LRNavBar();
        loginHeader = new studentLoginHeader();
        inputPanel = new sInputPanel();
        loginFooter = new LoginFooter();
        sideImg = new sSideImagePanel();

        loginBtn = new JButton("Login");

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkPassword();
            }
        });

        initializeUI();
    }

    private void initializeUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(new Color(20, 33, 61));
        container.setBackground(Color.WHITE);
        loginHeader.setBackground(Color.WHITE);

        //set login button
        loginFooter.setBackground(Color.WHITE);
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

        //set button font, background color, font color
        loginBtn.setFont(font);
        loginBtn.setBackground(new Color(20, 33, 61));
        loginBtn.setForeground(Color.WHITE);

        JPanel footer = new JPanel();
        footer.setLayout(new BorderLayout());
        footer.add(loginFooter, BorderLayout.NORTH);
        footer.add(loginBtn, BorderLayout.SOUTH);

        //empty panel for space
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(getWidth(),50));

        JPanel emptyPanelWest = new JPanel();
        emptyPanelWest.setPreferredSize(new Dimension(50, getHeight()));

        JPanel inputSetup = new JPanel();
        inputSetup.setLayout(new BorderLayout());
        inputSetup.add(loginHeader, BorderLayout.NORTH);
        inputSetup.add(inputPanel, BorderLayout.CENTER);
        inputSetup.add(footer, BorderLayout.SOUTH);

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

    private void checkPassword() {
        String enteredUsername = inputPanel.getNameFild().getText();
        String enteredPassword = new String(inputPanel.getPasswordField().getPassword());

        try {
            DBConnection dbc = new DBConnection();
            Connection connection = dbc.DBConnection();

            String query = "SELECT studentPassword FROM student WHERE studentId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, enteredUsername);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("studentPassword");
                if (enteredPassword.equals(storedPassword)) {
                    new StudentDashboardScreen().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }

            rs.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentLoginScreen();
        });
    }
}
