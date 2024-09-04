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
			StringBuilder sb = new StringBuilder("#")
					.append(t)
					.append(" ");
			
			for (int i = 1; i <= n; i++) {
				rep[i] = i;
			}
			
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				String command = st.nextToken();
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int aRep = findSet(a);
				int bRep = findSet(b);
				
				switch (command) {
				case "0":
					rep[bRep] = aRep;
					break;
				case "1":
					sb.append(aRep == bRep ? 1 : 0);
					break;
				}
			}
			
			System.out.println(sb);
		}
	}
	
	static int findSet(int x) {
		if (rep[x] != x) {
			rep[x] = findSet(rep[x]);
		}
		
		return rep[x];
	}

}
