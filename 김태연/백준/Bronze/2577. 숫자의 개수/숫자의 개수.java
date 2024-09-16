import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		
		String product = Integer.toString(A*B*C);
		for (int i=0; i<=9; i++) {
			int count = 0;

			for (int j=0; j<product.length(); j++) {
				if (product.charAt(j) - '0' == i) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
