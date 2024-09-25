import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int cnt = 1;
		while (a != b) {
			
			if (b > a && b % 2 == 0) {
				b /= 2;
				cnt++;
			} else if (b > a && b % 10 == 1) {
				b /= 10;
				cnt++;
			} else {
				cnt = -1;
				break;
			}
		}
		System.out.println(cnt);
	}
}