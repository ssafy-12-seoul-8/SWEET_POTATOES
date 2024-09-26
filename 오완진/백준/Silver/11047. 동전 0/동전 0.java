import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] coins = new int[N+1];
		for (int n = 1; n <= N; n++)
			coins[n] = sc.nextInt();
		
		int cnt = 0;
		for (int n = N; n >= 1; n--) {
			if (K >= coins[n])
				while (K >= coins[n]) {
					K -= coins[n];
					cnt++;
				}
		}
		
		System.out.println(cnt);
	}
}