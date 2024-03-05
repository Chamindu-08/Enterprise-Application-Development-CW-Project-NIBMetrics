package com.NIBMetrics.WelcomePage;

import javax.swing.*;
import java.awt.*;

public class welcomeNavBar extends JPanel {
    private JLabel logoDisplay;
    public welcomeNavBar() {
        initializeUI();
    }

    private void initializeUI() {
        //insert image
        ImageIcon logoImg = new ImageIcon(getClass().getResource("NIBMetrics.png"));
        Image logo = logoImg.getImage();
        Image scaledImg = logo.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        logoDisplay = new JLabel(scaledIcon);

        setLayout(new BorderLayout());
        add(logoDisplay, BorderLayout.WEST);
    }
}
