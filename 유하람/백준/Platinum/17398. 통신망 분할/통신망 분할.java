import java.util.*;
import java.io.*;

public class Main {
	
	static int[][] parent;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 정점의 수 N (1 <= N <= 100000)
		int N = Integer.parseInt(st.nextToken());

		// 간선의 수 M (1<= M <= 100000)
		int M = Integer.parseInt(st.nextToken());

		// 분할 횟수 Q (1<= Q <=M)
		int Q = Integer.parseInt(st.nextToken());

		int[][] edges = new int[M+1][2];
		
		for(int i=1 ; i<=M ; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
		}

		Set<Integer> set = new HashSet<>();
		Stack<int[]> stack = new Stack<>();
		
		for(int i=0 ; i<Q ; i++) {
			int tmp = Integer.parseInt(br.readLine());
			set.add(tmp);
			stack.push(edges[tmp]);
		}
		
		// 부모, 같은 통신망 안의 동신탑 수
		parent = new int[N+1][2];
		
		for(int i=1 ; i<=N ; i++) {
			parent[i][0] = i;
			parent[i][1] = 1;
		}
		
		for(int i=1 ; i<=M ; i++) {
			if(set.contains(i)) continue;
			
			union(edges[i][0], edges[i][1]);
		}
		
		long sum = 0;
		
		while(!stack.isEmpty()) {
			int[] curr = stack.pop();
			
			sum += union(curr[0],curr[1]);
		}
		
		System.out.println(sum);
		
		
	} // main

	private static long union(int num1, int num2) {
		int p1 = find(num1);
		int p2 = find(num2);
		
		if(p1==p2) return 0;
		
		long tmp = parent[p1][1]*parent[p2][1];
		
		if(p1>p2) {
			parent[p2][1] += parent[p1][1];
			parent[p1][0] = p2;
		}else {
			parent[p1][1] += parent[p2][1];
			parent[p2][0] = p1;
		}
		
		return tmp;
	}

	private static int find(int num) {
		if(parent[num][0]==num) return num;
		
		return parent[num][0] = find(parent[num][0]);
	}

} // Main
