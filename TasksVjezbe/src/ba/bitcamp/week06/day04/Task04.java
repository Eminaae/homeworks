package ba.bitcamp.week06.day04;

public class Task04 {

	public static void main(String[] args) {
		System.out.println(getFibonacciNumber(3));

	}

	public static int getFibonacciNumber(int number) {
			if ((number == 0) || (number == 1)) // base cases
				return number;
			else
				return getFibonacciNumber(number - 1)
						+ getFibonacciNumber(number - 2);

	}

}
