import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 참가를 원하는 팀의 수
		int N = Integer.parseInt(st.nextToken());
		
		// 후보 디비전의 수
		int Q = Integer.parseInt(st.nextToken());
		
		// 팀의 인기 (누적합)
		long[] arr = new long[N+1];
		
		// 인기의 제곱
		long[] pow = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=1 ; i<=N ; i++) {
			arr[i] = Long.parseLong(st.nextToken());
			pow[i] = arr[i]*arr[i] + pow[i-1];
			arr[i] += arr[i-1];
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0 ; tc<Q ; tc++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			long ans = ((arr[num2] - arr[num1-1])*(arr[num2] - arr[num1-1]) 
					- (pow[num2] - pow[num1-1]))/2;
			
			sb.append(ans+"\n");
		}
		
		System.out.println(sb);
	}

}
