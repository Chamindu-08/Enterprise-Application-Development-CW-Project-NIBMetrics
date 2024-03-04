package com.NIBMetrics.Student;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class StudentNavBar extends JPanel {
    private JMenuBar menuBar;
    private JMenu home, profile, results;

    private ImageIcon logo;
    private JLabel logoDisplay;

    public StudentNavBar() {
        initializeUI();
    }

    private void initializeUI() {
        JPanel colorPanel = new JPanel();


        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(20, 33, 61));
        UIManager.put("Menu.foreground", Color.WHITE);

        home = new JMenu("Home");
        profile = new JMenu("Profile");
        results = new JMenu("Results");

        menuBar.add(home);
        menuBar.add(profile);
        menuBar.add(results);

        setLayout(new BorderLayout());
        add(menuBar, BorderLayout.NORTH);
        add(colorPanel, BorderLayout.CENTER);
    }
}
