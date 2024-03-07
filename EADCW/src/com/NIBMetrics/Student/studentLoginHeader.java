package com.NIBMetrics.Student;

import com.NIBMetrics.Admin.AdminDashboard.AdminDashboardScreen;
import com.NIBMetrics.Student.StudentRegister.StudentRegisterScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class studentLoginHeader extends JPanel {
    private JLabel title1, title2, title3;
    private JButton singupBtn;

    public studentLoginHeader() {
        setLayout(new BorderLayout());
        singupBtn = new JButton("Sing up");

        singupBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StudentRegisterScreen().setVisible(true);
            }
        });
        initializeUI();
    }

    private void initializeUI() {
        title1 = new JLabel();
        title2 = new JLabel();
        title3 = new JLabel();


        singupBtn.setPreferredSize(new Dimension(80, 20));

        title1.setText("Welcome to NIBMetrics.");
        title2.setText("Sign in");
        title3.setText("Have not an account?");

        //change font and size
        Font font1 = new Font(Font.SANS_SERIF, Font.PLAIN, 30);
        Font font2 = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
        Font font3 = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

        title1.setFont(font1);
        title2.setFont(font2);
        title3.setFont(font3);

        //change font color
        title1.setForeground(new Color(20, 33, 61));
        title2.setForeground(new Color(20, 33, 61));
        title3.setForeground(new Color(20, 33, 61));

        JPanel row1 = new JPanel(new GridLayout(1, 1)); // 1 column
        JPanel row2 = new JPanel(new GridLayout(1, 1)); // 1 column
        JPanel row3 = new JPanel(new GridLayout(1, 2)); // 1 column

        row1.add(title1);
        row2.add(title2);
        row3.add(title3);

        //button transparent
        singupBtn.setContentAreaFilled(false);

        JPanel signupPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        signupPanel.add(singupBtn);
        row3.add(signupPanel);

        JPanel colorPanel = new JPanel(new GridLayout(3, 1));
        colorPanel.add(row1);
        colorPanel.add(row2);
        colorPanel.add(row3);

        add(colorPanel, BorderLayout.CENTER);
    }
}
