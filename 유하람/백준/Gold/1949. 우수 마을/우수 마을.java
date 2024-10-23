import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] people;
	static boolean[][] adjArr;
	static int[][] DP;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 마을의 수
		N = Integer.parseInt(br.readLine());
		
		// 마을의 사람 수
		people = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1 ; i<=N ; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 인접 행렬
		adjArr = new boolean[N+1][N+1];
		
		for(int i=0 ; i<N-1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjArr[a][b] = adjArr[b][a] = true;
		}
		
		// 우수마을, 우수마을X
		DP = new int[N+1][2];
		
		DFS(1);
		
		System.out.println(Math.max(DP[1][0], DP[1][1]));
		
		
		
	} // main

	private static void DFS(int curr) {
		DP[curr][0] += people[curr];
		boolean hasChild = false;
		
		for(int i=1 ; i<=N ; i++) {
			if(adjArr[curr][i]) {
				hasChild = true;
				adjArr[i][curr] = false;
				DFS(i);
				// curr 마을이 우수마을인 경우 -> 자식 마을이 우수마을이 아님
				DP[curr][0] += DP[i][1];
				// curr 마을이 우수마을이 아닌 경우 -> 자식 마을이 우수마을이거나 아님
				DP[curr][1] += Math.max(DP[i][0], DP[i][1]);
				
			}
		}
		
		if(!hasChild) {
			// 자식 노드가 없는 경우
			DP[curr][1] = 0;
		}
	}



} // Main class