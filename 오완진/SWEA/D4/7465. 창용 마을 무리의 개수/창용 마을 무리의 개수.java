import java.util.Scanner;

public class Solution {
	
	static int[] P;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int M = sc.nextInt();
			P = new int[N + 1];
			
			for (int n = 1; n <= N; n++) {
				makeSet(n);
			}
			
			for (int m = 0; m < M; m++) {
				
                int px = findSet(sc.nextInt());
                int py = findSet(sc.nextInt());
				
				if (px != py) {
					union(px, py);
				}
				
			}
			
			int ans = 0;
            for (int n = 1; n <= N; n++) {
                if (findSet(n) == n) {
                    ans++;
                }
            }

            System.out.println("#" + tc + " " + ans);
        }
		
	}
	
	static void makeSet (int x) {
		P[x] = x;
	}
	
	static int findSet (int x) {
		if (x != P[x])
			P[x] = findSet(P[x]);
		return P[x];
	}
	
	static void union(int x, int y) {
		P[y] = x;
	}
	
}