package com.filevault;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DuplicatesPanel extends JPanel {
    public DuplicatesPanel() {
        setLayout(new BorderLayout(0, 20));
        setBackground(new Color(24, 25, 30));
        setBorder(BorderFactory.createEmptyBorder(28, 30, 30, 30));
        add(DashboardPanel.label("Duplicate files", 20, Font.BOLD, Color.WHITE), BorderLayout.NORTH);
        JPanel content = DashboardPanel.cardPanel();
        content.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
        content.add(DashboardPanel.label("Duplicate scan results will appear here.", 14, Font.PLAIN,
                new Color(142, 149, 164)));
        add(content, BorderLayout.CENTER);
    }
}
