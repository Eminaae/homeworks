package ba.bitcamp.game.tictactoe;

import java.util.Scanner;

/**
 * Prepravite kod Task01 tako da string “ 1 + 6 “ (ova prazna mjesta su
razmaci) nece prouzrokovati prestanak rada programa nego ce program raditi kako bi radio
za unos “1+6”
 *
 */
public class Task03 {
	public static void main(String[] args){

	// while loop until expression "integer operand integer" is correct input
		
		while(true){
			try{
				Scanner in = new Scanner(System.in);
				System.out.println("Enter expression: ");
				String expression = in.nextLine();
				char operand = '0';
				int location = 0;
				
				if(expression.indexOf('+') != -1){
					operand = '+';
					location = expression.indexOf('+');
				}else if(expression.indexOf('-')!= -1){
					operand='-';
					location=expression.indexOf('-');
			} else if (expression.indexOf('/') != -1) {
				operand = '/';
				location = expression.indexOf('/');
			} else if (expression.indexOf('*') != -1) {
				operand = '*';
				location = expression.indexOf('*');
			}
			// Creating substrings
			String num1String = expression.substring(0, location);
			// substring to the operand
			String num2String = expression.substring(location + 1,
					expression.length()); 
			// substring from operand to the end

			//removing white spaces using trim() method
			int num1 = Integer.parseInt(num1String.trim());
			int num2 = Integer.parseInt(num2String.trim());
	
			System.out.println(num1);

			switch (operand) {
			case '+':
				System.out.println("Result is: " + (num1 + num2));
				break;
			case '-':
				System.out.println("Result is: " + (num1 - num2));
				break;
			case '/':
				System.out.println("Result is: " + (num1 / num2));
				break;
			case '*':
				System.out.println("Result is: " + (num1 * num2));
				break;
			}
			in.close();
			break; // Loop ends here

		} catch (NumberFormatException e) {
			/** Thrown to indicate that the application has attempted to
			convert a string to one of the numeric types*/
			System.out.println("Please enter correct format expression!");
		}
	}

}
}
