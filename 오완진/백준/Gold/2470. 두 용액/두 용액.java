import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] liquids = new int[N];
		
		for (int i = 0; i < N; i++)
			liquids[i] = sc.nextInt();
		
		Arrays.sort(liquids);
		
		int L = 0;
		int R = N - 1;
		int minSum = Integer.MAX_VALUE;
		int pickedL = L;
		int pickedR = R;
		
		while (L < R) {
			
			int sum = liquids[L] + liquids[R];
			if (Math.abs(sum) < Math.abs(minSum)) {
				minSum = sum;
				pickedL = L;
				pickedR = R;
			}

			if (sum < 0)
				L++;
			else
				R--;
		}
		
		System.out.println(liquids[pickedL] + " " + liquids[pickedR]);
	}
}