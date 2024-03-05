package com.NIBMetrics.Admin.RemoveStudent;

import javax.swing.*;
import java.awt.*;

public class rsFilterPanel extends JPanel {
    private JComboBox programCMB, batchCMB, studentIDCMB;
    private JLabel program, batch, sID;

    public rsFilterPanel() {
        setLayout(new GridLayout(4,2,5,5));
        initializeUI();
    }

    private void initializeUI() {
        program = new JLabel("Programe");
        programCMB = new JComboBox<>();
        batch = new JLabel("Batch");
        batchCMB = new JComboBox<>();
        sID = new JLabel("Studnet ID");
        studentIDCMB = new JComboBox<>();

        program.setForeground(Color.white);
        batch.setForeground(Color.white);
        sID.setForeground(Color.white);

        add(program);
        add(programCMB);
        add(batch);
        add(batchCMB);
        add(sID);
        add(studentIDCMB);

        //empty space
        add(Box.createVerticalStrut(2));

    }
}
