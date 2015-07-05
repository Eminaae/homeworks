package ba.bitcamp.homework04.homework04.task01;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Task08 extends JFrame{
	
	private static final long serialVersionUID = -8205545055031957929L;

	private JLabel lblUsername = new JLabel("Username:");
	private JLabel lblPassword = new JLabel("Password:");
	private JLabel lblConfirm = new JLabel("Confirm:");
	private JTextField txtUsername = new JTextField();
	private JPasswordField passPassword = new JPasswordField();
	private JPasswordField passConfirm = new JPasswordField();	
	private JButton btnClear = new JButton("Clear");
	private JButton btnSubmit = new JButton("Submit");
	
	
	public Task08() {
		setLayout(new FlowLayout());
		txtUsername.setPreferredSize(new Dimension(200, 20));
		passPassword.setPreferredSize(new Dimension(200, 20));
		passConfirm.setPreferredSize(new Dimension(200, 20));
		
		btnClear.addActionListener(new Action());
		btnSubmit.addActionListener(new Action());
		
		add(lblUsername);
		add(txtUsername);
		add(lblPassword);
		add(passPassword);
		add(lblConfirm);
		add(passConfirm);
		add(btnClear);
		add(btnSubmit);
		
		
		setTitle("Task 8");
		setSize(250, 230);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnClear){
				txtUsername.setText("");
				passPassword.setText("");
				passConfirm.setText("");
			} else if (e.getSource() == btnSubmit){
				System.out.println(String.valueOf(passPassword.getPassword()));
				System.out.println(String.valueOf(passConfirm.getPassword()));
				if(txtUsername.getText().length() < 6){
					JOptionPane.showMessageDialog(null, "Username must have at least 6 characters");
				} else if (!String.valueOf(passPassword.getPassword()).equals(String.valueOf(passConfirm.getPassword()))){
					JOptionPane.showMessageDialog(null, "Wrong password");
				} else if (passPassword.getPassword().length < 6){
					JOptionPane.showMessageDialog(null, "Password must have at least 6 characters");
				} else if (!hasDigitAndCharacter(passPassword.getPassword())){
					JOptionPane.showMessageDialog(null, "Password must have at least one special character\n(@ # ^ %) and at least one digit");
					
				} else {
					setVisible(false);
					JOptionPane.showMessageDialog(null, "Form filled out succesfully");
					System.exit(0);
				}
			}
		}

		private boolean hasDigitAndCharacter(char[] password) {
			for (int i = 0; i < password.length; i++) {
				if(password[i] >= 48 && password[i] <= 57){
					for (int j = 0; j < password.length; j++) {
						if((password[j] >= 33 && password[j] <= 46) || (password[j] >= 58 && password[j] <= 64)){
							return true;
						}
					}
				}
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		new Task08();
	}
}