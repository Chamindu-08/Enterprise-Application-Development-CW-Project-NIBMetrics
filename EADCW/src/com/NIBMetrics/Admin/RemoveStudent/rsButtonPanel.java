package com.NIBMetrics.Admin.RemoveStudent;

import javax.swing.*;
import java.awt.*;

public class rsButtonPanel extends JPanel {
    private JButton removeBtn;
    public rsButtonPanel() {
        initializeUI();
    }

    private void initializeUI() {
        removeBtn = new JButton("Remove");
        removeBtn.setBackground(Color.BLUE);
        removeBtn.setForeground(Color.white);
        add(removeBtn);
    }
}
