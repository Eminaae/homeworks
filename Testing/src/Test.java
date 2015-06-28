
public class Test {

	public static void main(String[] args) {
		char[] charArray ={ 'a', 'b', 'c', 'd', 'e' }; 
			      System.out.println(Character.toString('c'));
			      System.out.println(Character.toString('C'));
			      Character ch = new Character('a');
			      System.out.println(Character.toString(ch));
			      char c = test('x');
			      System.out.println(Character.isLetter(ch));
			      System.out.println(Character.isLetter('5'));
			      String abc = new String(charArray);
			      System.out.println(abc.toString());
			}

	private static char test(char c) {
		
		return c;
	}

}
