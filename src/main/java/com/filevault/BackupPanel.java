package com.filevault;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BackupPanel extends JPanel {
    public BackupPanel() {
        setLayout(new BorderLayout(0, 20));
        setBackground(new Color(24, 25, 30));
        setBorder(BorderFactory.createEmptyBorder(28, 30, 30, 30));
        JPanel heading = new JPanel(new BorderLayout());
        heading.setOpaque(false);
        heading.add(DashboardPanel.label("Backup", 20, Font.BOLD, Color.WHITE), BorderLayout.WEST);
        heading.add(new JButton("+ New backup"), BorderLayout.EAST);
        add(heading, BorderLayout.NORTH);
        JPanel content = DashboardPanel.cardPanel();
        content.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
        content.add(DashboardPanel.label("Configure your first backup job to get started.", 14, Font.PLAIN,
                new Color(142, 149, 164)));
        add(content, BorderLayout.CENTER);
    }
}
