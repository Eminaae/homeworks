package ba.bitcamp.homework15.task01;
/**
 * Abstract class Model has two methods findByPk and findByAtibute. Both methods return strnig.
 * findByPk gets Integer as parameter, findByAttribute has two strings as parameters.
 * @author USER
 *
 */
public abstract class Model {

	private String tableName;


	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 * Find row with primary key
	 * 
	 */
	public String findByPk(Integer id) {
		StringBuilder sb = new StringBuilder();
		if (id != null) {
			sb.append("SELECT * FROM ").append(tableName);
			sb.append(" WHERE id = ").append(id);
			return sb.toString();
		} else {
			return errorMessage();
		}

	}

	/**
	 * Finding attribute from values from table
	 * 
	 */
	public String findByAtibute(String attribute, String value) {
		StringBuilder sb = new StringBuilder();
		if (attribute != null && value != null) {
			sb.append("SELECT * FROM ").append(tableName).append(" WHERE ");
			sb.append(attribute).append(" = '").append(value).append("'");
			return sb.toString();
		} else {
			return errorMessage();
		}
	}

	/**
	 * Method returns errorMessage in case there is no input in table
	 */
	private String errorMessage() {
		return "Invalid insert. Check if all fields are entered. ";
	}


	public String getTableName() {
		return tableName;
	}

	/**
	 * toString method that returns table name
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Table: ").append(tableName);
		return sb.toString();
	}

}

