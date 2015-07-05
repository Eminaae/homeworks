package ba.bitcamp.homework04.homework04.task01;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Task01 extends JFrame {

	private static final long serialVersionUID = 1092626499382102168L;
	private JLabel label = new JLabel("text");
	private JSlider slider = new JSlider(0, 100, 0);

	public Task01() {
		setLayout(new BorderLayout());
		add(label, BorderLayout.NORTH);
		add(slider, BorderLayout.SOUTH);

		slider.addChangeListener(new Change());
		label.setHorizontalAlignment(JLabel.CENTER);

		setTitle("Adjustable font size");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public class Change implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			JSlider slider = (JSlider) e.getSource();
			label.setFont(new Font("Serif", Font.ITALIC, slider.getValue()));
		}
	}

	public static void main(String[] args) {
		new Task01();
	}
}
