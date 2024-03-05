package com.NIBMetrics.Student.StudentRegister;

import com.NIBMetrics.Admin.AdminLogin.SideImagePanel;
import com.NIBMetrics.Admin.AdminRegister.AdminRegisterScreen;
import com.NIBMetrics.Admin.AdminRegister.RegInputPanel;
import com.NIBMetrics.Admin.LRNavBar;
import com.NIBMetrics.Admin.RegiserHeader;
import com.NIBMetrics.Admin.RegisterFooter;
import com.NIBMetrics.Student.StudentLogin.sSideImagePanel;

import javax.swing.*;
import java.awt.*;

public class StudentRegisterScreen extends JFrame {
    private JPanel inputPanel;
    private JPanel navBar;
    private JPanel registerHeader;
    private JPanel registerFooter;
    private JPanel sideImg;

    public StudentRegisterScreen() throws HeadlessException {
        this("Student | Sing in");
    }

    public StudentRegisterScreen(String title) throws HeadlessException{
        super(title);
        navBar = new LRNavBar();
        registerHeader = new RegiserHeader();
        inputPanel = new sRegInputPanel();
        registerFooter = new RegisterFooter();
        sideImg = new sSideImagePanel();
        initializeUI();
    }

    private void initializeUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(new Color(20, 33, 61));
        container.setBackground(Color.WHITE);
        registerHeader.setBackground(Color.WHITE);

        registerFooter.setBackground(Color.WHITE);

        //empty panel for space
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(getWidth(),50));

        JPanel emptyPanelWest = new JPanel();
        emptyPanelWest.setPreferredSize(new Dimension(50, getHeight()));

        JPanel inputSetup = new JPanel();
        inputSetup.setLayout(new BorderLayout());
        inputSetup.add(registerHeader, BorderLayout.NORTH);
        inputSetup.add(inputPanel, BorderLayout.CENTER);
        inputSetup.add(registerFooter, BorderLayout.SOUTH);

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
            new StudentRegisterScreen();
        });
    }
}
