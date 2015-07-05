package ba.bitcamp.homework03.task01;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

/**
 * A simple paint panel contains white drawing surface where
 * the user can draw curves and a color palate that the user can click
 * to select the color to be used for drawing.  
 */
public class PanelPaint extends JPanel{
	
	private static final long serialVersionUID = -967432545628855970L;
	public static final int MIN_SIZE = 5;
	public static final int MAX_SIZE = 50;
	public static final int STEP_SIZE = 5;
	private static int activeSize; //current size
	private static boolean pen = true;
	private static boolean brush = false;
	private static PanelPaint panel;
	private static PointArray points = new PointArray(); //the points to draw
	private static Color activeColor; //current active color
	
	
	/**
	 * Constructor for PanelPaint class sets the background color to be
     * white and sets it to listen for mouse events on itself.
	 */
	public PanelPaint() {
		super();
		panel = this;
		
		setBackground(Color.WHITE);
		addMouseMotionListener(new MouseHandler());
		addMouseListener(new MouseHandler());
	}
	
	/**
     * Draw the contents of the panel.  Since no information is
     * saved about what the user has drawn, the user's drawing
     * is erased whenever this routine is called.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); // Fill with background color (white).
		useBrush(g);
		usePen(g);
		
	}
	
	/**
	 * 
	 * @param g
	 */

	private void useBrush(Graphics g){

		int a = 5;
		for (int i = 0; i < PanelPaint.points.getLength(); i++) {
			Point p = PanelPaint.points.elementAt(i);
			if(p.isBrush() && !p.isPen()){
				g.setColor(p.getColor());
				g.fillOval(p.getX(), p.getY(), p.getSize(), p.getSize());	
				a += 5;
			}
		}
	}

	private void usePen(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 0; i < PanelPaint.points.getLength() - 1; i++) {
			Point p1 = PanelPaint.points.elementAt(i);
			Point p2 = PanelPaint.points.elementAt(i+1);
			if(p1.isPen() && !p1.isBrush()){
				g.setColor(p1.getColor());
				g2d.setStroke(new BasicStroke(p1.getSize()));
				g.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());		
			}
		}
	}
	
	
	
	/**
	 * @return the pen
	 */
	public static boolean isPen() {
		return pen;
	}

	/**
	 * @param pen the pen to set
	 */
	public static void setPen(boolean pen) {
		PanelPaint.pen = pen;
	}

	/**
	 * @return the brush
	 */
	public static boolean isBrush() {
		return brush;
	}

	/**
	 * @param brush the brush to set
	 */
	public static void setBrush(boolean brush) {
		PanelPaint.brush = brush;
	}

	/**
	 * @param activeColor the activeColor to set
	 */
	public static void setActiveColor(Color activeColor) {
		PanelPaint.activeColor = activeColor;
	}

	/**
	 * @param activeSize the activeSize to set
	 */
	public static void setActiveSize(int activeSize) {
		PanelPaint.activeSize = activeSize;
	}

	/**
	 * @return the activeColor
	 */
	public static Color getActiveColor() {
		return activeColor;
	}

	/**
	 * @return the activeSize
	 */
	public static int getActiveSize() {
		return activeSize;
	}

	

	private class MouseHandler extends MouseAdapter {

		/**
		 * Called whenever the user moves the mouse while a mouse button is held down.  
		 * If the user is drawing, draw a line segment from the previous mouse location 
		 * to the current mouse location, and set up X and Y for the next call.
		 */
		@Override
		public void mouseDragged(MouseEvent e) {
			Point newPoint = new Point(e.getX(), e.getY(), activeColor, activeSize, pen, brush);
			PanelPaint.points.addPoint(newPoint);
			if(e.isControlDown() == true)
				newPoint.setColor(Color.WHITE);
			repaint(); //ask for the panel to be redrawn
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			super.mouseReleased(e);
			Point newPoint = new Point(e.getX(), e.getY(), activeColor, activeSize, false, false);
			PanelPaint.points.addPoint(newPoint);
			}
	}



	/**
	 * Draws text
	 * @param text
	 * @param x
	 * @param y
	 */
	public static void drawText(String text, int x, int y) {
		points.addPoint(new Point(x, y, activeColor));
		PanelPaint.panel.repaint();
		
	}

	public static void redo() {
		PanelPaint.points.redoArray();
		panel.repaint();
	}

	public static void undo() {
		PanelPaint.points.undoArray();
		panel.repaint();
		
	}
}