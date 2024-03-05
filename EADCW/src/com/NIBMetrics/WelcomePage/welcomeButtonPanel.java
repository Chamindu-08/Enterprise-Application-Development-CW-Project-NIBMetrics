package com.NIBMetrics.WelcomePage;

import javax.swing.*;
import java.awt.*;

public class welcomeButtonPanel extends JPanel {
    private JButton studentBtn, lectureBtn;
    public welcomeButtonPanel() {
        initializeUI();
    }

    private void initializeUI() {
        studentBtn = new JButton("Student");
        studentBtn.setBackground(Color.BLUE);
        studentBtn.setForeground(Color.white);

        lectureBtn = new JButton("Lecture");
        lectureBtn.setBackground(Color.BLUE);
        lectureBtn.setForeground(Color.white);

        add(studentBtn);
        add(lectureBtn);
    }
}
