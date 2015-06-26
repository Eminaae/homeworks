package ba.bitcamp.week06.day04;

public class Task01 {
	public static void print(String string, int n) {
		if (n == 0) {
			return;
		}
		System.out.println(string);
		print("Cersei", n - 1);
	}

	public static void main(String[] args) {
		print("Cersei", 3);
	}
}
