package week07;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class p02_addTable extends JFrame {

    JTextField txtFirstName, txtLastName;
    DefaultTableModel tableModel;

    public p02_addTable() {
        setTitle("Insert Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));
        add(createInputPanel(), BorderLayout.NORTH);
        add(createTablePanel(), BorderLayout.CENTER);
    }

    // ---------- Top panel ----------
    JPanel createInputPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel title = new JLabel("Insert a Student");
        title.setFont(new Font("Poppins", Font.BOLD, 24));
        panel.add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(2, 5, 10, 5));

        form.add(new JLabel("First name"));
        form.add(new JLabel("Last name"));
        form.add(new JLabel(""));

        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        JButton btnAdd = new JButton("Add");

        btnAdd.addActionListener(e -> addStudent());

        form.add(txtFirstName);
        form.add(txtLastName);
        form.add(btnAdd);

        panel.add(form);
        return panel;
    }

    // ---------- Table panel ----------
    JScrollPane createTablePanel() {
        // Table header
        tableModel = new DefaultTableModel();
        tableModel.addColumn("First name");
        tableModel.addColumn("Last name");

        // Sample data
        tableModel.addRow(new Object[] { "Sad", "Tola" });
        tableModel.addRow(new Object[] { "Wit", "Makara" });
        tableModel.addRow(new Object[] { "Son", "Tola" });

        JTable table = new JTable(tableModel);
        JTableHeader header = table.getTableHeader();

        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);
        header.setFont(new Font("Poppins", Font.PLAIN, 12));
        table.setRowHeight(30);
        
        JScrollPane panel = new JScrollPane();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setViewportView(table);
        return panel;
    }

    // ---------- Add name ----------
    void addStudent() {
        String first = txtFirstName.getText();
        String last = txtLastName.getText();

        if (first.isEmpty() || last.isEmpty()) {
            JOptionPane.showMessageDialog(this, "fill all fields");
            return;
        }

        tableModel.addRow(new String[] { first, last });
        txtFirstName.setText("");
        txtLastName.setText("");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            /**
             * 
             * "com.sun.java.swing.plaf.windows.WindowsLookAndFeel"
             * "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel"
             * "com.sun.java.swing.plaf.motif.MotifLookAndFeel"
             * "java.swing.plaf.metal.MetalLookAndFeel"
             * "java.swing.plaf.nimbus.NimbusLookAndFeel"
             * "com.sun.java.swing.plaf.gtk.GTKLookAndFeel"
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new p02_addTable().setVisible(true));
    }
}