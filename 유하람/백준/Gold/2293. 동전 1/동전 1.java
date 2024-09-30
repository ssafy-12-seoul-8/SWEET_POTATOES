import java.util.Arrays;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		// 동전 종류
		int N = sc.nextInt();
		
		// 금액
		int K = sc.nextInt();
		
		int[] money = new int[N];
		for(int i=0 ; i<N ; i++) {
			money[i] = sc.nextInt();
		}

		int[] DP = new int[K+1];
		
		DP[0] = 1;
		
		
		for (int j = 0; j < N; j++) {
			for(int i=money[j] ; i<=K ; i++) {
				DP[i] += DP[i-money[j]];
			}
		}
		
		
		System.out.println(DP[K]);
		
		
		
	} // main

}