import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int max = Integer.MIN_VALUE;
		int index = 0;
		for (int i=0; i<9; i++) {
			int input = sc.nextInt();
			if (input >= max) {
				max = Math.max(max, input);
				index = i;
			}
		}
		
		System.out.println(max);
		System.out.println(index+1);
	}
}
