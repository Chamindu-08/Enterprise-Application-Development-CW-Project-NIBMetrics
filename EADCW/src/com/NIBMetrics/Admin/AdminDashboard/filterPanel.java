package com.NIBMetrics.Admin.AdminDashboard;

import javax.swing.*;
import java.awt.*;

public class filterPanel extends JPanel {
    private JComboBox programCMB, batchCMB, subjectCMB;
    private JLabel program, batch, subject;
    public filterPanel() {
        setLayout(new GridLayout(4,2,5,5));
        initializeUI();
    }

    private void initializeUI() {
        program = new JLabel("Programe");
        programCMB = new JComboBox<>();
        batch = new JLabel("Batch");
        batchCMB = new JComboBox<>();
        subject = new JLabel("Subject");
        subjectCMB = new JComboBox<>();

        program.setForeground(Color.white);
        batch.setForeground(Color.white);
        subject.setForeground(Color.white);
        add(program);
        add(programCMB);
        add(batch);
        add(batchCMB);
        add(subject);
        add(subjectCMB);

        //empty space
        add(Box.createVerticalStrut(2));
    }
}
