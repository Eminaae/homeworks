package ba.bitcamp.game.tictactoe;

import java.util.Scanner;

/**
 * Napisite program koji od korisnika primi unos u vidu stringa. Taj bi
 * izraz(string) trebao biti formata “integer operator integer” , gdje integer
 * predstavlja neki cijeli broj, operator jedan od operatora +, , /, *. Vas
 * program treba da uradi evaluaciju tog izraza i ispise rezultat. Npr za unos
 * 1+3 vas program treba da ispise 4, a za unos 4*5 program treba da ispise 20
 * 
 * @author USER
 *
 */
public class Task01 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter expression: ");
		String expression = in.nextLine();
		char operand = '0'; //
		int location = 0;

		// Checking which sing is inputed and the position of sign in string
		if (expression.indexOf('+') != -1) {/*
											 * the index of the first occurrence
											 * of the character in the character
											 * sequence represented by this
											 * object, or -1 if the character
											 * does not occur
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
		String num1String = expression.substring(0, location); // substring to
																// the operand
		String num2String = expression.substring(location + 1,expression.length()); // substring from operand to the end
		
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
	}

}
