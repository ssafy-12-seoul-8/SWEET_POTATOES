import java.util.Scanner;

public class Main {
	
	static int N;
	static int[] arr, dp;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N];
		dp = new int[N];
		visited = new boolean[N];
		
		for (int n = 0; n < N; n++) {
			arr[n] = sc.nextInt();
			dp[n] = 1;
		}
		
		for (int n = 0; n < N; n++)
			getDp(n);
		
        int max = 0;
        for (int n = 0; n < N; n++)
            max = Math.max(max, getDp(n));
		
		System.out.println(max);
	}
	
	static int getDp(int x) {
		
		if (visited[x])
			return dp[x];
		
		for (int n = 0; n < x; n++)
			if(arr[n] < arr[x])
				dp[x] = Math.max(dp[x], getDp(n) + 1);
		
		visited[x] = true;
		return dp[x];
	}
}
