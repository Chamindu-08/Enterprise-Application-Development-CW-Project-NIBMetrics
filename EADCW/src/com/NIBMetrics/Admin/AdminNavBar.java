package com.NIBMetrics.Admin;

import javax.swing.*;
import java.awt.*;

public class AdminNavBar extends JPanel{

    private JMenu home, profile, results, student, logout;
    private static JMenuItem ra, ru, rd, sv, sr;
    private JLabel logoDisplay, studentName, welcomeMsg;
    public AdminNavBar() {
        initializeUI();
    }

    private void initializeUI() {
        // insert image
        ImageIcon logoImg = new ImageIcon(getClass().getResource("NIBMetrics.png"));
        Image logo = logoImg.getImage();
        Image scaledImg = logo.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        logoDisplay = new JLabel(scaledIcon);

        // create panel to center the menu bar
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        menuPanel.setBackground(new Color(20, 33, 61)); // change background color

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(20, 33, 61)); // change background color
        UIManager.put("Menu.foreground", Color.WHITE); // change font color

        // set menu items
        home = new JMenu("Home");
        profile = new JMenu("Profile");
        results = new JMenu("Results");
        student = new JMenu("Student");
        logout = new JMenu("Logout");

        // set sub menuitems
        ra = new JMenuItem("Enter Results");
        ru = new JMenuItem("Update Results");
        rd = new JMenuItem("Remove Results");
        sv = new JMenuItem("View Profile");
        sr = new JMenuItem("Remove Student");

        //add menu item to menu
        results.add(ra);
        results.add(ru);
        results.add(rd);
        student.add(sv);
        student.add(sr);

        // add menu item to menu
        menuBar.add(home);
        menuBar.add(profile);
        menuBar.add(results);
        menuBar.add(student);
        menuBar.add(logout);

        // label to get student name
        studentName = new JLabel("Lecture Name");
        studentName.setForeground(Color.white);
        studentName.setBackground(new Color(20, 33, 61)); // change background color
        studentName.setOpaque(true);

        //label to display welcome message
        welcomeMsg = new JLabel("Hi (lecture name) Welcome to NIBMetrics.");
        welcomeMsg.setForeground(Color.white);
        welcomeMsg.setBackground(new Color(20, 33, 61)); // change background color
        welcomeMsg.setOpaque(true);

        // Change font size of welcomeMsg label
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
