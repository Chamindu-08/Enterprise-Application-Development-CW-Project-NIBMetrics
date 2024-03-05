package com.NIBMetrics.Admin.AdminLogin;

import javax.swing.*;
import java.awt.*;

public class SideImagePanel extends JPanel {
    private JLabel logoDisplay;
    public SideImagePanel() {
        initializeUI();
    }
    private void initializeUI() {
        //insert image
        ImageIcon logoImg = new ImageIcon(getClass().getResource("SideAdminImg.jpg"));
        Image logo = logoImg.getImage();
        Image scaledImg = logo.getScaledInstance(350,400,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        logoDisplay = new JLabel(scaledIcon);

        setLayout(new BorderLayout());
        add(logoDisplay, BorderLayout.CENTER);
    }
}
