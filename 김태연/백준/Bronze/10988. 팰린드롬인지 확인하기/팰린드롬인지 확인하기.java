import java.util.Scanner;

class Main {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		String line = sc.next();
		int result = 1;
		for (int i=0; i<line.length(); i++) {
			if (!(line.charAt(i) == line.charAt(line.length() - i -1))) {
				result = 0;
				break;
			}
		}
		System.out.println(result);
	}
}