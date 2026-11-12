package com.filevault;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HeaderPanel extends JPanel {
    public HeaderPanel(JLabel pageTitle) {
        setLayout(new BorderLayout());
        setBackground(new Color(24, 25, 30));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(52, 55, 64)),
                BorderFactory.createEmptyBorder(18, 30, 18, 30)));

        pageTitle.setFont(new Font("SansSerif", Font.BOLD, 22));
        pageTitle.setForeground(Color.WHITE);
        add(pageTitle, BorderLayout.WEST);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        actions.setOpaque(false);
        JLabel status = new JLabel("●  Ready");
        status.setFont(new Font("SansSerif", Font.PLAIN, 12));
        status.setForeground(new Color(101, 202, 143));
        actions.add(status);
        JButton notifications = new JButton("♡");
        notifications.setToolTipText("Notifications");
        notifications.setFont(new Font("SansSerif", Font.PLAIN, 18));
        notifications.setForeground(new Color(174, 180, 193));
        notifications.setMargin(new Insets(0, 8, 0, 8));
        notifications.setFocusPainted(false);
        actions.add(notifications);
        add(actions, BorderLayout.EAST);
    }
}
