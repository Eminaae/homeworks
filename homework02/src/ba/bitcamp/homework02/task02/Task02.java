package ba.bitcamp.homework02.task02;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Task02 extends JFrame {

	private static final long serialVersionUID = 122460485688871873L;
	private String firstName = getUserName();
	private String lastName = getUserLastName();
	private JButton buttonName = new JButton("Name");
	private JButton buttonLastName = new JButton("Last name");
	private JLabel text = new JLabel(firstName + " " + lastName);

	public Task02() {
		JFrame window = new JFrame();
		window.setBounds(100, 100, 300, 450);
		window.setTitle("Task 2");
		window.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		add(buttonName, BorderLayout.WEST);
		buttonName.setHorizontalAlignment(NORMAL);
		add(buttonLastName, BorderLayout.EAST);
		buttonLastName.setHorizontalAlignment(NORMAL);
		buttonName.addActionListener(new Action());
		buttonLastName.addActionListener(new Action());
		text.setHorizontalAlignment(NORMAL);
		add(text, BorderLayout.CENTER);
		setSize(400, 150);
		setVisible(true);

	}

	private class Action implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttonName) {
				firstName = getUserName();
			} else if (e.getSource() == buttonLastName) {
				lastName = getUserLastName();
			}
			text.setText(firstName + " " + lastName);
		}
	}

	private String getUserName() {

		String name1[] = { "alma", "alen", "dado", "tarik", "mija", "amina" };
		Random generator = new Random();
		int rand = generator.nextInt(name1.length - 1);
		return name1[rand];
	}

	private String getUserLastName() {
		String lastname1[] = { "mott", "tanovic", "nuhic", "botic" };
		Random generator = new Random();
		int rand = generator.nextInt(lastname1.length - 1);
		return lastname1[rand];
	}

	public static void main(String[] args) {
		new Task02();
	}
}
