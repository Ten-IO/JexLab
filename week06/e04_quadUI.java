package week06;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import week03.e01_quadEquation;

public class e04_quadUI {
    static JTextField initField() {
        JTextField field = new JTextField("Type here..");
        field.setForeground(Color.gray);
        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals("Type here.."))
                    field.setText("");
                field.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().equals("")) {
                    field.setText("Type here..");
                    field.setForeground(Color.gray);
                }
            }
        });
        return field;
    }

    public static void main(String[] args) {
        
        JFrame f = new JFrame("Quadratic Solver");

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField _01 = initField();
        JTextField _02 = initField();
        JTextField _03 = initField();
        JButton _04 = new JButton("find");
        JLabel _05 = new JLabel("Result: ");

        JComponent ls[] = { _01, _02, _03, _04, _05 };
        for (JComponent c : ls)
            panel.add(c);

        f.add(panel);

        _04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float a = Float.parseFloat(_01.getText());
                float b = Float.parseFloat(_02.getText());
                float c = Float.parseFloat(_03.getText());
                float res[] = e01_quadEquation.solveQuad(a,b,c);

                if (res.length == 1)
                    _05.setText("Result: x = " + res[0]);
                else
                    _05.setText("Result: x₁ = " + res[0] + "x₂ = " + res[1]);
            }
        });
        f.pack();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setFocusable(true);
    }
}
