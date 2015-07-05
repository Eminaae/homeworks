package ba.bitcamp.homework03.task01;

import java.awt.BorderLayout;

import javax.swing.JFrame;
/**
 * The main routine opens a window that displays a drawing area
 * and color palate.  
 *
 */
public class Main extends JFrame{
	
	private static final long serialVersionUID = -3643440059998167908L;
			
	private PanelTools toolsPanel = new PanelTools();		
	private PanelColors colorPanel = new PanelColors();
	private PanelPaint paintPanel = new PanelPaint();
	
	/**
	 * Constructor.
	 */
	public Main() {
		
		setLayout(new BorderLayout());
		add(toolsPanel, BorderLayout.NORTH);
		add(colorPanel, BorderLayout.SOUTH);
		add(paintPanel, BorderLayout.CENTER);
		
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}