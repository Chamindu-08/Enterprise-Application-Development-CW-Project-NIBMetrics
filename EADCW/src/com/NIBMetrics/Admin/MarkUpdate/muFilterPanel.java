package com.NIBMetrics.Admin.MarkUpdate;

import javax.swing.*;
import java.awt.*;

public class muFilterPanel extends JPanel{
    private JComboBox programCMB, batchCMB, subjectCMB, studentIDCMB;
    private JLabel program, batch, subject, sID, cw, em, fg;
    private JTextField cwFild, emFild, fgFild;
    public muFilterPanel() {
        setLayout(new GridLayout(8,2,5,5));
        initializeUI();
    }

    private void initializeUI() {
        program = new JLabel("Programe");
        programCMB = new JComboBox<>();
        batch = new JLabel("Batch");
        batchCMB = new JComboBox<>();
        subject = new JLabel("Subject");
        subjectCMB = new JComboBox<>();
        sID = new JLabel("Studnet ID");
        studentIDCMB = new JComboBox<>();
        cw = new JLabel("Course work");
        cwFild = new JTextField();
        em = new JLabel("Exam");
        emFild = new JTextField();
        fg = new JLabel("Final Grade");
        fgFild = new JTextField();

        program.setForeground(Color.white);
        batch.setForeground(Color.white);
        subject.setForeground(Color.white);
        sID.setForeground(Color.white);
        cw.setForeground(Color.white);
        em.setForeground(Color.white);
        fg.setForeground(Color.white);

        add(program);
        add(programCMB);
        add(batch);
        add(batchCMB);
        add(subject);
        add(subjectCMB);
        add(sID);
        add(studentIDCMB);
        add(cw);
        add(cwFild);
        add(em);
        add(emFild);
        add(fg);
        add(fgFild);

        //empty space
        add(Box.createVerticalStrut(2));
    }
}
