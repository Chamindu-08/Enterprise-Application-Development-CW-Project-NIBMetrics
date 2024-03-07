package com.NIBMetrics.Admin;

import com.NIBMetrics.Admin.AdminDashboard.AdminDashboardScreen;
import com.NIBMetrics.Admin.AdminLogout.Logout;
import com.NIBMetrics.Admin.AdminProfile.AdminProfileScreen;
import com.NIBMetrics.Admin.MarkUpdate.MarkUpdateScreen;
import com.NIBMetrics.Admin.RemoveStudent.StudentRemoveScreen;
import com.NIBMetrics.DBConnection.DBConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AdminNavBar extends JPanel{

    private JMenu home, profile, results, student, logout;
    private static JMenuItem ra, ru, rd, sv, sr,homeV,profileVU,logOut;
    private JLabel logoDisplay, studentName, welcomeMsg;
    private String uName;
    private JFrame frame;
    public AdminNavBar(String uName) {
        this.uName = uName;
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
        student = new JMenu("Student");
        logout = new JMenu("Logout");

        //set sub menuitems
        ra = new JMenuItem("Enter Results");
        ru = new JMenuItem("Update Results");
        rd = new JMenuItem("Remove Results");
        sv = new JMenuItem("View Profile");
        sr = new JMenuItem("Remove Student");
        homeV = new JMenuItem("Home");
        profileVU = new JMenuItem("Profile");
        logOut = new JMenuItem("Logout");

        //add menu item to menu
        results.add(ra);
        results.add(ru);
        results.add(rd);
        student.add(sv);
        student.add(sr);
        home.add(homeV);
        profile.add(profileVU);
        logout.add(logOut);

        //add menu item to menu
        menuBar.add(home);
        menuBar.add(profile);
        menuBar.add(results);
        menuBar.add(student);
        menuBar.add(logout);

        String lectureName = getAdminName(uName);
        //label to get student name
        studentName = new JLabel(lectureName);
        studentName.setForeground(Color.white);
        studentName.setBackground(new Color(20, 33, 61));
        studentName.setOpaque(true);

        //label to display welcome message
        welcomeMsg = new JLabel("Hi "+lectureName+", Welcome to NIBMetrics.");
        welcomeMsg.setForeground(Color.white);
        welcomeMsg.setBackground(new Color(20, 33, 61));
        welcomeMsg.setOpaque(true);

        //change font size of welcomeMsg label
        Font currentFont = welcomeMsg.getFont();
        //increase font size by 2 points
        Font newFont = currentFont.deriveFont(currentFont.getSize() + 10f);
        welcomeMsg.setFont(newFont);

        JPanel welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        welcomePanel.setBackground(new Color(20, 33, 61));
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
        ra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminDashboardScreen("Admin | Dashboard", uName).setVisible(true);
            }
        });

        ru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MarkUpdateScreen("Admin | Result Update", uName).setVisible(true);
            }
        });

        sr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentRemoveScreen("Admin | Student Remove", uName).setVisible(true);
            }
        });

        homeV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminDashboardScreen("Admin | Dashboard", uName).setVisible(true);
            }
        });

        profileVU.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminProfileScreen("Admin | Profile", uName).setVisible(true);
            }
        });

        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Logout().setVisible(true);
            }
        });
    }

    private String getAdminName(String uName) {
        String lectureName = "";
        try {
            DBConnection dbc = new DBConnection();
            Connection connection = dbc.DBConnection();

            if (connection != null) {
                Statement statement = connection.createStatement();

                String query = "SELECT lectureName FROM lecture WHERE lectureEmail = '" + uName + "'";
                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()) {
                    lectureName = resultSet.getString("lectureName");
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
        return lectureName;
    }
}
