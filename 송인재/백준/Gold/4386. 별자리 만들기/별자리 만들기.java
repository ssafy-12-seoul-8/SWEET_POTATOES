import java.io.*;
import java.util.*;

public class Main {
	
	static class Star {
		float x;
		float y;
		
		Star(float x, float y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge {
		int from;
		int to;
		double weight;
		
		Edge(int from, int to, double weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	static Star[] stars;
	static Edge[] edges;
	static int[] rep;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		stars = new Star[n];
		edges = new Edge[n * (n - 1) / 2];
		rep = new int[n];
		double total = 0;
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			float x = Float.parseFloat(st.nextToken());
			float y = Float.parseFloat(st.nextToken());
			stars[i] = new Star(x, y);
			rep[i] = i;
		}
		
		int index = 0;
		
		for (int i = 0; i < n; i++) {
			Star from = stars[i];
			
			for (int j = i + 1; j < n; j++) {
				Star to = stars[j];
				
				double xSqr = Math.pow(Math.abs(to.x - from.x), 2);
				double ySqr = Math.pow(Math.abs(to.y - from.y), 2);
				double distance = Math.sqrt(xSqr + ySqr);
				edges[index++] = new Edge(i, j, distance);
			}
		}
		
		Arrays.sort(edges, Comparator.comparingDouble(edge -> edge.weight));
		
		for (int i = 0; i < edges.length; i++) {
			Edge edge = edges[i];
			int repFrom = find(edge.from);
			int repTo = find(edge.to);
			
			
			if (repFrom == repTo) {
				continue;
			}
			
			rep[repTo] = repFrom;
			total += edge.weight;
		}
		
		System.out.printf("%.2f", total);
	}
	
	static int find(int x) {
		if (rep[x] != x) {
			rep[x] = find(rep[x]);
		}
		
		return rep[x];
	}
	
}
