package ba.bitcamp.homework15.task01;

public class Table extends Model {

	private Integer id;
	private String value;
	private String attribute;

	/**
	 * Override method from super class, use to set tableName
	
	 */
	@Override
	public void setTableName(String tableName) {
		super.setTableName(tableName);
	}

	
	public Integer getId() {
		return Integer.parseInt(findByPk(id));
	}

	
	public String getAttribute() {
		return findByAtibute(attribute, value);
	}

	
	public void setId(Integer id) {
		this.id = id;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(" id: ").append(id);
		sb.append(" attribute: ").append(attribute);
		return sb.toString();
	}

}
