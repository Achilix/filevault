package com.filevault;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CategoriesPanel extends JPanel {
    public CategoriesPanel() {
        setLayout(new BorderLayout(0, 20));
        setBackground(new Color(24, 25, 30));
        setBorder(BorderFactory.createEmptyBorder(28, 30, 30, 30));
        add(DashboardPanel.label("Categories", 20, Font.BOLD, Color.WHITE), BorderLayout.NORTH);
        JPanel content = DashboardPanel.cardPanel();
        content.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
        content.add(new JLabel("Organize your files by category."));
        add(content, BorderLayout.CENTER);
    }
}
