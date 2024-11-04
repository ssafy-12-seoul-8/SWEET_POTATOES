import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 수열의 길이 10<= N < 100000
		int N = Integer.parseInt(st.nextToken());

		// 연속된 수들의 합 S 0< S <= 100000000
		Long S = Long.parseLong(st.nextToken());

		// 수열
		long[] arr = new long[N+1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(st.nextToken()) + arr[i - 1];
		}
		
		
		if (arr[N] < S) {
			System.out.println(0);
		}else if(arr[0]>=S) {
			System.out.println(1);
		} else {
			int answer = Integer.MAX_VALUE;
			long sum = 0;
			int start = 0;
			
			for(int end = 0 ; end<=N ; end++) {
				while(arr[end] - arr[start] >= S) {
					answer = Math.min(answer, end - start);
					start++;
				}
			}
			
			System.out.println(answer);

		}

	} // main

} // Main
