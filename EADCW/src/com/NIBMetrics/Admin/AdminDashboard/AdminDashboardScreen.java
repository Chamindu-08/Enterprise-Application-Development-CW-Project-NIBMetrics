package com.NIBMetrics.Admin.AdminDashboard;

import com.NIBMetrics.Admin.AdminNavBar;
import com.NIBMetrics.Student.StudentDashboard.StudentDashboardScreen;
import com.NIBMetrics.Student.StudentNavBar;

import javax.swing.*;
import java.awt.*;

public class AdminDashboardScreen extends JFrame {
    private JPanel navBar;
    private JPanel filterPanel;
    private JPanel marksTable;
    private JPanel submit;
    public AdminDashboardScreen() throws HeadlessException {
        this("Admin | Dashboard");
    }

    public AdminDashboardScreen(String title) throws HeadlessException{
        super(title);
        navBar = new AdminNavBar();
        filterPanel = new filterPanel();
        marksTable = new marksTablePanel();
        submit = new ButtonPanel();
        initializeUI();
    }

    private void initializeUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(new Color(20, 33, 61));

        //empty panel for space
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
        filterPanel.setBackground(new Color(20, 33, 61));
        marksTable.setBackground(new Color(20, 33, 61));
        submit.setBackground(new Color(20, 33, 61));

        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());
        body.add(filterPanel, BorderLayout.NORTH);
        body.add(marksTable, BorderLayout.CENTER);
        body.add(submit, BorderLayout.SOUTH);

        container.add(navBar, BorderLayout.NORTH);
        container.add(body, BorderLayout.CENTER);
        container.add(emptyPanel, BorderLayout.SOUTH);
        container.add(emptyPanelEast, BorderLayout.EAST);
        container.add(emptyPanelWest, BorderLayout.WEST);

        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AdminDashboardScreen();
        });
    }
}
