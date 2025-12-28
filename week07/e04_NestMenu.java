package week07;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class e04_NestMenu {

    // Card names
    private static final String CARD_ROOT = "root";
    private static final String CARD_GENERAL = "general";
    private static final String CARD_ABOUT = "about";

    private final JFrame frame = new JFrame("Swing - Nested Menu");
    private final CardLayout cards = new CardLayout();
    private final JPanel cardPanel = new JPanel(cards);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new e04_NestMenu().start());
    }

    private void start() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardPanel.add(buildRootScreen(), CARD_ROOT);
        cardPanel.add(buildGeneralScreen(), CARD_GENERAL);
        cardPanel.add(buildAboutScreen(), CARD_ABOUT);

        frame.setContentPane(cardPanel);
        frame.setSize(360, 520);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        cards.show(cardPanel, CARD_ROOT);
    }

    // ---------- Screens ----------

    private JPanel buildRootScreen() {
        JPanel screen = screenBase();
        screen.add(title("Setting"));

        // Menu buttons (like the picture)
        screen.add(menuButton("1. General", () -> cards.show(cardPanel, CARD_GENERAL)));
        screen.add(menuButton("2. Wi-Fi", () -> info("Wi-Fi screen not implemented in this demo.")));
        screen.add(menuButton("3. Bluetooth", () -> info("Bluetooth screen not implemented in this demo.")));
        screen.add(menuButton("4. Mobile Data", () -> info("Mobile Data screen not implemented in this demo.")));
        screen.add(menuButton("5. Hotspot", () -> info("Hotspot screen not implemented in this demo.")));
        screen.add(menuButton("6. Notification", () -> info("Notification screen not implemented in this demo.")));

        screen.add(Box.createVerticalStrut(12));
        screen.add(menuButton("Quit", frame::dispose));

        return screen;
    }

    private JPanel buildGeneralScreen() {
        JPanel screen = screenBase();
        screen.add(title("Setting > General"));

        screen.add(menuButton("1. About", () -> cards.show(cardPanel, CARD_ABOUT)));
        screen.add(menuButton("2. Software update", () -> info("Software update not implemented in this demo.")));
        screen.add(menuButton("3. Storage", () -> info("Storage screen not implemented in this demo.")));

        screen.add(Box.createVerticalStrut(12));
        screen.add(menuButton("Back", () -> cards.show(cardPanel, CARD_ROOT)));

        return screen;
    }

    private JPanel buildAboutScreen() {
        JPanel screen = screenBase();
        screen.add(title("Setting > General > About"));

        // Simple "table" area
        JPanel infoPanel = new JPanel(new GridBagLayout());
        infoPanel.setOpaque(false);
        infoPanel.setBorder(new EmptyBorder(10, 4, 10, 4));

        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(6, 6, 6, 6);
        gc.anchor = GridBagConstraints.WEST;

        addRow(infoPanel, gc, 0, "Name", "iPhone");
        addRow(infoPanel, gc, 1, "Model", "iXs");
        addRow(infoPanel, gc, 2, "Version", "18.5");

        screen.add(infoPanel);

        screen.add(Box.createVerticalStrut(12));
        screen.add(menuButton("Back", () -> cards.show(cardPanel, CARD_GENERAL)));

        return screen;
    }

    // ---------- UI Helpers ----------

    private JPanel screenBase() {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBorder(new EmptyBorder(18, 18, 18, 18));
        p.setBackground(new Color(0xEEEEEE));
        return p;
    }

    private JComponent title(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(lbl.getFont().deriveFont(Font.BOLD, 16f));
        lbl.setBorder(new EmptyBorder(0, 0, 12, 0));
        lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
        return lbl;
    }

    private JComponent menuButton(String text, Runnable onClick) {
        JButton b = new JButton(text);
        b.setFocusPainted(false);
        b.setHorizontalAlignment(SwingConstants.LEFT);
        b.setAlignmentX(Component.LEFT_ALIGNMENT);
        b.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        b.addActionListener(e -> onClick.run());
        return b;
    }

    private void addRow(JPanel panel, GridBagConstraints gc, int row, String left, String right) {
        gc.gridy = row;

        gc.gridx = 0;
        gc.weightx = 0;
        JLabel l = new JLabel(left);
        l.setFont(l.getFont().deriveFont(13f));
        panel.add(l, gc);

        gc.gridx = 1;
        gc.weightx = 1;
        gc.anchor = GridBagConstraints.EAST;
        JLabel r = new JLabel(right);
        r.setFont(r.getFont().deriveFont(13f));
        panel.add(r, gc);

        gc.anchor = GridBagConstraints.WEST;
    }

    private void info(String msg) {
        JOptionPane.showMessageDialog(frame, msg, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
