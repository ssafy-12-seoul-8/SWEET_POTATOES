import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] dp = new long[N+1];
		int[] value = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		
		// 입력 끝
//		System.out.println(Arrays.toString(value));
		
		// 연속된 세 계단을 밟을 수는 없다.
		// 즉, (1,2) 로 밟거나 (2,1) 로 밟아야 함.
		
		dp[0] = 0;
		
		for (int i=0; i <= N; i++) {
			// 1칸 전에서 오기 vs 2칸 전에서 오기
			if (i==1) dp[1] = value[1];
			if (i==2) dp[2] = value[1] + value[2];
			if (i>=3) dp[i] = Math.max(dp[i-3] + value[i-1], dp[i-2]) + value[i];
		}
		
		
		System.out.println(dp[N]);
		
		
		
	}
}
