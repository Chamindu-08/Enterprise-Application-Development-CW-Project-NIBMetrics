package com.NIBMetrics.Student.StudentLogin;

import javax.swing.*;
import java.awt.*;

public class sSideImagePanel extends JPanel {
    private JLabel logoDisplay;
    public sSideImagePanel() {
        initializeUI();
    }
    private void initializeUI() {
        //insert image
        ImageIcon logoImg = new ImageIcon(getClass().getResource("SideStudentImg.jpg"));
        Image logo = logoImg.getImage();
        Image scaledImg = logo.getScaledInstance(350,400,Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
        logoDisplay = new JLabel(scaledIcon);

        setLayout(new BorderLayout());
        add(logoDisplay, BorderLayout.CENTER);
    }
}
