/**
 * a program to perform calculation of two inputs with operators: addition,
 * subtraction, multiplication and division using a simple GUI (Swing).
 */
package week06;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class e05_simpleCalc {
	public static void main(String[] args) {
		new setUIFont();

		JFrame f = new JFrame("Simple Calculator");
		JPanel root = new JPanel();
		root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));

		JPanel inputPanel = new JPanel(new GridLayout(2,1,8,8));
		inputPanel.setBorder(new EmptyBorder(20,20,20,20));
		inputPanel.add(new JLabel("A:"));
		JTextField aField = new JTextField();
		inputPanel.add(aField);
		inputPanel.add(new JLabel("B:"));
		JTextField bField = new JTextField();
		inputPanel.add(bField);

		JPanel buttons = new JPanel();
		JButton add = new JButton("+");
		JButton sub = new JButton("-");
		JButton mul = new JButton("*");
		JButton div = new JButton("/");
		buttons.add(add); buttons.add(sub); buttons.add(mul); buttons.add(div);

		JLabel result = new JLabel("Result: ");

		root.add(inputPanel);
		root.add(buttons);
		root.add(result);
		root.add(new JLabel("Developed by ME"));

		f.add(root);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setVisible(true);

		ActionListener doCalc = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					double a = Double.parseDouble(aField.getText().trim());
					double b = Double.parseDouble(bField.getText().trim());
					String op = ((JButton)e.getSource()).getText();
					double r;
					switch (op) {
						case "+": r = a + b; break;
						case "-": r = a - b; break;
						case "*": r = a * b; break;
						case "/": 
							if (b == 0) { result.setText("Error: divide by zero"); return; }
							r = a / b; break;
						default: result.setText("Unknown operation"); return;
					}
					if (r == (long) r) result.setText("Result: " + String.format("%d", (long) r));
					else result.setText("Result: " + r);
			}
		};

		add.addActionListener(doCalc);
		sub.addActionListener(doCalc);
		mul.addActionListener(doCalc);
		div.addActionListener(doCalc);
	}
}