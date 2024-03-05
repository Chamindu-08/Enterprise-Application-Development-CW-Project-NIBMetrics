package com.NIBMetrics.Student.StudentDashboard;

import com.NIBMetrics.Student.StudentNavBar;
import javax.swing.*;
import java.awt.*;

public class StudentDashboardScreen extends JFrame {
    private JPanel navBar;
    private JPanel gpa;
    private JPanel resultsTable;

    public StudentDashboardScreen() throws HeadlessException {
        this("Student | Dashboard");
    }

    public StudentDashboardScreen(String title) throws HeadlessException {
        super(title);
        navBar = new StudentNavBar();
        gpa = new GPAPanel();
        resultsTable = new ResultsTablePannel();
        initializeUI();
    }

    private void initializeUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(new Color(20, 33, 61));

        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(getWidth(), 50));

        JPanel emptyPanelWest = new JPanel();
        emptyPanelWest.setPreferredSize(new Dimension(50, getHeight()));

        JPanel emptyPanelEast = new JPanel();
        emptyPanelEast.setPreferredSize(new Dimension(50, getHeight()));

        // Change background color
        emptyPanel.setBackground(new Color(20, 33, 61));
        emptyPanelWest.setBackground(new Color(20, 33, 61));
        emptyPanelEast.setBackground(new Color(20, 33, 61));
        navBar.setBackground(new Color(20, 33, 61));
        gpa.setBackground(new Color(20, 33, 61));
        resultsTable.setBackground(new Color(20, 33, 61));


        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());
        body.add(gpa, BorderLayout.NORTH);
        body.add(resultsTable, BorderLayout.CENTER);
        body.add(emptyPanel, BorderLayout.SOUTH);

        container.add(body, BorderLayout.CENTER);
        container.add(navBar, BorderLayout.NORTH);
        container.add(emptyPanel, BorderLayout.SOUTH);
        container.add(emptyPanelEast, BorderLayout.EAST);
        container.add(emptyPanelWest, BorderLayout.WEST);

        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentDashboardScreen();
        });
    }
}
