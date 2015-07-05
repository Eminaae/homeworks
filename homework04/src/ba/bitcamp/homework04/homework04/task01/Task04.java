package ba.bitcamp.homework04.homework04.task01;

import javax.swing.JOptionPane;

public class Task04 {

	public static void main(String[] args) {
		int a = Integer.parseInt(JOptionPane.showInputDialog("Enter a number"));

		int choice = JOptionPane.showConfirmDialog(null, "Print a?");

		if (choice == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "A = " + a);
		} else if (choice == JOptionPane.NO_OPTION) {
			JOptionPane.showMessageDialog(null, "Okay, I won't print it.");
		} else if (choice == JOptionPane.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(null, "Okay, you canceled.");
		}
	}
}
