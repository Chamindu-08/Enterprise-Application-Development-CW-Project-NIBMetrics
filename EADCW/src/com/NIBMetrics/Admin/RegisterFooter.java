package com.NIBMetrics.Admin;

import javax.swing.*;
import java.awt.*;

public class RegisterFooter extends JPanel {
    private JButton registerBtn;
    public RegisterFooter() {
        initializeUI();
    }

    private void initializeUI() {
        registerBtn = new JButton("Register");

        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

        //button font size, background color, font color
        registerBtn.setFont(font);
        registerBtn.setBackground(new Color(20, 33, 61));
        registerBtn.setForeground(Color.WHITE);

        setLayout(new BorderLayout());
        add(registerBtn, BorderLayout.CENTER);
    }
}
