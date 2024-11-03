import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

	static double[][] stars;
	static int[] parent;
	
	static class Edge implements Comparable<Edge>{
		int node1;
		int node2;
		double length;
		
		public Edge(int n1, int n2, double length) {
			this.node1 = n1;
			this.node2 = n2;
			this.length = length;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.length > o.length) {
				return 1;
			}else {
				return -1;
			}
		}
		
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 별의 개수 n (1<=n<=100)
		int N = Integer.parseInt(br.readLine());

		// 입력 저장
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(br.readLine()+" ");
		}

		StringTokenizer st = new StringTokenizer(sb.toString());

		stars = new double[N][2];

		for (int i = 0; i < N; i++) {
			stars[i][0] = Double.parseDouble(st.nextToken());
			stars[i][1] = Double.parseDouble(st.nextToken());
		}

		// 간선 저장 [정점1, 정점2, 거리]
		List<Edge> edges = new ArrayList<>();
		
		for (int n1 = 0; n1 < N; n1++) {
			for (int n2 = n1+1; n2 < N; n2++) {
				double length = len(n1,n2);
				edges.add(new Edge(n1,n2,length));
			}
		}
		
		Collections.sort(edges);
		
		parent = new int[N];
		for(int i=0 ; i<N ; i++) {
			parent[i] = i;
		}
		
		double answer = 0;
		
		for(Edge edge : edges) {
			if(union(edge.node1,edge.node2)) {
//				System.out.println(edge.node1+"와 "+edge.node2+"를 연결");
//				System.out.println(Arrays.toString(parent));
//				System.out.println("길이는 "+edge.length);
				answer += edge.length;
			}
		}
		
		
		System.out.printf("%.2f",answer);
		
	} // main

	private static boolean union(int node1, int node2) {
		int parent1 = find(node1);
		int parent2 = find(node2);
		
		if(parent1 != parent2) {
			if(parent1 < parent2) {
				parent[parent2] = parent1;
			}else {
				parent[parent1] = parent2;
			}
			return true;
		}
		
		return false;
	}

	private static int find(int node) {

		if(parent[node]==node) {
			return node;
		}
		return parent[node] = find(parent[node]);
	}

	private static double len(int n1, int n2) {
		double lenX = stars[n1][0] - stars[n2][0];
		double lenY = stars[n1][1] - stars[n2][1];
				
		return Math.sqrt(lenX*lenX+lenY*lenY);
	}
	

}
// Main class
