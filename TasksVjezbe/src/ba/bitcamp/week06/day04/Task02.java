package ba.bitcamp.week06.day04;

public class Task02 {
	public static void printEverySecondNumber (int num){
		if(num <= 0){
			return;
		} 
		System.out.println(num);
		printEverySecondNumber(num-2);
	}
	public static void main(String[] args) {
		printEverySecondNumber(10);
	}
}
