package ba.bitcamp.week06.day04;

public class Task06 {

	public static void main(String[] args) {
		int[] arr = {4, 3, 1};
		int n = 1;
		System.out.println(isInArray(arr,n));
	}

	private static boolean isInArray(int[] array, int n) {
		
		return isInArray(array, n, 0);
	}
	
	private static boolean isInArray(int[] array, int n, int index) {
		if(index == array.length){
			return false;
		} else if (array[index] == n) {
			return true;
		} else {
			return isInArray(array, n, ++ index);
		}
		
	}
	
}
