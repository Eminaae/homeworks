package ba.bitcamp.homework03.task01;

import java.awt.Color;


/**
 * Represents a single point to be drawn
 * Contains the point location(x, y), size and color
 *
 */
import java.awt.Color;
/**
 * Represents a single point to be drawn
 * Contains the point location(x, y), size and color
 */
public class Point {

	private int x;
	private int y;
	private Color color;
	private int size;
	private boolean pen;
	private boolean brush;


	/**
	 * Constructor
	 * @param x Coordinate x
	 * @param y Coordinate y
	 * @param color Color of point
	 * @param size Size of a point
	 * @param pen True if drawn by pen
	 * @param brush True if drawn by brush
	 */
	public Point(int x, int y, Color color, int size, boolean pen, boolean brush) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.size = size;
		this.pen = pen;
		this.brush = brush;
	
	}

	/**
	 *@param x Coordinate x
	 * @param y Coordinate y
	 * @param color Color of text
	 * @param text Text to be drawn on given coordinates
	 */
	public Point(int x, int y, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.pen = true;
		this.brush = true;
	
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the pen
	 */
	public boolean isPen() {
		return pen;
	}

	/**
	 * @param pen the pen to set
	 */
	public void setPen(boolean pen) {
		this.pen = pen;
	}

	/**
	 * @return the brush
	 */
	public boolean isBrush() {
		return brush;
	}

	/**
	 * @param brush the brush to set
	 */
	public void setBrush(boolean brush) {
		this.brush = brush;
	}

}