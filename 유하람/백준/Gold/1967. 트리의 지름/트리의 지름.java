import java.util.*;
import java.io.*;

public class Main {

	static int N, end, dis;
	static List<int[]>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		adjList = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adjList[a].add(new int[] { b, c });
			adjList[b].add(new int[] { a, c });
		}
		
		visited = new boolean[N+1];
		check(1, 0);

		dis = 0;
		visited = new boolean[N+1];
		check(end, 0);

		System.out.println(dis);

	} // main

	private static void check(int curr, int sum) {
		
		visited[curr] = true;
		
		for (int[] a : adjList[curr]) {
			if(visited[a[0]]) continue;
			check(a[0], sum + a[1]);
		}
		
		if(dis < sum) {
			dis = sum;
			end = curr;
		}
	}

} // Main
