package com.filevault;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class MainFrame extends JFrame {
    private static final Color CONTENT_BACKGROUND = new Color(24, 25, 30);
    private static final String DASHBOARD = "dashboard";

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel contentCards = new JPanel(cardLayout);
    private final JLabel pageTitle = new JLabel("Dashboard");
    private final Map<String, JButton> navigationButtons = new LinkedHashMap<>();

    public MainFrame() {
        setTitle("FileVault");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(980, 640));
        setSize(1280, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        SidebarPanel sidebar = new SidebarPanel(event -> showPage(event.getActionCommand()));
        add(sidebar, BorderLayout.WEST);
        add(createMainArea(), BorderLayout.CENTER);

        registerNavigationButtons(sidebar);
        showPage(DASHBOARD);
    }

    private JPanel createMainArea() {
        JPanel mainArea = new JPanel(new BorderLayout());
        mainArea.setBackground(CONTENT_BACKGROUND);
        mainArea.add(new HeaderPanel(pageTitle), BorderLayout.NORTH);

        contentCards.setBackground(CONTENT_BACKGROUND);
        addPage(DASHBOARD, new DashboardPanel());
        addPage("files", new FilesPanel());
        addPage("categories", new CategoriesPanel());
        addPage("duplicates", new DuplicatesPanel());
        addPage("backup", new BackupPanel());
        addPage("settings", new SettingsPanel());

        JScrollPane scrollPane = new JScrollPane(contentCards);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        mainArea.add(scrollPane, BorderLayout.CENTER);
        return mainArea;
    }

    private void addPage(String key, JPanel panel) {
        contentCards.add(panel, key);
    }

    private void registerNavigationButtons(SidebarPanel sidebar) {
        navigationButtons.putAll(sidebar.getNavigationButtons());
    }

    private void showPage(String pageKey) {
        String title = navigationButtons.containsKey(pageKey)
                ? navigationButtons.get(pageKey).getText() : "Dashboard";
        pageTitle.setText(title);
        cardLayout.show(contentCards, pageKey);
        navigationButtons.forEach((key, button) -> {
            boolean active = key.equals(pageKey);
            button.setBackground(active ? new Color(45, 93, 150) : new Color(31, 33, 40));
            button.setForeground(active ? Color.WHITE : new Color(174, 180, 193));
        });
    }
}
