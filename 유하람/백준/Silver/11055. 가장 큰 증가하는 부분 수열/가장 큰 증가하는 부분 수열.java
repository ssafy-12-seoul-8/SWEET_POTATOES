import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1 ; i<=N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = dp[1] = arr[1];
		
		for(int i=2 ; i<=N; i++) {
			dp[i] = arr[i];
			for(int j=1 ; j<i ; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j]+arr[i], dp[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
		
	} // main

}
