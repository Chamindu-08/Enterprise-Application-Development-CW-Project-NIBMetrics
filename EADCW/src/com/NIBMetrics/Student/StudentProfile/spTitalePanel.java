package com.NIBMetrics.Student.StudentProfile;

import javax.swing.*;
import java.awt.*;

public class spTitalePanel extends JPanel {
    private JLabel title;
    public spTitalePanel() {
        initializeUI();
    }

    private void initializeUI() {
        title = new JLabel("Profile");
        title.setForeground(Color.white);
        add(title);
    }
}
