package ba.bitcamp.week06.day04;

public class Task03 {

	public static void main(String[] args) {
		System.out.println(getSum(3));
	}
	
	public static int getSum(int n){
		if(n == 0){
			return 0;
		}
		return n + getSum(n-1);	
	}
}
