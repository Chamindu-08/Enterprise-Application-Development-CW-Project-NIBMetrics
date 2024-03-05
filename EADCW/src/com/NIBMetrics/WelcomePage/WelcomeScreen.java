package com.NIBMetrics.WelcomePage;

import com.NIBMetrics.Admin.LRNavBar;
import com.NIBMetrics.Admin.LoginFooter;
import com.NIBMetrics.Admin.LoginHeader;
import com.NIBMetrics.Student.StudentLogin.StudentLoginScreen;
import com.NIBMetrics.Student.StudentLogin.sInputPanel;
import com.NIBMetrics.Student.StudentLogin.sSideImagePanel;

import javax.swing.*;
import java.awt.*;

public class WelcomeScreen extends JFrame {
    private JPanel navBar;
    private JPanel welBody;
    private JPanel sideImg;
    private JPanel welButton;

    public WelcomeScreen() throws HeadlessException {
        this("Student | Sign in");
    }

    public WelcomeScreen(String title) throws HeadlessException{
        super(title);
        navBar = new welcomeNavBar();
        welBody = new welcomeBodyPanel();
        sideImg = new welcomeSideImgPanel();
        welButton = new welcomeButtonPanel();
        initializeUI();
    }

    private void initializeUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(new Color(20, 33, 61));
        navBar.setBackground(new Color(20, 33, 61));
        welButton.setBackground(new Color(20, 33, 61));

        //empty panel for space
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(getWidth(),50));
        emptyPanel.setBackground(new Color(20, 33, 61));

        JPanel emptyPanelWest = new JPanel();
        emptyPanelWest.setPreferredSize(new Dimension(50, getHeight()));
        emptyPanelWest.setBackground(new Color(20, 33, 61));

        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());
        body.add(welBody, BorderLayout.CENTER);
        body.add(welButton, BorderLayout.SOUTH);

        JPanel sideImage = new JPanel();
        sideImage.setLayout(new BorderLayout());
        sideImage.add(sideImg, BorderLayout.CENTER);

        container.add(navBar, BorderLayout.NORTH);
        container.add(body, BorderLayout.CENTER);
        container.add(sideImage, BorderLayout.EAST);
        container.add(emptyPanel, BorderLayout.SOUTH);
        container.add(emptyPanelWest, BorderLayout.WEST);

        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WelcomeScreen();
        });
    }
}
