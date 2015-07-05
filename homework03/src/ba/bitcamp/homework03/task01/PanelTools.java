package ba.bitcamp.homework03.task01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Panel containing tools to draw.
 *
 */
public class PanelTools extends JPanel {

	private static final long serialVersionUID = 2474028279626979307L;

	private JButton pointPlus = new JButton("+");
	private JButton pointMinus = new JButton("-");
	private JButton pen = new JButton("Pen");
	private JButton brush = new JButton("Brush");
	private JButton undo = new JButton("Undo");
	private JButton btnRedo = new JButton("Redo");
	private JButton btnText = new JButton("Text");

	/**
	 * Default constructor.
	 */
	public PanelTools() {

		PanelPaint.setActiveSize(PanelPaint.MIN_SIZE);

		pointMinus.addActionListener(new Action());
		pointPlus.addActionListener(new Action());
		pen.addActionListener(new Action());
		brush.addActionListener(new Action());
		undo.addActionListener(new Action());
		btnRedo.addActionListener(new Action());
		btnText.addActionListener(new Action());

		add(pointMinus);
		add(pointPlus);
		add(pen);
		add(brush);
		add(undo);
		add(btnRedo);
		add(btnText);
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == pointMinus
					&& PanelPaint.getActiveSize() > PanelPaint.MIN_SIZE) {
				PanelPaint.setActiveSize(PanelPaint.getActiveSize()
						- PanelPaint.STEP_SIZE);
			} else if (e.getSource() == pointPlus
					&& PanelPaint.getActiveSize() < PanelPaint.MAX_SIZE) {
				PanelPaint.setActiveSize(PanelPaint.getActiveSize()
						+ PanelPaint.STEP_SIZE);
			} else if (e.getSource() == pen) {
				PanelPaint.setBrush(false);
				PanelPaint.setPen(true);
			} else if (e.getSource() == brush) {
				PanelPaint.setBrush(true);
				PanelPaint.setPen(false);
			} else if (e.getSource() == undo) {
				PanelPaint.undo();
			} else if (e.getSource() == btnRedo) {
				PanelPaint.redo();
			} else if (e.getSource() == btnText) {
				String text = JOptionPane.showInputDialog(null, "Input text");
				String coordinates = JOptionPane
						.showInputDialog("Input coordinates");
				int x = Integer.parseInt(coordinates.substring(0,
						coordinates.indexOf(',')));
				int y = Integer.parseInt(coordinates.substring(coordinates
						.indexOf(',') + 1));
				PanelPaint.drawText(text, x, y);
				JOptionPane.showMessageDialog(null, "Invalid dimensions");
			}
		}
	}
}
