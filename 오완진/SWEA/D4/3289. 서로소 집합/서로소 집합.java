import java.util.Scanner;

public class Solution {
	
	static int[] p;
	
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();

			p = new int[N + 1];
			
			for (int n = 1; n <= N; n++)
				makeSet(n);
			
			sb.append("#").append(tc).append(" ");

			for (int m = 0; m < M; m++) {
				int cmd = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				if (cmd == 0) {
					union(x, y);
				} else {
					if (findSet(x) == findSet(y)) sb.append("1");
					else						  sb.append("0");
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
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
		p[findSet(y)] = findSet(x);
	}
}