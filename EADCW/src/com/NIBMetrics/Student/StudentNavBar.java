package com.NIBMetrics.Student;

import com.NIBMetrics.Admin.AdminDashboard.AdminDashboardScreen;
import com.NIBMetrics.Admin.AdminLogout.Logout;
import com.NIBMetrics.Admin.AdminProfile.AdminProfileScreen;
import com.NIBMetrics.Admin.MarkUpdate.MarkUpdateScreen;
import com.NIBMetrics.Admin.RemoveStudent.StudentRemoveScreen;
import com.NIBMetrics.DBConnection.DBConnection;
import com.NIBMetrics.Student.StudentDashboard.StudentDashboardScreen;
import com.NIBMetrics.Student.StudentProfile.StudentProfileScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentNavBar extends JPanel {
    private JMenu home, profile, results, logout;
    private static JMenuItem homeV,profileVU,resultV,logOut;
    private JLabel logoDisplay, studentName, welcomeMsg;
    private String uName;

    public StudentNavBar(String uName) {
        this.uName=uName;
        initializeUI();
    }

    private void initializeUI() {
        //insert image
        ImageIcon logoImg = new ImageIcon(getClass().getResource("NIBMetrics.png"));
        Image logo = logoImg.getImage();
        Image scaledImg = logo.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        logoDisplay = new JLabel(scaledIcon);

        //create panel to center the menu bar
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        menuPanel.setBackground(new Color(20, 33, 61)); // change background color

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(20, 33, 61)); // change background color
        UIManager.put("Menu.foreground", Color.WHITE); // change font color

        //set menu items
        home = new JMenu("Home");
        profile = new JMenu("Profile");
        results = new JMenu("Results");
        logout = new JMenu("Logout");

        // set sub menuitems
        homeV = new JMenuItem("Home");
        profileVU = new JMenuItem("Profile");
        resultV = new JMenuItem("Results");
        logOut = new JMenuItem("Logout");

        //add menu item to menu
        home.add(homeV);
        profile.add(profileVU);
        results.add(resultV);
        logout.add(logOut);

        //add menu item to menu
        menuBar.add(home);
        menuBar.add(profile);
        menuBar.add(results);
        menuBar.add(logout);

        String studentName1 = getStudentName(uName);

        //label to get student name
        studentName = new JLabel(uName);
        studentName.setForeground(Color.white);
        studentName.setBackground(new Color(20, 33, 61)); // change background color
        studentName.setOpaque(true);

        //label to display welcome message
        welcomeMsg = new JLabel("Hi "+studentName1+", Welcome to NIBMetrics.");
        welcomeMsg.setForeground(Color.white);
        welcomeMsg.setBackground(new Color(20, 33, 61)); // change background color
        welcomeMsg.setOpaque(true);

        //change font size of welcomeMsg label
        Font currentFont = welcomeMsg.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() + 10f); // increase font size by 2 points
        welcomeMsg.setFont(newFont);

        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        welcomePanel.setBackground(new Color(20, 33, 61)); // change background color
        welcomePanel.add(welcomeMsg);

        setLayout(new BorderLayout());
        add(logoDisplay, BorderLayout.WEST);

        menuPanel.add(menuBar);
        add(menuPanel, BorderLayout.CENTER);

        add(studentName, BorderLayout.EAST);
        add(welcomePanel, BorderLayout.SOUTH);

        setupListeners();
    }

    private void setupListeners() {

        homeV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentDashboardScreen("Admin | Dashboard", uName).setVisible(true);
            }
        });

        profileVU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentProfileScreen("Admin | Profile", uName).setVisible(true);
            }
        });

        resultV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentDashboardScreen("Admin | Profile", uName).setVisible(true);
            }
        });

        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Logout().setVisible(true);
            }
        });
    }

    private String getStudentName(String uName) {
        String studentName = "";
        try {
            DBConnection dbc = new DBConnection();
            Connection connection = dbc.DBConnection();

            if (connection != null) {
                Statement statement = connection.createStatement();

                String query = "SELECT studentName FROM student WHERE studentId = '" + uName + "'";
                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()) {
                    studentName = resultSet.getString("studentName");
                }

                resultSet.close();
                statement.close();
                connection.close();
            } else {
                System.out.println("Failed database connection.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentName;
    }
}
