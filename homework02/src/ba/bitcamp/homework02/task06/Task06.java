package ba.bitcamp.homework02.task06;

public class Task06 {
	/**
	 * Creates matrix 3 by 5
	 */
	public static void main(String[] args) {
		int[][] matrix = new int[3][5];

		fillArray(matrix);

		// fills matrix with zeros
		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "	");
			}
			System.out.println();
		}
	}

	private static void fillArray(int[][] matrix) {
		fillArray(matrix, 0, 0, 0);
	}

	/**
	 * Fills row by row with numbers, starting from 0 increased with k
	 * 
	 * @param matrix
	 * @param i
	 * @param j
	 * @param k
	 */
	private static void fillArray(int[][] matrix, int i, int j, int k) {
		if (matrix[i].length - 1 == j) {
			matrix[i][j] = k;
			i++;
			j = 0;
			k++;
		}
		if (matrix.length == i) {
			return;
		}
		matrix[i][j] = k;
		fillArray(matrix, i, j + 1, k + 1);

	}
}

/*
 * for (i = 0; i < matrix.length; i++) { for (j = 0; j < matrix[i].length; j++)
 * { System.out.print(matrix[i][j] + k + "	"); k++; } System.out.println(); }
 */

