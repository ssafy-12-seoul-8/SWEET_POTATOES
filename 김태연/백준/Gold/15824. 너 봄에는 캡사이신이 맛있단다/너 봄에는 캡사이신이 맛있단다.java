import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] scopil = new long[N];
		
		for (int i=0; i<N; i++) {
			scopil[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(scopil);
		
		// N 번째 숫자라면 최댓값이 되는 경우는 총
		
		// 10이 선택되었을 경우 :
			// 6이 들어가는 경우를 생각해야함 :
			// 6이 들어가는 경우 : 5가 들어가는 경우를 생각해야함
				// (1,6) , (1,4,5) , (4,6),  (1,5,6) , (1,4,5,6) , (4,5,6) , (5,6) , (6)
				// 5가 들어가는 경우 : 4가 들어가는 경우를 생각해야함
					// (1,5)  , (1,4,5) , (4,5) , (5)
					// 4가 들어가는 경우 : 1이 들어가는 경우를 생각해야함.
						// (1,4) , (4)
						// 1이 들어가는 경우 : (1)
		
        // 2의 거듭제곱 값을 미리 계산
        long[] pow = new long[N];
        pow[0] = 1;
        for (int i = 1; i < N; i++) {
            pow[i] = pow[i-1] * 2 % 1000000007;  // 2의 거듭제곱을 미리 계산
        }
		
		long answer = 0;
		
		for (int i=0; i<N; i++) {
			// i번째 원소가 최대값인 경우의 수
//			long max = (long) (scopil[i] * Math.pow(2, i) % 1000000007);
			long max = (long) (scopil[i] * pow[i] % 1000000007);
			// i번째 원소가 최소값인 경우의 수
//			long min = (long) (scopil[i] * Math.pow(2, N-1-i) % 1000000007);
			long min = (long) (scopil[i] * pow[N-1-i] % 1000000007);
			answer = (answer + (max - min + 1000000007) % 1000000007) % 1000000007;  // 음수 방지
		}
		
		System.out.println(answer); 
	}
}
