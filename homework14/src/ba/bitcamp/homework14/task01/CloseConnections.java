package ba.bitcamp.homework14.task01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * CloseConnections class has three methods used to close Connection, Statement and ResultSet
 * @author emina.a
 *
 */
public class CloseConnections {

	
	public static void closeConnection(Connection conn) {
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeStatement(Statement statement){
		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void closeResults(ResultSet result){
		if(result != null){
			try {
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
