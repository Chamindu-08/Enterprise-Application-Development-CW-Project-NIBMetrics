package com.NIBMetrics.Student.StudentDashboard;

import com.NIBMetrics.Student.StudentNavBar;

import javax.swing.*;
import java.awt.*;

public class StudentDashboardScreen extends JFrame {
    private JPanel navBar;
    private JPanel inputPanel;
    private JPanel tablePanel;
    private JPanel btnPanel;

    public StudentDashboardScreen() throws HeadlessException {
        this("Student | Dashboard");
    }

    public StudentDashboardScreen(String title) throws HeadlessException {
        super(title);
        navBar = new StudentNavBar();
        initializeUI();
    }

    private void initializeUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        JPanel titleBarAndInputPanel = new JPanel();
        titleBarAndInputPanel.setLayout(new BorderLayout());
        titleBarAndInputPanel.add(navBar, BorderLayout.NORTH);

        // Add other panels (inputPanel, tablePanel, btnPanel) as needed

        container.add(titleBarAndInputPanel, BorderLayout.CENTER); // Add titleBarAndInputPanel to the center

        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentDashboardScreen();
        });
    }
}
