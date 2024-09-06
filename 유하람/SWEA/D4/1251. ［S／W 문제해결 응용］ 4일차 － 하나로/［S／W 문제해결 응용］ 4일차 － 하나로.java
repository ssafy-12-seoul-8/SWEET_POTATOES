

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static class Node implements Comparable<Node>{
		int idx;
		double length;
		
		public Node(int idx, double length) {
			this.idx = idx;
			this.length = length;
		}

		@Override
		public int compareTo(Node o) {
			return Double.compare(this.length, o.length);
		}

		@Override
		public String toString() {
			return "Node [idx=" + idx + ", length=" + length + "]";
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String t = br.readLine();
		int T = Integer.parseInt(t);
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String n = br.readLine();
			int N = Integer.parseInt(n);
			double[][] lands = new double[N][2];	// 섬의 좌표들 (r,c)
			List<Node>[] plan = new LinkedList[N];	// 섬들의 연결 정보
			
			for(int i=0 ; i<N ; i++) {
				plan[i] = new LinkedList<>();
			}
			
			// 각 섬들의 좌표 입력
			String row = br.readLine();
			StringTokenizer st1 = new StringTokenizer(row);
			String col = br.readLine();
			StringTokenizer st2 = new StringTokenizer(col);
			
			for(int i=0 ; i<N ; i++) {
				lands[i][0] = Double.parseDouble(st1.nextToken());
				lands[i][1] = Double.parseDouble(st2.nextToken());
			}
			
			// 세율 입력
			String e = br.readLine();
			Double E = Double.parseDouble(e);
			
			
			// 각 섬들의 연결 정보 저장
			for(int i=0 ; i<N ; i++) {
				for(int j=0 ; j<N ; j++) {
					if(i==j) continue;
					double len = (lands[i][0] - lands[j][0])*(lands[i][0] - lands[j][0]) + (lands[i][1] - lands[j][1])*(lands[i][1] - lands[j][1]);
					len *= E;
					plan[i].add(new Node(j,len));
				}
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			boolean[] visited = new boolean[N];
			visited[0] =true;
			
			double totalLength = 0;
			int pick = 1;
			
			pq.addAll(plan[0]);
			
			while(pick!=N) {
				Node curr = pq.poll();
				if(visited[curr.idx]) continue;
				visited[curr.idx] = true;
				totalLength += curr.length;
				pick++;
				pq.addAll(plan[curr.idx]);
			}
			
			double answer = Math.round(totalLength);
			long finalAnswer = (long)answer;
			
			sb.append("#").append(tc).append(" ").append(finalAnswer).append("\n");
			
		} // tc
		
		String ans = sb.toString();
		System.out.println(ans);
		
	} // main

}
