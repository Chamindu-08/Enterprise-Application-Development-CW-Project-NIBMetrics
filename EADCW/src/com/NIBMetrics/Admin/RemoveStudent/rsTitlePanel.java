package com.NIBMetrics.Admin.RemoveStudent;

import javax.swing.*;
import java.awt.*;

public class rsTitlePanel extends JPanel {
    private JLabel title;
    public rsTitlePanel() {
        initializeUI();
    }

    private void initializeUI() {
        title = new JLabel("Remove Student");
        title.setForeground(Color.white);
        add(title);
    }
}
