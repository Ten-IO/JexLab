package week06;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class e03_CharCounterUI {
    public static void main(String[] args) {
        Font font = new Font("Verdana", Font.PLAIN, 14);
        for (Object o : UIManager.getDefaults().keySet())
            if (UIManager.get(o) instanceof Font)
                UIManager.put(o, font);
        JFrame f = new JFrame("Character Counter");

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel _01 = new JLabel("Count: Vowel, Consonant, and Space");
        JLabel _02 = new JLabel("Text");
        JTextArea _03 = new JTextArea("Type here..");
        _03.setForeground(Color.gray);
        _03.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (_03.getText().equals("Type here.."))
                    _03.setText("");
                _03.setForeground(Color.black);
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (_03.getText().equals("")) {
                    _03.setText("Type here..");
                    _03.setForeground(Color.gray);
                }
            }
        });
        _03.setLineWrap(true);
        _03.setWrapStyleWord(true);
        JScrollPane scroll = new JScrollPane(_03);
        scroll.setPreferredSize(new Dimension(300, 100));
        JButton _04 = new JButton("find");
        JLabel _05 = new JLabel("Count of vowel: ");
        JLabel _06 = new JLabel("Count of conso: ");
        JLabel _07 = new JLabel("Count of space: ");

        panel.add(_01);
        panel.add(_02);
        panel.add(scroll);
        panel.add(_04);
        panel.add(_05);
        panel.add(_06);
        panel.add(_07);

        f.add(panel);

        _04.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = _03.getText().toLowerCase();
                int vow = 0, cons = 0, space = 0;
                for (char c : text.toCharArray())
                    if ("aeiou".indexOf(c) >= 0)
                        vow++;
                    else if (Character.isLetter(c))
                        cons++;
                    else if (c == ' ')
                        space++;
                _05.setText("Count of vowel: " + vow);
                _06.setText("Count of cons: " + cons);
                _07.setText("Count of space: " + space);
            }
        });
        f.pack();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setFocusable(true);
    }
}