package ba.bitcamp.homework04.homework04.task01;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Task09 extends JFrame {

	private static final long serialVersionUID = -1987958333141206959L;

	private JTextField txtFilePath = new JTextField();
	private JTextArea txtFileContent = new JTextArea(); 
	private String filePath;
	
	public Task09() {
		setLayout(new BorderLayout());
		add(txtFilePath, BorderLayout.SOUTH);
		
		setTitle("IMPORT TEXT FILE");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		txtFilePath.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					try {
						filePath = txtFilePath.getText();
						TextIO.readFile(filePath);
						String text = "";
						while (!TextIO.eof()) {
							text += TextIO.getln() + "\n";
						}
						txtFileContent.setText(text);
						add(txtFileContent, BorderLayout.CENTER);
						System.out.println(text);
						repaint();
					} catch (IllegalArgumentException ex) {
						JOptionPane.showMessageDialog(null, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
			}
		});
		
	}
	
	public static void main(String[] args) {
		new Task09();
	}
}