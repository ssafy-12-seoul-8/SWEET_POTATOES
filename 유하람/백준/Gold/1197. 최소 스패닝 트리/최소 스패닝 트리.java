import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
	
	static int[] parent;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 정점의 개수, 간선의 개수 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<int[]> list = new ArrayList<>();
		
		// 간선의 정보 입력
		for(int i=0 ; i<E ; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		// 가중치 순으로 정렬
		Collections.sort(list,(o1,o2)->Integer.compare(o1[2],o2[2]));
		
		// 부모 노드
		parent = new int[V+1];
		
		for(int i=1 ; i<=V ; i++) {
			parent[i] = i;
		}
		
		// 가중치 합
		int total = 0;
		
		for(int[] node : list) {
			if(union(node[0],node[1])) {
				total += node[2];
			}
		}
		
		System.out.println(total);
		
	} // main

	private static boolean union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1==p2) return false;
		
		if(p1>p2) {
			parent[p1] = p2;
		}else {
			parent[p2] = p1;
		}
		
		return true;
	}

	private static int find(int n1) {
		if(parent[n1]==n1) {
			return n1;
		}
		
		return parent[n1] = find(parent[n1]);
	}


}
// Main class
