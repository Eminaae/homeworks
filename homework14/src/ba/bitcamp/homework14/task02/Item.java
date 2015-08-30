package ba.bitcamp.homework14.task02;

/**
 * Item class represents item(product) with unique code number, item name and price.
 * @author emina.a
 *
 */
public class Item {
	
	private Integer code; //unique number for each item
	private String name;
	private Double price;
	
	/**
	 * Item class constructor, construct object product
	 * @param code - unique number for each item
	 * @param name - item name
	 * @param price - item price
	 */
	public Item(Integer code, String name, Double price) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * To string method prints item information
	 */
	public String toString(){
		return String.format("(%d) %s  %.2f BAM", code, name, price);
	}
	

}
