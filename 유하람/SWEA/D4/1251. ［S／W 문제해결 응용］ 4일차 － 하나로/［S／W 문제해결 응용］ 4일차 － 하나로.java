import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		double w;
		
		Edge(int a, int b, double w){
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(Solution.Edge o) {
			return (int) (this.w - o.w);
		}
		
	}
	
	static Edge[] Edges;
	
	static int n;
	static double[] x;
	static double[] y;
	static int idx;
	static int[] p;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String t = br.readLine();
		int T = Integer.parseInt(t);
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String N = br.readLine();
			n = Integer.parseInt(N);
			
			String X = br.readLine();
			StringTokenizer st1 = new StringTokenizer(X);
			String Y = br.readLine();
			StringTokenizer st2 = new StringTokenizer(Y);
			
			x = new double[n];
			y = new double[n];
			
			for(int i=0 ; i<n ; i++) {
				x[i] = Double.parseDouble(st1.nextToken());
				y[i] = Double.parseDouble(st2.nextToken());
			}
			
			String E = br.readLine();
			double e = Double.parseDouble(E);
			
			Edges = new Edge[(n*(n-1))/2];
			idx = 0;
			int[] data = new int[2];
			makeE(data, 0, 0);
			
			Arrays.sort(Edges);
			
			p = new int[n];
			
			for(int i=0 ; i<n ; i++) {
				p[i] = i;
			}
			
			double price = 0;
			int pick = 0;
			
			for(Edge edge : Edges) {
				int pa = find(edge.a);
				int pb = find(edge.b);
				
				if(pa!=pb) {
					p[pa] = pb;
					pick++;
					price += edge.w*e;
				}
				
				if(pick==n-1)
					break;
				
			}
			
			
			sb.append("#").append(tc).append(" ").append(Math.round(price)).append("\n");
			
		}
		
		String ans = sb.toString();
		System.out.println(ans);
		
	}

	private static int find(int b) {
		if(b!=p[b]) {
			return find(p[b]);
		}
		return p[b];
	}

	private static void makeE(int[] data, int level, int sidx) {
		if(level==2) {
			int n1 = data[0];
			int n2 = data[1];
			double w = (x[n1]-x[n2])*(x[n1]-x[n2]) + (y[n1]-y[n2])*(y[n1]-y[n2]);
			Edge tmp = new Edge(n1,n2,w);
			Edges[idx++] = tmp;
			return;
		}
		
		for(int i=sidx ; i<n ; i++) {
			data[level] = i;
			makeE(data, level+1, i+1);
		}
	}

}
