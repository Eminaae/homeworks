package ba.bitcamp.homework14.task02;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DatabaseConnection {

	public static boolean isUpdated = false; //declare variable to show if item is updated successfully
	public static String databaseURL ="jdbc:sqlite:item.db";
	public static String jdbcDriver = "org.sqlite.JDBC";
	private static Connection conn = null;
	
	/**
	 * Connection connect method to create a connection to a SQLite database file item.db
	 */
	public static void dbConnection(){
		
		try {
				Class.forName("org.sqlite.JDBC");
			} catch (ClassNotFoundException e) {
				System.err.println("Could not load the library.");
				System.err.println("Message: " + e.getMessage());
				System.exit(1);
			}
			System.out.println("Connecting to database...");
			try {if (conn != null) {
				System.out.println("Connected to the database.");
				DatabaseMetaData dmd = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dmd.getDriverName());
				System.out.println("Driver version: " + dmd.getDriverVersion());
				System.out.println("Product name: " + dmd.getDatabaseProductName());
				System.out.println("Product version: " + dmd.getDatabaseProductVersion());
				
			}
				conn = DriverManager.getConnection(databaseURL);
			}catch (SQLException e) {
				System.out.println("Connection to 'item' database could not be established.");
				System.err.println("Error message: " + e.getMessage());
				System.exit(1);
				}
			
		} 


	public static void updateItem(String code, String name, Double price) {
		if (code.length() != 10) {
			JOptionPane.showMessageDialog(null, "Insert 10 digits code please.");
			isUpdated = false;
			return;
		}

		for (int i = 0; i < code.length(); i++) {
			if (!Character.isDigit(code.charAt(i))) {
				JOptionPane.showMessageDialog(null,"Code should contain only digits. Please insert only digits in this field.");
				isUpdated = false;
				return;
			}
		}

		if (!checkItem(name).equals("")) {
			int option = JOptionPane.showConfirmDialog(null,"The product already exists in database. Do you want to continue?",
							"", JOptionPane.YES_NO_OPTION);
			if (option == JOptionPane.NO_OPTION) {
				isUpdated = false;
				return;
			}

		}
		
			try {
				
			Statement statement = conn.createStatement();
			statement.executeUpdate("INSERT INTO item VALUES ('" + code + "', '" + name + "', " + price + ")");
			JOptionPane.showMessageDialog(null, "You have successfully updated the database.");
			System.out.println("Query executed.");
			isUpdated = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Item " + code + " already exist in database.");
			return;
		}
	}

	private static Object checkItem(String name) {
		StringBuilder sb = new StringBuilder();
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT name FROM item WHERE name = '" + name+ "'");

			// Reading from database.
			while (result.next()) {
				sb.append(result.getString(1) + "\n");
			}
		} catch (SQLException e) {
			System.err.println("Invalid SQL command.");
			System.err.println("Message: " + e.getMessage());
			System.exit(1);
		}
		return sb.toString();

	}
	
	/**
	 * Method delete Item removes items from the database.
	 * 
	 * @param item - item that will be deleted
	 */
	public static void deleteItem(Item item) {
		try {
			
			Statement statement = conn.createStatement();
			statement.executeUpdate("DELETE FROM item WHERE code = " + item.getCode());
			JOptionPane.showMessageDialog(null, "You've successfully deleted the item from database.");
			System.out.println("Query executed.");
		} catch (SQLException e) {
			System.err.println("Invalid SQL query.");
			System.err.println("Message: " + e.getMessage());
			System.exit(1);
		}
	}
	
	/**
	 * Method selectProducts read from item.db and add items to the list
	 * 
	 * @return - list of items from item.db.
	 */
	public static ArrayList<Item> selectItem() {
		
		ArrayList<Item> array = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM item");

			//read from item.db and add items to the list
			while (result.next()) {
				array.add(new Item(result.getInt(1), result.getString(2), result.getDouble(3)));
			}
		} catch (SQLException e) {
			System.err.println("Not valid SQL command.");
			System.err.println("Message: " + e.getMessage());
			System.exit(1);
		}
		return array; //returns list of items in database
	}
}