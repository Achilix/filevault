package com.filevault;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DashboardPanel extends JPanel {
    private static final Color SURFACE = new Color(31, 33, 40);
    private static final Color MUTED = new Color(142, 149, 164);

    public DashboardPanel() {
        setLayout(new BorderLayout(0, 22));
        setBackground(new Color(24, 25, 30));
        setBorder(BorderFactory.createEmptyBorder(28, 30, 30, 30));

        JPanel intro = new JPanel(new BorderLayout());
        intro.setOpaque(false);
        JLabel welcome = new JLabel("Good evening");
        welcome.setFont(new Font("SansSerif", Font.BOLD, 24));
        welcome.setForeground(Color.WHITE);
        intro.add(welcome, BorderLayout.NORTH);
        JLabel description = new JLabel("Here is an overview of your FileVault workspace.");
        description.setFont(new Font("SansSerif", Font.PLAIN, 13));
        description.setForeground(MUTED);
        intro.add(description, BorderLayout.CENTER);

        JPanel content = new JPanel(new BorderLayout(0, 22));
        content.setOpaque(false);
        content.add(createStats(), BorderLayout.NORTH);
        content.add(createLowerSections(), BorderLayout.CENTER);
        add(intro, BorderLayout.NORTH);
        add(content, BorderLayout.CENTER);
    }

    private JPanel createStats() {
        JPanel stats = new JPanel(new GridLayout(1, 4, 14, 0));
        stats.setOpaque(false);
        stats.add(statCard("TOTAL INDEXED FILES", "12,846", "↑ 8.2% this month", new Color(83, 163, 255)));
        stats.add(statCard("TOTAL STORAGE", "486.2 GB", "of 1 TB available", new Color(167, 127, 255)));
        stats.add(statCard("DUPLICATE FILES", "342", "Potential space savings", new Color(255, 174, 89)));
        stats.add(statCard("BACKUP COUNT", "18", "Last backup 2h ago", new Color(92, 207, 151)));
        return stats;
    }

    private JPanel statCard(String title, String value, String detail, Color accent) {
        JPanel card = cardPanel();
        card.setLayout(new BorderLayout(0, 8));
        JLabel titleLabel = label(title, 10, Font.BOLD, MUTED);
        JLabel valueLabel = label(value, 25, Font.BOLD, Color.WHITE);
        JLabel detailLabel = label(detail, 11, Font.PLAIN, accent);
        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);
        card.add(detailLabel, BorderLayout.SOUTH);
        return card;
    }

    private JPanel createLowerSections() {
        JPanel sections = new JPanel(new GridLayout(1, 2, 14, 0));
        sections.setOpaque(false);
        JPanel recent = section("Recent files");
        recent.add(row("Project brief.pdf", "Documents  •  2 minutes ago"));
        recent.add(row("Vacation photos", "Pictures  •  Yesterday"));
        recent.add(row("Application backup.zip", "Archives  •  Yesterday"));
        JPanel distribution = section("Storage distribution");
        distribution.add(row("Documents", "214.8 GB"));
        distribution.add(row("Media", "168.3 GB"));
        distribution.add(row("Archives", "103.1 GB"));
        sections.add(recent);
        sections.add(distribution);
        return sections;
    }

    private JPanel section(String title) {
        JPanel section = cardPanel();
        section.setLayout(new GridLayout(0, 1, 0, 14));
        section.add(label(title, 15, Font.BOLD, Color.WHITE));
        return section;
    }

    private JLabel row(String title, String detail) {
        JLabel row = label("<html><b>" + title + "</b><br><font color='#8e95a4'>" + detail + "</font></html>",
                12, Font.PLAIN, Color.WHITE);
        row.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(54, 57, 67)));
        return row;
    }

    static JPanel cardPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(SURFACE);
        panel.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));
        panel.setMinimumSize(new Dimension(180, 110));
        return panel;
    }

    static JLabel label(String text, int size, int style, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("SansSerif", style, size));
        label.setForeground(color);
        return label;
    }
}
