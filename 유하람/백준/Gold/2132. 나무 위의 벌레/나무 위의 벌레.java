import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] apples;
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int end; // 가장 먼 정점
	static int max; // 먹을 수 있는 열매의 최대 개수

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 트리의 정점의 개수 N (1<=N<=10,000)
		N = Integer.parseInt(br.readLine());

		// 열매의 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		apples = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			apples[i] = Integer.parseInt(st.nextToken());
		}

		// 간선 연결 정보
		adjList = new LinkedList[N + 1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new LinkedList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}

		// 1번 정점에서 가장 먼 정점(이동중에 먹을 수 있는 열매가 가장 많은) 정점 구하기
		visited = new boolean[N + 1];
		int start = 1;
		end = 1;
		max = 0;
		move(start, 0);

		// 그 정점에서 가장 먼 정점 구하기
		visited = new boolean[N + 1];
		start = end;
		end = 1;
		max = 0;
		move(start, 0);

		System.out.println(max + " " + Math.min(start, end));
	} // main

	private static void move(int n, int sum) {

		visited[n] = true;
		sum += apples[n];

		for (int c : adjList[n]) {
			if (visited[c])
				continue;
			move(c, sum);
		}

		if (max < sum) {
			max = sum;
			end = n;
		} else if (max == sum) {
			end = Math.min(end, n);
		}

	}

} // Main class
