package com.filevault;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SidebarPanel extends JPanel {
    private static final Color SIDEBAR_BACKGROUND = new Color(27, 29, 35);
    private static final Color MUTED_TEXT = new Color(132, 139, 154);
    private final Map<String, JButton> navigationButtons = new LinkedHashMap<>();

    public SidebarPanel(ActionListener navigationListener) {
        setPreferredSize(new Dimension(230, 0));
        setBackground(SIDEBAR_BACKGROUND);
        setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, new Color(52, 55, 64)));
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);
        top.setBorder(BorderFactory.createEmptyBorder(24, 20, 22, 18));
        JLabel brand = new JLabel("FILEVAULT");
        brand.setFont(new Font("SansSerif", Font.BOLD, 18));
        brand.setForeground(Color.WHITE);
        top.add(brand, BorderLayout.CENTER);
        JLabel version = new JLabel("DESKTOP");
        version.setFont(new Font("SansSerif", Font.BOLD, 9));
        version.setForeground(new Color(89, 164, 255));
        top.add(version, BorderLayout.SOUTH);

        JPanel menu = new JPanel(new GridLayout(0, 1, 0, 6));
        menu.setOpaque(false);
        menu.setBorder(BorderFactory.createEmptyBorder(0, 12, 12, 12));
        addNavigationButton(menu, "dashboard", "⌂   Dashboard", navigationListener);
        addNavigationButton(menu, "files", "▣   Files", navigationListener);
        addNavigationButton(menu, "categories", "▤   Categories", navigationListener);
        addNavigationButton(menu, "duplicates", "◈   Duplicates", navigationListener);
        addNavigationButton(menu, "backup", "↥   Backup", navigationListener);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setOpaque(false);
        bottom.setBorder(BorderFactory.createEmptyBorder(12, 12, 20, 12));
        addNavigationButton(bottom, "settings", "⚙   Settings", navigationListener);

        add(top, BorderLayout.NORTH);
        add(menu, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    private void addNavigationButton(JPanel parent, String key, String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.setActionCommand(key);
        button.addActionListener(listener);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setFont(new Font("SansSerif", Font.PLAIN, 13));
        button.setForeground(MUTED_TEXT);
        button.setBackground(new Color(31, 33, 40));
        button.setBorder(BorderFactory.createEmptyBorder(11, 14, 11, 10));
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setFocusPainted(false);
        button.setOpaque(true);
        navigationButtons.put(key, button);
        parent.add(button);
    }

    public Map<String, JButton> getNavigationButtons() {
        return navigationButtons;
    }
}
