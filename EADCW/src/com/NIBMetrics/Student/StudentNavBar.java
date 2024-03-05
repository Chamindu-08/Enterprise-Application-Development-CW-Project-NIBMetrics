package com.NIBMetrics.Student;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class StudentNavBar extends JPanel {
    private JMenu home, profile, results, logout;
    private JLabel logoDisplay, studentName, welcomeMsg;

    public StudentNavBar() {
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

        //add menu item to menu
        menuBar.add(home);
        menuBar.add(profile);
        menuBar.add(results);
        menuBar.add(logout);

        //label to get student name
        studentName = new JLabel("Student Name");
        studentName.setForeground(Color.white);
        studentName.setBackground(new Color(20, 33, 61)); // change background color
        studentName.setOpaque(true);

        //label to display welcome message
        welcomeMsg = new JLabel("Hi (student name) Welcome to NIBMetrics.");
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
    }
}
