import java.io.*;
import java.util.*;

public class Solution {
	
	static int n, m;
	static int[] rep;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= cases; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			rep = new int[n + 1];
			
			for (int i = 1; i <= n; i++) {
				rep[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				union(x, y);
			}
			
			int count = 0;
			
			for (int i = 1; i <= n; i++) {
				if (rep[i] == i) {
					count++;
				}
			}
			
			System.out.println("#" + t + " " + count);
		}
	}
	
	static int findSet(int x) {
		if (rep[x] != x) {
			rep[x] = findSet(rep[x]);
		}
		
		return rep[x];
	}
	
	static void union(int x, int y) {
		rep[findSet(y)] = findSet(x);
	}

}
