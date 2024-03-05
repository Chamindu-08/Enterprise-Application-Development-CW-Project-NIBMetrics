package com.NIBMetrics.Admin.MarkUpdate;

import javax.swing.*;
import java.awt.*;

public class muTitlePanel extends JPanel {
    private JLabel title;
    public muTitlePanel() {
        initializeUI();
    }

    private void initializeUI() {
        title = new JLabel("Remove Student");
        title.setForeground(Color.white);
        add(title);
    }
}
