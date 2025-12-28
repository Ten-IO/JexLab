package week07;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class e05_StudentTable extends JFrame{

    private JTextField txtFirstName, txtLastName, txtAge, txtMajor;
    private DefaultTableModel tableModel;

    public e05_StudentTable() {
        setTitle("Student Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));
        add(createInputPanel(), BorderLayout.NORTH);
        add(createTablePanel(), BorderLayout.CENTER);
    }

    // ---------- Top input panel ----------
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel title = new JLabel("Student Management");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(2, 5, 10, 5));

        form.add(new JLabel("First name"));
        form.add(new JLabel("Last name"));
        form.add(new JLabel("Age"));
        form.add(new JLabel("Major"));
        form.add(new JLabel(""));

        txtFirstName = new JTextField();
        txtLastName = new JTextField();
        txtAge = new JTextField();
        txtMajor = new JTextField();
        JButton btnAdd = new JButton("Add new");

        btnAdd.addActionListener(e -> addStudent());

        form.add(txtFirstName);
        form.add(txtLastName);
        form.add(txtAge);
        form.add(txtMajor);
        form.add(btnAdd);

        panel.add(form, BorderLayout.CENTER);
        return panel;
    }

    // ---------- Table panel ----------
    private JScrollPane createTablePanel() {
        // Table header
        tableModel = new DefaultTableModel();
        tableModel.addColumn("First name");
        tableModel.addColumn("Last name");
        tableModel.addColumn("Age");
        tableModel.addColumn("Major");

        // Sample data (as in slide)
        tableModel.addRow(new Object[]{"AA", "Tola", 21, "IT"});
        tableModel.addRow(new Object[]{"AA", "Makara", 19, "IT"});
        tableModel.addRow(new Object[]{"AA", "Tola", 21, "IT"});
        tableModel.addRow(new Object[]{"AA", "Makara", 19, "IT"});

        JTable table = new JTable(tableModel);
        table.setRowHeight(22);

        return new JScrollPane(table);
    }

    // ---------- Add student ----------
    private void addStudent() {
        String first = txtFirstName.getText();
        String last = txtLastName.getText();
        String age = txtAge.getText();
        String major = txtMajor.getText();

        if (first.isEmpty() || last.isEmpty() || age.isEmpty() || major.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        tableModel.addRow(new Object[]{first, last, age, major});

        txtFirstName.setText("");
        txtLastName.setText("");
        txtAge.setText("");
        txtMajor.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new e05_StudentTable().setVisible(true));
    }
}