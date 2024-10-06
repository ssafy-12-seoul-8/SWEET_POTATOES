import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		// n 가지 종류의 동전.
		// 합이 k원
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] price = new int[N];
		
		for (int i=0; i<N; i++) {
			price[i] = Integer.parseInt(br.readLine());
		}
		
		// System.out.println(Arrays.toString(price));
		// 입력 끝
		
		int[] dp = new int[K+1];
		Arrays.fill(dp, 10001);
		dp[0] = 0;
//		System.out.println("dp[0] : " + dp[0]);
		
		for (int i=0; i<N; i++) {
			// price[0] 이 2이면 j는 2부터
			for (int j=price[i]; j<=K; j++) {
//				System.out.println("j : " + j);
				
				dp[j] = Math.min(dp[j], dp[j-price[i]] + 1);
//				System.out.println("dp[i] : " + dp[i]);
				
			}
		}
		
//		System.out.println(Arrays.toString(dp));
		if (dp[K] == 10001) {
			System.out.println(-1);
		} else {
			System.out.println(dp[K]);
		}
		
	}
}
