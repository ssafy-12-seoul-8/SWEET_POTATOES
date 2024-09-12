import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int year = sc.nextInt();
		
		// 4 의 배수 O
		// !100의 배수
		// 400의 배수
		
		boolean isY = false;
		
		if (year % 4 == 0) {
			if (year % 100 != 0 || year % 400 == 0) {
				isY = true;
			}
		}
		
		int result;
		if (isY) result = 1;
		else result = 0;
		
		System.out.println(result);
	}
}
