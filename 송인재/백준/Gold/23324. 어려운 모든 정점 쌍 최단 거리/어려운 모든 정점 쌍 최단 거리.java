import java.util.*;
import java.io.*;

public class Main {
	
	static int n, m, k;
	static int[] rep;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		rep = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			rep[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			if (i == k - 1) {
				continue;
			}
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int fromParent = find(from);
			int toParent = find(to);
			
			if (fromParent == toParent) {
				continue;
			}
			
			rep[toParent] = fromParent;
		}
		
		int first = find(1);
		long firstCount = 0;
		
		for (int i = 1; i <= n; i++) {
			if (find(i) == first) {
				firstCount++;
			}
		}
		
		long secondCount = n - firstCount;
		
		System.out.println(firstCount * secondCount);
	}
	
	static int find(int x) {
		if (rep[x] != x) {
			rep[x] = find(rep[x]);
		}
		
		return rep[x];
	}
	
}
