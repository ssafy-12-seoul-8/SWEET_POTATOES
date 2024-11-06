import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] p;
	static double answer;
	static double[][] stars;
	static List<double[]> edges;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		stars = new double[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i][0] = Double.parseDouble(st.nextToken());
			stars[i][1] = Double.parseDouble(st.nextToken());
		}
		
		p = new int[N];
		for (int i = 0; i < N; i++)
			makeSet(i);
		
		edges = new ArrayList<>();
		for (int i = 0; i < N; i++)
			for (int j = i + 1; j < N; j++)
				edges.add(new double[] {i, j, getDistance(i, j)});
		
		Collections.sort(edges, (a, b) -> Double.compare(a[2], b[2]));
		
		answer = 0;
		
		for (double[] edge : edges) {
			int rootX = findSet((int) edge[0]);
			int rootY = findSet((int) edge[1]);
			
			if (rootX != rootY) {
				union(rootX, rootY);
				answer += edge[2];
			}
		}
		
		System.out.printf("%.2f", answer);
	}
	
	static double getDistance(int i, int j) {
		double dx = stars[i][0] - stars[j][0];
		double dy = stars[i][1] - stars[j][1];
		
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	static void makeSet(int x) {
		p[x] = x;
	}
	
	static int findSet(int x) {
		if (x != p[x])
			p[x] = findSet(p[x]);
		
		return p[x];
	}
	
	static void union(int x, int y) {
		int rootX = findSet(x);
		int rootY = findSet(y);
		
		if (rootX != rootY)
			p[rootY] = rootX;
	}
}