package com.NIBMetrics.Student.StudentLogin;

import com.NIBMetrics.Admin.AdminLogin.AdminLoginScreen;
import com.NIBMetrics.Admin.AdminLogin.InputPannel;
import com.NIBMetrics.Admin.AdminLogin.SideImagePanel;
import com.NIBMetrics.Admin.LRNavBar;
import com.NIBMetrics.Admin.LoginFooter;
import com.NIBMetrics.Admin.LoginHeader;
import com.NIBMetrics.Student.StudentNavBar;

import javax.swing.*;
import java.awt.*;

public class StudentLoginScreen extends JFrame {
    private JPanel inputPanel;
    private JPanel navBar;
    private JPanel loginHeader;
    private JPanel loginFooter;
    private JPanel sideImg;

    public StudentLoginScreen() throws HeadlessException {
        this("Student | Sign in");
    }

    public StudentLoginScreen(String title) throws HeadlessException{
        super(title);
        navBar = new LRNavBar();
        loginHeader = new LoginHeader();
        inputPanel = new sInputPanel();
        loginFooter = new LoginFooter();
        sideImg = new sSideImagePanel();
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
            new StudentLoginScreen();
        });
    }
}
