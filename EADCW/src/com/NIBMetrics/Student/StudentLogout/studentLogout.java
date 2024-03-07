package com.NIBMetrics.Student.StudentLogout;

import com.NIBMetrics.WelcomePage.WelcomeScreen;

import javax.swing.*;
import java.awt.*;

public class studentLogout extends JFrame {
    public studentLogout() throws HeadlessException {
        new WelcomeScreen().setVisible(true);
        dispose();
    }
}
