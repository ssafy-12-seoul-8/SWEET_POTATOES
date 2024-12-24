import java.util.*;
import java.io.*;

public class Main {

	static int[] arr;
	static int[][] memo;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		// 0 : null, X:1, O:2
		memo = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(check(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
		}

		System.out.println(sb);

	} // main

	private static int check(int S, int E) {

		if (memo[S][E] != 0) {
			return memo[S][E] - 1;
		}

		if (S == E) {
			memo[S][E] = 2;
			return 1;
		}
		
		if(E-S==1) {
			if(arr[S]==arr[E]) {
				memo[S][E] = 2;
				return 1;
			}else {
				memo[S][E] = 1;
				return 0;
			}
		}
		
		if(arr[S]==arr[E] && check(S+1,E-1)==1) {
			memo[S][E] = 2;
			return 1;
		}else {
			memo[S][E] = 1;
			return 0;
		}
		
	}
} // Main
