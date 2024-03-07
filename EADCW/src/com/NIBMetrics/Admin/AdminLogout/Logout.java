package com.NIBMetrics.Admin.AdminLogout;

import com.NIBMetrics.WelcomePage.WelcomeScreen;

import javax.swing.*;
import java.awt.*;

public class Logout extends JFrame {
    public Logout() throws HeadlessException {
        new WelcomeScreen().setVisible(true);
        dispose();
    }
}
