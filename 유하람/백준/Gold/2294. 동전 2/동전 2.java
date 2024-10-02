import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		// 동전 종류의 개수
		// 1 <= N <= 100 
		int N = sc.nextInt();
		
		// 가치의 합 K
		// 1 <= K <= 10,000
		int K = sc.nextInt();
		
		// 동전의 가치
		int[] coins = new int[N];
		
		int max = 0;
		
		for(int i=0 ; i<N ; i++) {
			coins[i] = sc.nextInt();
			max = Math.max(max, coins[i]);
		}
		
		
		int[] DP = new int[K+1];
		
		
		for(int i=0 ; i<N ; i++) {
			if(coins[i]>K) continue;
			DP[coins[i]] = 1;
		}
		
		for(int i=0 ; i<=K ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(i>coins[j]) {
					if(DP[i-coins[j]]==0) continue;
					if(DP[i]!=0) {
						DP[i] = Math.min(DP[i], DP[i-coins[j]] + 1);
					}else {
						DP[i] = DP[i-coins[j]]+1;
					}
				}
			}
		}
		
//		System.out.println(Arrays.toString(DP));
		
		if(DP[K]==0) DP[K] = -1;
		
		System.out.println(DP[K]);
		
	} // main

} // Main class