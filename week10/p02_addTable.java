package week10;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    Connection conn;

    public static Connection connectDB() {
        try {
            return DriverManager.getConnection("jdbc:sqlite:student.db");
        } catch (SQLException e) {
            System.out.println(e.getClass().getSimpleName());
            return null;
        }
    }

    public p02_addTable() {
        setTitle("Insert Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));
        add(createInputPanel(), BorderLayout.NORTH);
        add(createTablePanel(), BorderLayout.CENTER);

        // Connect DB + create table + load data
        conn = connectDB();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Database connection failed!");
            return;
        }

        createStudentTableIfNotExists();
        loadStudentsFromDB();
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
        tableModel = new DefaultTableModel();
        tableModel.addColumn("First name");
        tableModel.addColumn("Last name");

        JTable table = new JTable(tableModel);
        JTableHeader header = table.getTableHeader();

        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) table.getTableHeader()
                .getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(JLabel.CENTER);

        header.setFont(new Font("Poppins", Font.PLAIN, 12));
        table.setRowHeight(30);

        JScrollPane panel = new JScrollPane(table);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return panel;
    }

    // ---------- Insert ----------
    void addStudent() {
        String first = txtFirstName.getText().trim();
        String last = txtLastName.getText().trim();

        if (first.isEmpty() || last.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill all fields");
            return;
        }

        String sql = "INSERT INTO students(first_name, last_name) VALUES(?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, first);
            ps.setString(2, last);
            ps.executeUpdate();

            // Refresh UI from DB (or you can addRow directly after insert)
            loadStudentsFromDB();

            txtFirstName.setText("");
            txtLastName.setText("");
            txtFirstName.requestFocus();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Insert failed!");
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new p02_addTable().setVisible(true));
    }

        // ---------- Internal DB ----------
    private void createStudentTableIfNotExists() {
        String sql = """
                    CREATE TABLE IF NOT EXISTS students (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        first_name TEXT NOT NULL,
                        last_name  TEXT NOT NULL
                    )
                """;
        try (Statement st = conn.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to create table!");
        }
    }

    private void loadStudentsFromDB() {
        tableModel.setRowCount(0); // clear table

        String sql = "SELECT first_name, last_name FROM students ORDER BY id DESC";
        try (PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                tableModel.addRow(new Object[] { first, last });
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to load students!");
        }
    }

}
