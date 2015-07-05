package ba.bitcamp.homework03.task01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * Drawing panel. 
 */
public class PanelColors extends JPanel{

	private static final long serialVersionUID = -5439360046704746121L;
	private static Color[] supportedColors = new Color[]{Color.YELLOW, Color.MAGENTA, Color.RED, Color.ORANGE, Color.BLUE, Color.GREEN};
	private JButton[] colorButton = new JButton[supportedColors.length];
	
	/**
	 * Constructor to set up color components (buttons)
	 */
	public PanelColors() {
		
		PanelPaint.setActiveColor(supportedColors[0]);
		
		for (int i = 0; i < colorButton.length; i++) {
			colorButton[i] = new JButton();
			colorButton[i].setPreferredSize(new Dimension(40, 20));
			colorButton[i].setBorderPainted(true);
			colorButton[i].setBackground(supportedColors[i]);
			colorButton[i].setName(Integer.toString(i));
			colorButton[i].setForeground(supportedColors[i]);
			colorButton[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton clicked = (JButton) e.getSource();
					PanelPaint.setActiveColor(supportedColors[Integer.parseInt(clicked.getName())]);
				}
			});
			
			add(colorButton[i]);
		}
	}
}