package ba.bitcamp.week06.day04;

import java.util.Arrays;

public class Task08 {

	public static void main(String[] args) {
		int[] arr = new int[10];
		fillArray2(arr, 3);
		System.out.println(Arrays.toString(arr));
	}

	public static void fillArray2(int[] array, int n) {
		array[n] = n;
		fillArray2(array, n - 1, n - 1, true);
		fillArray2(array, n + 1, n - 1, false);
	}

	public static void fillArray2(int[] array, int n, int value, boolean left) {
		if (n == -1) {
			return;
		}

		if (n == array.length) {
			return;
		}

		array[n] = value;

		if (left) {
			fillArray2(array, n - 1, value - 1, true);
		} else {
			fillArray2(array, n + 1, value - 1, false);
		}
	}

}
