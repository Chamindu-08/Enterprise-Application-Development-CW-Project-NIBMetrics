package com.NIBMetrics.Admin.AdminProfile;

import javax.swing.*;
import java.awt.*;

public class apButtonPanel extends JPanel {
    private JButton saveBtn;
    public apButtonPanel() {
        initializeUI();
    }

    private void initializeUI() {
        saveBtn = new JButton("Save");
        saveBtn.setBackground(Color.BLUE);
        saveBtn.setForeground(Color.white);

        add(saveBtn);
    }
}
