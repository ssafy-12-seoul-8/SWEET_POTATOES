import java.util.Scanner;

public class Solution {
	
	static int cnt;
	static int N;
	static int K;
	static int[] arr;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			N = sc.nextInt();
			K = sc.nextInt();
			
			arr = new int[N];
			for (int n = 0; n < N; n++) {
				arr[n] = sc.nextInt();
			}
			
			cnt = 0;
			bubun(0, 0);
			
			System.out.println("#" + tc + " " + cnt);
		}
		
	}
	
	static void bubun(int idx, int sum) {
		if (sum >= K) {
			if (sum == K) cnt++;
			return;
		}
		
		for (int n = idx; n < N; n++) {
			sum += arr[n];
			bubun(n + 1, sum);
			sum -= arr[n];
		}
	}
	
}