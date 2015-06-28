package ba.bitcamp.week06.day04;

public class Task07 {

	public static void main(String[] args) {
		int[] arr1 = { 1, 4, 3, 2, 5 };
		int[] arr2 = { 1, 4, 3, 2, 5 };
		System.out.println(areTheSame(arr1, arr2));
	}

	private static boolean areTheSame(int[] array1, int[] array2) {
		return areTheSame(array1, array2, 0);
	}

	private static boolean areTheSame(int[] array1, int[] array2, int index) {
		if (index == array1.length && index == array2.length) {
			return true;
		} else if (array1[index] == array2[index]) {
			return areTheSame(array1, array2, ++index);
		}
		return false;
	}
}
