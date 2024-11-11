import java.util.*;
import java.io.*;

public class Main {
	
	static int[] parent;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 집의 개수
		int N = Integer.parseInt(st.nextToken());
		
		// 길의 개수
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[2], o2[2]));
		
		// 부모
		parent = new int[N+1];
		
		for(int i=1 ; i<=N ; i++) {
			parent[i] = i;
		}
		
		// 간선
		for(int i=0 ; i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		int sum = 0;
		int max = 0;
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			
			if(union(curr[0],curr[1])) {
				sum += curr[2];
				max = Math.max(max, curr[2]);
			}
			
		}
		
		System.out.println(sum - max);
		
	}

	private static boolean union(int c1, int c2) {
		int p1 = find(c1);
		int p2 = find(c2);
		
		if(p1==p2) return false;
		
		if(p1<p2) {
			parent[p1] = p2;
		}else {
			parent[p2] = p1;
		}
		
		return true;
	}

	private static int find(int c) {
		if(parent[c]==c) return c;
		
		return parent[c] = find(parent[c]);
	}

}
