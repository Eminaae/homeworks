package ba.bitcamp.homework02.task03;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Task03 extends JFrame {

	private static final long serialVersionUID = -2068996437243526697L;
	private JButton[] button = new JButton[10];
	private String[] number = new String[5];
	private int index = 0;
	private int counter = 0;

	public Task03() {

		setLayout(new GridLayout(2, 0, 5, 5));

		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton(i + "");
			add(button[i]);
			button[i].addActionListener(new Action());
		}

		setTitle("Choose five numbers");
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (counter < 5) {
				for (int i = 0; i < button.length; i++) {
					if (e.getSource() == button[i]) {
						number[index] = button[i].getText();
						index++;
						button[i].setEnabled(false);
						if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4) {
							button[i + 5].setEnabled(false);
						} else if (i == 5 || i == 6 || i == 7 || i == 8
								|| i == 9) {
							button[i - 5].setEnabled(false);
						}
					}
				}
			}
			counter++;
			if (counter == 5) {
				JOptionPane.showMessageDialog(null, "Choosen numbers: "
						+ Arrays.toString(number));
				counter = 0;
				index = 0;
				for (int i = 0; i < button.length; i++) {
					button[i].setEnabled(true);
				}
			}
		}
	}

	public static void main(String[] args) {

		new Task03();

	}

}
