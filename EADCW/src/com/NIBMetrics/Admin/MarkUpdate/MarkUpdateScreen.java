package com.NIBMetrics.Admin.MarkUpdate;

import com.NIBMetrics.Admin.AdminNavBar;
import com.NIBMetrics.Admin.AdminProfile.AdminProfileScreen;

import javax.swing.*;
import java.awt.*;

public class MarkUpdateScreen extends JFrame {
    private JPanel navBar;
    private JPanel filterBar;
    private JPanel submit;
    private JPanel titale2;
    public MarkUpdateScreen() throws HeadlessException {
        this("Admin | Dashboard");
    }

    public MarkUpdateScreen(String title) throws HeadlessException{
        super(title);
        navBar = new AdminNavBar();
        filterBar = new muFilterPanel();
        submit = new muButtonPanel();
        titale2 = new muTitlePanel();
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

        //change background color
        emptyPanel.setBackground(new Color(20, 33, 61));
        emptyPanelWest.setBackground(new Color(20, 33, 61));
        emptyPanelEast.setBackground(new Color(20, 33, 61));
        navBar.setBackground(new Color(20, 33, 61));
        filterBar.setBackground(new Color(20, 33, 61));
        submit.setBackground(new Color(20, 33, 61));
        titale2.setBackground(new Color(20, 33, 61));

        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());
        body.add(filterBar, BorderLayout.CENTER);
        body.add(submit, BorderLayout.SOUTH);
        body.add(titale2, BorderLayout.NORTH);

        container.add(body, BorderLayout.CENTER);
        container.add(navBar, BorderLayout.NORTH);
        container.add(emptyPanelWest, BorderLayout.WEST);
        container.add(emptyPanelEast, BorderLayout.EAST);
        container.add(emptyPanel, BorderLayout.SOUTH);

        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MarkUpdateScreen();
        });
    }
}
