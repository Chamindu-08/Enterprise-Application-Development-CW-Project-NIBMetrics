package com.NIBMetrics.Admin;

import javax.swing.*;
import java.awt.*;

public class LoginFooter extends JPanel{
    private JButton loginBtn;
    private JCheckBox reme;
    private JLabel fPass;
    public LoginFooter() {
        initializeUI();
    }

    private void initializeUI() {
        loginBtn = new JButton("Login");

        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

        //set button font, background color, font color
        loginBtn.setFont(font);
        loginBtn.setBackground(new Color(20, 33, 61));
        loginBtn.setForeground(Color.WHITE);

        reme = new JCheckBox("Remember me");
        fPass = new JLabel("Forget password?");

        reme.setFont(font);
        fPass.setFont(font);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(reme);
        buttonPanel.add(fPass);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(loginBtn, BorderLayout.CENTER);
    }
}
