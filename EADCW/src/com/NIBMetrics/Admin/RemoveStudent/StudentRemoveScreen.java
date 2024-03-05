package com.NIBMetrics.Admin.RemoveStudent;

import com.NIBMetrics.Admin.AdminNavBar;
import com.NIBMetrics.Admin.AdminProfile.AdminProfileScreen;
import com.NIBMetrics.Admin.MarkUpdate.muButtonPanel;
import com.NIBMetrics.Admin.MarkUpdate.muFilterPanel;

import javax.swing.*;
import java.awt.*;

public class StudentRemoveScreen extends JFrame{
    private JPanel navBar;
    private JPanel filterBar;
    private JPanel remove;
    private JPanel title1;
    public StudentRemoveScreen() throws HeadlessException {
        this("Admin | Dashboard");
    }

    public StudentRemoveScreen(String title) throws HeadlessException{
        super(title);
        navBar = new AdminNavBar();
        filterBar = new rsFilterPanel();
        remove = new rsButtonPanel();
        title1 = new rsTitlePanel();
        initializeUI();
    }

    private void initializeUI() {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.setBackground(new Color(20, 33, 61));

        //empty panel for space
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(getWidth(), 50));

        JPanel emptyPanelWest = new JPanel();
        emptyPanelWest.setPreferredSize(new Dimension(50, getHeight()));

        JPanel emptyPanelEast = new JPanel();
        emptyPanelEast.setPreferredSize(new Dimension(50, getHeight()));

        //change background color
        emptyPanel.setBackground(new Color(20, 33, 61));
        emptyPanelWest.setBackground(new Color(20, 33, 61));
        emptyPanelEast.setBackground(new Color(20, 33, 61));
        navBar.setBackground(new Color(20, 33, 61));
        filterBar.setBackground(new Color(20, 33, 61));
        remove.setBackground(new Color(20, 33, 61));
        title1.setBackground(new Color(20, 33, 61));

        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());
        body.add(title1, BorderLayout.NORTH);
        body.add(filterBar, BorderLayout.CENTER);
        body.add(remove, BorderLayout.SOUTH);

        container.add(body, BorderLayout.CENTER);
        container.add(navBar, BorderLayout.NORTH);
        container.add(emptyPanelWest, BorderLayout.WEST);
        container.add(emptyPanelEast, BorderLayout.EAST);
        container.add(emptyPanel, BorderLayout.SOUTH);



        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentRemoveScreen();
        });
    }
}
