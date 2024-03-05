package com.NIBMetrics.Admin.AdminDashboard;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private JButton saveBtn,searchBtn;
    public ButtonPanel() {
        initializeUI();
    }

    private void initializeUI() {
        saveBtn = new JButton("Submit");
        saveBtn.setBackground(Color.BLUE);
        saveBtn.setForeground(Color.white);

        searchBtn = new JButton("Search");
        searchBtn.setBackground(Color.BLUE);
        searchBtn.setForeground(Color.white);

        add(searchBtn);
        add(saveBtn);
    }
}
