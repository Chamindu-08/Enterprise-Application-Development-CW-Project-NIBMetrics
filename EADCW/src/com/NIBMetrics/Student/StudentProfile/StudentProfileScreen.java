package com.NIBMetrics.Student.StudentProfile;

import com.NIBMetrics.Admin.AdminNavBar;
import com.NIBMetrics.Admin.AdminProfile.AdminProfileScreen;
import com.NIBMetrics.Admin.AdminProfile.apButtonPanel;
import com.NIBMetrics.Admin.AdminProfile.apInputpanel;
import com.NIBMetrics.Admin.AdminProfile.apTitlePanel;
import com.NIBMetrics.Student.StudentDashboard.StudentDashboardScreen;
import com.NIBMetrics.Student.StudentNavBar;

import javax.swing.*;
import java.awt.*;

public class StudentProfileScreen extends JFrame {
    private JPanel navBar;
    private JPanel filterPanel;
    private JPanel title2;
    private JPanel submit;
    public StudentProfileScreen() throws HeadlessException {
        this("Admin | Dashboard");
    }

    public StudentProfileScreen(String title) throws HeadlessException{
        super(title);
        navBar = new StudentNavBar();
        title2 = new spTitalePanel();
        filterPanel = new spInputFild();
        submit = new spButtonPanel();
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
        title2.setBackground(new Color(20, 33, 61));
        submit.setBackground(new Color(20, 33, 61));

        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());
        body.add(title2, BorderLayout.NORTH);
        body.add(filterPanel, BorderLayout.CENTER);
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
            new StudentProfileScreen();
        });
    }
}
