import java.util.Scanner;

public class Main {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);

		// 고유번호가 0 4 2 5 6 이면 각 숫자를 제곱한다
		
		
		int sum = 0;
		
		for (int i=0; i<5; i++) {
			int input = sc.nextInt();
			sum += Math.pow(input, 2);
		}
		
		int result = sum % 10;

		System.out.println(result);
		

	}
}
