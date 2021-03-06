package ba.bitcamp.homework14.task01;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GuiSendCompaint extends JFrame{

	private static final long serialVersionUID = -4485561331072213969L;
	private JLabel label = new JLabel();
	private JButton sendBtn = new JButton("send");
	private JTextField text = new JTextField();

	/**
	 * Initializing GUI
	 */
	public GuiSendCompaint(){
		setLayout(new BorderLayout());
		add(label);
		add(sendBtn, BorderLayout.SOUTH);
		add(text, BorderLayout.NORTH);
		text.setPreferredSize(new Dimension(300, 220));
		sendBtn.addActionListener(new Action());
		
		setTitle("Create complaint message");
		setSize(320,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	public class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			Connection conn = null;
			Statement statement = null;
			
			try {
				conn = ConnectToDatabase.connect();
				Complaint compl = new Complaint();
				statement = conn.createStatement();
				compl.setDateTime(DateTime.dateTime());
				String insertComplaint = "INSERT INTO book (complaint, date) VALUES('"
						+ text.getText() + "', '" + compl.getDateTime() + "')";

				statement.executeUpdate(insertComplaint);
			} catch (SQLException e1) {
				System.err.println("Could not connect to the database.");
				System.err.println("Msg: " + e1.getMessage());
				System.exit(1);
			} catch (ClassNotFoundException e3) {
				System.err.println("JDBC library is not loaded.");
				System.err.println("Msg: " + e3.getMessage());
				System.exit(1);
			}finally{
				CloseConnections.closeStatement(statement);
				CloseConnections.closeConnection(conn);
			}

		}
	}
}
