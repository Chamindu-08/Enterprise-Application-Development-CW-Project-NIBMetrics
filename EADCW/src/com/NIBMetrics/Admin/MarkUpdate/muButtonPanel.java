package com.NIBMetrics.Admin.MarkUpdate;

import javax.swing.*;
import java.awt.*;

public class muButtonPanel extends JPanel {
    private JButton saveBtn;
    public muButtonPanel() {
        initializeUI();
    }

    private void initializeUI() {
        saveBtn = new JButton("Submit");
        saveBtn.setBackground(Color.BLUE);
        saveBtn.setForeground(Color.white);
        add(saveBtn);
    }
}
