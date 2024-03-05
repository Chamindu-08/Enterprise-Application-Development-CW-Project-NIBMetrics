package com.NIBMetrics.WelcomePage;

import javax.swing.*;
import java.awt.*;

public class welcomeBodyPanel extends JPanel {
    private JLabel title1, title2, title3, title4, title5;

    public welcomeBodyPanel() {
        setLayout(new BorderLayout());
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new GridLayout(5, 1));
        setBackground(new Color(20, 33, 61));

        JLabel title1 = new JLabel("Les't check your");
        JLabel title2 = new JLabel("results with just");
        JLabel title3 = new JLabel("a tap.");
        JLabel title4 = new JLabel("Stay Connected to Your Academic Progress");
        JLabel title5 = new JLabel("and Enrich Your Educational Experience.");


        Font titleFont = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
        Font titleFont2 = new Font(Font.SANS_SERIF, Font.PLAIN, 14);

        title1.setFont(titleFont);
        title2.setFont(titleFont);
        title3.setFont(titleFont);
        title4.setFont(titleFont2);
        title5.setFont(titleFont2);

        Color fontColor = Color.WHITE;
        title1.setForeground(fontColor);
        title2.setForeground(fontColor);
        title3.setForeground(fontColor);
        title4.setForeground(fontColor);
        title5.setForeground(fontColor);

        add(title1);
        add(title2);
        add(title3);
        add(title4);
        add(title5);
    }
}
