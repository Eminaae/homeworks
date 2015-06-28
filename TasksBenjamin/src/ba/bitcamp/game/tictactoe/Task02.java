package ba.bitcamp.game.tictactoe;

import java.util.Scanner;

// 	Popravite Task01 tako da ne crasha sa slucajevima gdje korisnik unese a+3, ili “”(prazan string).

public class Task02 {

	public static void main(String[] args) {
		// Creating while loop until expression is valid input, “integer
		// operator integer”
		while (true) {
			try {
				Scanner in = new Scanner(System.in);

				System.out.print("Enter expression: ");
				String expression = in.nextLine();
				char operand = '0'; //
				int location = 0;

				// Checking which sing is inputed and the position of sign in
				// string
				if (expression.indexOf('+') != -1) {/*
													 * the index of the first
													 * occurrence of the
													 * character in the
													 * character sequence
													 * represented by this
													 * object, or -1 if the
													 * character does not occur
													 */
					operand = '+';
					location = expression.indexOf('+');
				} else if (expression.indexOf('-') != -1) {
					operand = '-';
					location = expression.indexOf('-');
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

				int num1 = Integer.parseInt(num1String);
				int num2 = Integer.parseInt(num2String);
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
				break; // This is where while loop ends

			} catch (NumberFormatException e) {
				/** Thrown to indicate that the application has attempted to
				convert a string to one of the numeric types*/
				System.out.println("Please enter correct format expression!");
			}

		}
	}

}
