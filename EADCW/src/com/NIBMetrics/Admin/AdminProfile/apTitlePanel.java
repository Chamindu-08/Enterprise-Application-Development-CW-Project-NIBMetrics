package com.NIBMetrics.Admin.AdminProfile;

import javax.swing.*;
import java.awt.*;

public class apTitlePanel extends JPanel {
    private JLabel title;
    public apTitlePanel() {
        initializeUI();
    }

    private void initializeUI() {
        title = new JLabel("Profile");
        title.setForeground(Color.white);
        add(title);
    }
}
