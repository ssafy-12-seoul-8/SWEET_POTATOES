import java.io.*;
import java.util.*;

public class Main {

	static int[] childCnt;
	static List<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 트리 정점의 수 N (2 <= N <= 10**5)
		int N = Integer.parseInt(st.nextToken());

		// 루트 노드 R ( 1 <= R <= N )
		int R = Integer.parseInt(st.nextToken());

		// 쿼리의 수 Q (1 <= Q <= 10**5)
		int Q = Integer.parseInt(st.nextToken());

		// 인접리스트
		adjList = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			adjList[n1].add(n2);
			adjList[n2].add(n1);
		}

		childCnt = new int[N + 1];
		visited = new boolean[N+1];

		int node = findChildCnt(R);
		
//		System.out.println("모든 점점 개수 : "+node);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<Q ; i++) {
			sb.append(childCnt[Integer.parseInt(br.readLine())]+"\n");
		}
		
		
		System.out.println(sb); 
		

	} // main

	private static int findChildCnt(int r) {
		// 자기 자신
		childCnt[r] = 1;
		visited[r] = true;
		
		// 자식 순회
		for (int c : adjList[r]) {
			if(visited[c]) continue;
			
			if (childCnt[c] != 0) {
				childCnt[r] += childCnt[c];
			} else {
				childCnt[r] += findChildCnt(c);
			}
		}
		
		return childCnt[r];
	}

}
// Main class
