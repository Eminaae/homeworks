package ba.bitcamp.week06.day04;

public class RecursionFactoriel {

	public static void main(String[] args) {
		System.out.println(Faktoriel(5));
	}

	
	public static int Faktoriel(int x) {
		if (x == 1) {
			return 1;
		}
		return x * Faktoriel(x - 1);
	}
}
