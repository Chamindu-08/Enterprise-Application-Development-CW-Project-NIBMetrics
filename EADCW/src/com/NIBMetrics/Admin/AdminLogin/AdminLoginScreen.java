package com.NIBMetrics.Admin.AdminLogin;

import com.NIBMetrics.Admin.AdminDashboard.AdminDashboardScreen;
import com.NIBMetrics.Admin.AdminNavBar;
import com.NIBMetrics.Admin.LRNavBar;
import com.NIBMetrics.Admin.LoginFooter;
import com.NIBMetrics.Admin.LoginHeader;
import com.NIBMetrics.DBConnection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminLoginScreen extends JFrame{
    private InputPannel inputPanel;
    private JPanel navBar;
    private JPanel loginHeader;
    private JPanel loginFooter;
    private JPanel sideImg;
    private JButton loginBtn;


    public AdminLoginScreen() throws HeadlessException {
        this("Admin | Sign in");
    }

    public AdminLoginScreen(String title) throws HeadlessException{
        super(title);
        navBar = new LRNavBar();
        loginHeader = new LoginHeader();
        inputPanel = new InputPannel();
        loginFooter = new LoginFooter();
        sideImg = new SideImagePanel();

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

        //empty panel for space
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(getWidth(),50));

        JPanel emptyPanelWest = new JPanel();
        emptyPanelWest.setPreferredSize(new Dimension(50, getHeight()));

        JPanel footer = new JPanel();
        footer.setLayout(new BorderLayout());
        footer.add(loginFooter, BorderLayout.NORTH);
        footer.add(loginBtn, BorderLayout.SOUTH);

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
        String enteredUsername = inputPanel.getNameField().getText();
        String enteredPassword = new String(inputPanel.getPasswordField().getPassword());

        try {
            DBConnection dbc = new DBConnection();
            Connection connection = dbc.DBConnection();

            String query = "SELECT lecturePassword FROM lecture WHERE lectureEmail = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, enteredUsername);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("lecturePassword");
                if (enteredPassword.equals(storedPassword)) {
                    new AdminDashboardScreen("Admin | Dashboard", enteredUsername).setVisible(true);
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
}
