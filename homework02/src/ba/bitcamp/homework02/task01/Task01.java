package ba.bitcamp.homework02.task01;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task01 extends JFrame {

	private static final long serialVersionUID = -650194819221282202L;

	private JButton[] button = new JButton[10];
	private String s = "";

	public Task01() {

		JFrame window = new JFrame("Task 01");
		window.setBounds(50, 100, 150, 400);
		window.setLayout(new GridLayout(10, 1));
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Action[] listener = new Action[10];
		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton(Integer.toString(i));
			window.add(button[i]);
			listener[i] = new Action();
			button[i].addActionListener(listener[i]);
		}
		window.setVisible(true);
	}

	public class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < button.length; i++) {
				if (e.getSource() == button[i]) {
					s += Integer.toString(i);
					button[i].setEnabled(false);
				}
			}
			if (s.length() == 3) {
				JOptionPane.showMessageDialog(null, "Number: " + s, "Message",
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		new Task01();
	}
}
