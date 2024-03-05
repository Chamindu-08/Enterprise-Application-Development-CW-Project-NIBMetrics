package com.NIBMetrics.Admin.AdminLogin;

import com.NIBMetrics.Admin.AdminDashboard.AdminDashboardScreen;
import com.NIBMetrics.Admin.AdminNavBar;
import com.NIBMetrics.Admin.LRNavBar;
import com.NIBMetrics.Admin.LoginFooter;
import com.NIBMetrics.Admin.LoginHeader;

import javax.swing.*;
import java.awt.*;

public class AdminLoginScreen extends JFrame{
    private JPanel inputPanel;
    private JPanel navBar;
    private JPanel loginHeader;
    private JPanel loginFooter;
    private JPanel sideImg;

    public AdminLoginScreen() throws HeadlessException {
        this("Admin | Sign in");
    }

    public AdminLoginScreen(String title) throws HeadlessException{
        super(title);
        navBar = new LRNavBar();
        loginHeader = new LoginHeader();
        inputPanel = new InputPannel();
        loginFooter = new LoginFooter();
        sideImg = new SideImagePanel();
        initializeUI();
    }

    private void initializeUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(new Color(20, 33, 61));
        container.setBackground(Color.WHITE);
        loginHeader.setBackground(Color.WHITE);

        loginFooter.setBackground(Color.WHITE);

        //empty panel for space
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(getWidth(),50));

        JPanel emptyPanelWest = new JPanel();
        emptyPanelWest.setPreferredSize(new Dimension(50, getHeight()));

        JPanel inputSetup = new JPanel();
        inputSetup.setLayout(new BorderLayout());
        inputSetup.add(loginHeader, BorderLayout.NORTH);
        inputSetup.add(inputPanel, BorderLayout.CENTER);
        inputSetup.add(loginFooter, BorderLayout.SOUTH);

        JPanel sideImage = new JPanel();
        sideImage.setLayout(new BorderLayout());
        sideImage.add(sideImg, BorderLayout.CENTER);

        container.add(navBar, BorderLayout.NORTH);
        container.add(inputSetup, BorderLayout.CENTER);
        container.add(sideImage, BorderLayout.EAST);
        container.add(emptyPanel, BorderLayout.SOUTH);
        container.add(emptyPanelWest, BorderLayout.WEST);

        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AdminLoginScreen();
        });
    }

}
