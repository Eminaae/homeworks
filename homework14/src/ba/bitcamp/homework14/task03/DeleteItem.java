package ba.bitcamp.homework14.task03;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ba.bitcamp.homework14.task02.DatabaseConnection;
import ba.bitcamp.homework14.task02.Item;
/**
 * GUI application with option where user can select item and delete it. 
 * @author emina.a
 *
 */
public class DeleteItem extends JFrame implements ActionListener {

	private static final long serialVersionUID = 7438362877535308598L;

	private JPanel panel = new JPanel();
	private ArrayList<Item> items = DatabaseConnection.selectItem();
	//The default model for combo boxes
	private DefaultComboBoxModel<Item> comboBox = new DefaultComboBoxModel(items.toArray());
	private JComboBox<Item> box = new JComboBox<>();//A component that combines a button or editable field and a drop-down list
	private JButton delete = new JButton("Delete");

	/**
	 * Constructor.
	 */

	public DeleteItem() {

		
		box.setModel(comboBox);
		box.setSelectedIndex(0);
		box.setPreferredSize(new Dimension(280, 40));

		delete.addActionListener(this);
		delete.setPreferredSize(new Dimension(280, 50));

		panel.setBorder(BorderFactory.createTitledBorder("Delete Item"));
		panel.add(box);

		setLayout(new BorderLayout());
		
		add(panel, BorderLayout.CENTER);
		add(delete, BorderLayout.SOUTH);
		
		setSize(300, 175);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Delete Item");
		setVisible(true);
	}

	/**
	 * Deletes the selected product from the database.
	 */

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == delete) {
			DatabaseConnection.deleteItem((Item) box.getSelectedItem());
			items = DatabaseConnection.selectItem(); //update the list
			box.setModel(new DefaultComboBoxModel(items.toArray()));
		}
	}

	public static void main(String[] args) {
		DatabaseConnection.dbConnection();
		new DeleteItem();
	}
}