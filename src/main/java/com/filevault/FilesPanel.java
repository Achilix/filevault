package com.filevault;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FilesPanel extends JPanel {
    public FilesPanel() {
        setLayout(new BorderLayout(0, 20));
        setBackground(new Color(24, 25, 30));
        setBorder(BorderFactory.createEmptyBorder(28, 30, 30, 30));

        JPanel heading = new JPanel(new BorderLayout());
        heading.setOpaque(false);
        heading.add(DashboardPanel.label("All files", 20, Font.BOLD, Color.WHITE), BorderLayout.WEST);
        JButton addFolder = new JButton("+ Add folder");
        addFolder.setForeground(Color.WHITE);
        addFolder.setBackground(new Color(45, 93, 150));
        heading.add(addFolder, BorderLayout.EAST);

        JPanel placeholder = DashboardPanel.cardPanel();
        placeholder.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
        placeholder.add(DashboardPanel.label("Your indexed files will appear here.", 14, Font.PLAIN,
                new Color(142, 149, 164)));
        add(heading, BorderLayout.NORTH);
        add(placeholder, BorderLayout.CENTER);
    }
}
