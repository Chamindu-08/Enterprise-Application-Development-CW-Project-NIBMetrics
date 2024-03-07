package com.NIBMetrics.Admin;

import javax.swing.*;
import java.awt.*;

public class LoginFooter extends JPanel{

    private JCheckBox reme;
    private JLabel fPass;
    public LoginFooter() {
        initializeUI();
    }

    private void initializeUI() {
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

        reme = new JCheckBox("Remember me");
        fPass = new JLabel("Forget password?");

        reme.setFont(font);
        fPass.setFont(font);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(reme);
        buttonPanel.add(fPass);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
    }
}
