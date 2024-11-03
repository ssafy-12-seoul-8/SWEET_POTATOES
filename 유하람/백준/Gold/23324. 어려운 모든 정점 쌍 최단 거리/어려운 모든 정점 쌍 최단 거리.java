import java.io.*;
import java.util.*;

public class Main {
	
	static long[][] parent;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정점의 개수 N (2<=N<=100000)
		int N = Integer.parseInt(st.nextToken());
		
		//간선의 개수 M (1<=M<=200000)
		int M = Integer.parseInt(st.nextToken());
		
		// 가중치가 1인 K 번째 간선 (1<=K<=M)
		int K  = Integer.parseInt(st.nextToken());
		
		// 가중치가 1인 간선의 정점
		int node1 = 0;
		int node2 = 0;
		
		// 부모 노드 & 같은 집합 안의 노드 개수
		parent = new long[2][N+1];
		
		for(int i=1 ; i<=N ; i++) {
			parent[0][i] = i;
			parent[1][i] = 1;
		}

		for(int i=1 ; i<=M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			if(i==K) {
				node1 = Integer.parseInt(st.nextToken());
				node2 = Integer.parseInt(st.nextToken());
				continue;
			}
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			union(n1,n2);
			
		}
		
//		System.out.println("최종 결과");
//		for(int[] p : parent) {
//			System.out.println(Arrays.toString(p));
//		}
		
		int parent1 = find(node1);
		int parent2 = find(node2);
		
		if(parent1 == parent2) {
			System.out.println(0);
		}else {
			System.out.println(parent[1][parent1]*parent[1][parent2]);
		}
		
		

	} // main

	private static void union(int n1, int n2) {
		
		int p1 = find(n1);
		int p2 = find(n2);
		
		if (p1 < p2) {
            parent[0][p2] = p1;
            parent[1][p1] += parent[1][p2];
        } else if(p1 > p2){
            parent[0][p1] = p2;
            parent[1][p2] += parent[1][p1];
        }
		
//		System.out.println(n1+" , "+n2+" 의 union 결과");
//		for(int[] p : parent) {
//			System.out.println(Arrays.toString(p));
//		}

	}

	private static int find(int n) {
		if(parent[0][n]==n) {
			return n;
		}
		
		return (int) (parent[0][n] = find((int) parent[0][n]));
	}

}
// Main class
