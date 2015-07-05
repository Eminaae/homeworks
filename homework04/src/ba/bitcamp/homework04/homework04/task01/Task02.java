package ba.bitcamp.homework04.homework04.task01;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task02 extends JFrame {

	private static final long serialVersionUID = -5397741203292272562L;

	private JLabel label = new JLabel("Text");
	private JCheckBox box1 = new JCheckBox("Bold");
	private JCheckBox box2 = new JCheckBox("Italic");
	private JButton button = new JButton("Apply");

	public Task02() {
		setLayout(new GridLayout(4, 1));

		add(label, BorderLayout.NORTH);
		label.setHorizontalAlignment(JLabel.CENTER);
		add(box1);
		add(box2);
		add(button);
		box1.addActionListener(new Action());
		box2.addActionListener(new Action());
		button.addActionListener(new Action());

		setTitle("Adjustable Font Style");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button) {
				if (box1.isSelected() && box2.isSelected()) {
					label.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 15));
				} else if (box1.isSelected()) {
					label.setFont(new Font("Serif", Font.BOLD, 15));
				} else {
					label.setFont(new Font("Serif", Font.ITALIC, 15));
				}
			}
		}
	}

	public static void main(String[] args) {
		new Task02();
	}
}
