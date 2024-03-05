package com.NIBMetrics.Student.StudentDashboard;

import javax.swing.*;
import java.awt.*;

public class GPAPanel extends JPanel {
    private JLabel gpa,gpaScore;
    public GPAPanel() {
        setLayout(new GridLayout(3,1,5,5));
        initializeUI();
    }

    private void initializeUI() {
        gpa = new JLabel("GPA");
        gpaScore = new JLabel("4.0");

        gpa.setFont(new Font("Arial", Font.BOLD, 24));
        gpa.setForeground(Color.WHITE);

        gpaScore.setFont(new Font("Arial", Font.PLAIN, 20));
        gpaScore.setForeground(Color.WHITE);

        add(gpa);
        add(gpaScore);

        //empty space
        add(Box.createVerticalStrut(2));
    }
}
