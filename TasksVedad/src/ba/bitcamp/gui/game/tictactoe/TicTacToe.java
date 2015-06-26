package ba.bitcamp.gui.game.tictactoe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTacToe extends JPanel{

	private static final long serialVersionUID = -7776624395055770439L;
	JButton buttons[] = new JButton[9]; 
    int counter = 0;//if this number is even, put X, otherwise put O
    
    /**
     * Constructor
     */
    public TicTacToe() {
      setLayout(new GridLayout(3,3));
      initializeButtons(); 
    }
    
    public void initializeButtons(){
        for(int i = 0; i <= 8; i++){
            buttons[i] = new JButton();
            buttons[i].setText("");
            buttons[i].addActionListener(new buttonListener());
            add(buttons[i]);         
        }
    }
    
    public void resetButtons(){
        for(int i = 0; i <= 8; i++){
            buttons[i].setText("");
        }
    }
    
    /* when a button is clicked, it generates an ActionEvent. That means each button needs an ActionListener.
     *  When it is clicked, it goes to this listener class.*/
    
    private class buttonListener implements ActionListener{
    
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton)e.getSource(); //gets the particular button that was clicked
            if(counter %2 == 0)
                buttonClicked.setText("X");
            else
                buttonClicked.setText("O");    
            counter++;
        }  
    }
    
    public static void main(String[] args) {
        JFrame window = new JFrame("Tic-Tac-Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new TicTacToe());
        window.setBounds(300,300,300,300);
        window.setVisible(true);
    }
}