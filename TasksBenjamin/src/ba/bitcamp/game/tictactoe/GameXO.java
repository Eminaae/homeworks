package ba.bitcamp.game.tictactoe;

import java.io.IOException;
import java.util.Scanner;

public class GameXO {
	Scanner in = new Scanner(System.in);

	/**
	 * Makes game board.
	 * 
	 * @param row
	 *            - width dimension
	 * @param column
	 *            - height dimension
	 * @return board
	 */
	public static int[][] gameBoard(int row, int column) {
		int[][] board = new int[row][column];
		return board;
	}

	/**
	 * Displays the board.
	 * 
	 * @param board
	 */
	public static void displayBoard(int[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				System.out.print("[" + board[row][column] + "]" + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Loop through rows and checking if there is any winner.
	 * 
	 * @param an
	 *            array elements
	 * @return true if all elements in an a row are the same.
	 */

	public static boolean checkRows(int[] row) {
		for (int i = 1; i < row.length; i++) {
			if (row[i - 1] != row[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Loop through columns and checking if there is any winner.
	 * 
	 * @param gameBoard
	 * @param column
	 * @return true if all elements in an a column are the same.
	 */
	public static boolean checkColumns(int[][] gameBoard, int column) {
		int firstInColumn = gameBoard[0][column];
		for (int i = 1; i < gameBoard.length; i++) {
			if (firstInColumn != gameBoard[i][column]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Loop through diagonal and checking if there is any winner.
	 * 
	 * @param gameBoard
	 * @return true if all diagonal elements are the same.
	 */
	public static boolean checkDiagonal(int[][] gameBoard) {
		for (int i = 1; i < gameBoard.length; i++) {
			if (gameBoard[i - 1][i - 1] != gameBoard[i][i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Loop through opposite diagonal and checking if there is any winner.
	 * 
	 * @param gameBoard
	 * @return true if all diagonal elements are the same.
	 */
	public static boolean checkOppositeDiagonal(int[][] gameBoard) {
		for (int i = 1; i < gameBoard.length; i++) {
			if (gameBoard[i - 1][gameBoard.length - i] == gameBoard[i][gameBoard.length
					- 1 - i]) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Update board state
	 * 
	 * @param gameBoard
	 * @param counter
	 * @return
	 */
	public static int[][] boardState(int[][] gameBoard, int counter) {
		int rowDim;
		int colDim;
		int turn; // switch between player 1 and 2

		do {
			System.out.print("Enter the row dimension: ");
			rowDim = TextIO.getlnInt();
			while (rowDim < 0 || rowDim >= gameBoard.length) {
				System.out
						.println("Out of bounce. Try again! \nEnter the row dimension again: ");
				rowDim = TextIO.getlnInt();
			}
			System.out.println("Enter the column dimension: ");
			colDim = TextIO.getlnInt();
			while (colDim < 0 || colDim >= gameBoard[rowDim].length) {
				System.out
						.println("\nOut of bounce. Try again!\nOnly the number in the range of 0 and board dimension length is acceptable.");
				colDim = TextIO.getlnInt();
			}
		} while (gameBoard[rowDim][colDim] != 0);
		turn = counter % 2 + 1; // it will be only 1 and 2 ond the board
		gameBoard[rowDim][colDim] = turn; // player places mark on this filed
		return gameBoard;
	}

	/**
	 * Initialize the game-board contents and the current states
	 * 
	 * @param gameBoard
	 * @return
	 */
	public static boolean initGame(int[][] gameBoard) {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				if (gameBoard[i][j] == 0)
					return true;
			}
		}
		return false;
	}

	public static boolean playGame(int[][] board, String[] playerName) {
		int tries = 0;
		while (tries < board.length * board.length) {
			String name = "";
			int player = -1;
			if (tries % 2 == 0) {
				name = playerName[0];
				player = 1;
			} else {
				name = playerName[1];
				player = 2;
			}
			displayBoard(board);
			tries++;
		}
		if (tries == board.length * board.length) {
			return true;
		}
		return false;

	}

	public static void getPlayersNames() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String[] names = new String[2];
		System.out.print("Enter 1st players name: ");
		names[0] = in.next();
		System.out.print("Enter 2nd players name: ");

	}

	// TO DO Calls other methods to check rows, columns and diagonals

	public static void main(String[] args) {

		System.out.println("Enter dimension: ");
		int dimension = TextIO.getlnInt();// Insert board dimensions n by n
		int[][] board = gameBoard(dimension, dimension); // calling gameBoard
		boolean validMove = true;
		int turn = 0;													// function
		displayBoard(board);// calling displayBoard function to display board
	
		do {
			board = boardState(board, turn);
			for (int i = 0; i < board.length; i++) {
				if (checkRows(board[i]) == true && board[i][0] != 0) {
					validMove = false;
				}
			}
			for (int i = 0; i < board[0].length; i++) {
				if (checkColumns(board, i) == true && board[0][i] != 0) {
					validMove = false;
				}
			}
			if (checkDiagonal(board) == true && board[0][0] != 0) {
				validMove = false;
			}
			if (checkOppositeDiagonal(board) == true
					&& board[0][board.length - 1] != 0) {
				validMove = false;
			}
			turn++;
			displayBoard(board);
		} while (initGame(board) == true && validMove == true);
		turn--;

		if (initGame(board) == true || validMove == false) {
			System.out.println("Winner: " + (turn % 2 + 1));
		}
		displayBoard(board);
		System.out.println("Play again!");

	}

}
