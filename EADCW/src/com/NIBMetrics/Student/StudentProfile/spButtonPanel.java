package com.NIBMetrics.Student.StudentProfile;

import javax.swing.*;
import java.awt.*;

public class spButtonPanel extends JPanel {
    private JButton saveBtn;
    public spButtonPanel() {
        initializeUI();
    }

    private void initializeUI() {
        saveBtn = new JButton("Save");
        saveBtn.setBackground(Color.BLUE);
        saveBtn.setForeground(Color.white);

        add(saveBtn);
    }
}
