import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 메뉴의 총 개수
		// 1<= N <= 300000
		int N = Integer.parseInt(br.readLine());
		long mod = 1000000007;

		// 각 메뉴의 스코빌 지스
		long[] sco = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			sco[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(sco);

		long answer = 0;
		
		long[] pow = new long[N];
		pow[0] = 1;
		for(int i=1 ; i<N ; i++) {
			pow[i] = pow[i-1]*2%mod;
		}
		

		if (N > 1) {
			for (int i = 0; i < N; i++) {
				long ifMax = sco[i]*(pow[i]-1);
				long ifMin = sco[i]*(pow[N-i-1]-1);
				answer = (answer +ifMax -ifMin+mod)%mod;
			}
		}
		
		answer %= mod;
		
		System.out.println(answer);

	} // main

} // Main class