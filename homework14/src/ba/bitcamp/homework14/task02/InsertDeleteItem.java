package ba.bitcamp.homework14.task02;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * InsertDeleteItem class has GUI Application used for insert items into database.
 * All items have their unique ten digits number, name and price. If user insert item 
 * that has been already in database, warning message will pop up.Item code can not 
 * contain characters and has to have ten digits. 
 * @author emina.a
 *
 */
public class InsertDeleteItem extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = -7835165287410473672L;
	//private JLabel labelInstruction = new JLabel("Fill out item information");
	private JPanel mainPanel  = new JPanel();
	private JPanel labelField = new JPanel();
	private JLabel labelCode = new JLabel("Item code 10 digits: ");
	private JLabel labelName = new JLabel("Item name: ");
	private JLabel labelPrice = new JLabel("Item price: ");
	private JTextField fieldCode = new JTextField();
	private JTextField fieldName = new JTextField();
	private JTextField fieldPrice = new JTextField();
	private JButton btnSend = new JButton("Update");
	
	public static String databaseURL ="jdbc:sqlite:item.db";
	public static String jdbcDriver = "org.sqlite.JDBC";
	
	/**
	 * GuiInsert constructor
	 */
	public InsertDeleteItem(){
		
		labelCode.setPreferredSize(new Dimension(125, 50));
		fieldCode.setPreferredSize(new Dimension(225, 50));
		labelField.add(labelCode);
		labelField.add(fieldCode);
		labelName.setPreferredSize(new Dimension(125, 50));
		fieldName.setPreferredSize(new Dimension(225, 50));
		labelField.add(labelName);
		labelField.add(fieldName);
		labelPrice.setPreferredSize(new Dimension(125, 50));
 		fieldPrice.setPreferredSize(new Dimension(225, 50));
 		labelField.add(labelPrice);
 		labelField.add(fieldPrice);
 		labelField.setBorder(BorderFactory.createTitledBorder("New Item"));
		
 		mainPanel.setLayout(new BorderLayout());
 		mainPanel.add(labelField, BorderLayout.CENTER);
 		
 		btnSend.setPreferredSize(new Dimension(50, 55));
		mainPanel.add(btnSend, BorderLayout.SOUTH);
		btnSend.addActionListener(this); //adding button action listener
		
		add(mainPanel); //adding mainPanel to the frame
		
		setTitle("Adding items");
		setLocationRelativeTo(null);
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Implemented Action listener method to add action to the button. 
	 * Click on button updates item.bd getting code, name and price from text fields
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSend) {
			DatabaseConnection.updateItem(fieldCode.getText(),fieldName.getName(),Double.parseDouble(fieldPrice.getText()));
		}
		if (DatabaseConnection.isUpdated) {
			clearField();
		}

	}

	/**
	 * This method will clear text from used text fields
	 */
	private void clearField() {
		fieldCode.setText("");
		fieldName.setText("");
		fieldPrice.setText("");
	}


	public static void main(String[] args) {
		DatabaseConnection.dbConnection();
		new InsertDeleteItem();
	}
}
