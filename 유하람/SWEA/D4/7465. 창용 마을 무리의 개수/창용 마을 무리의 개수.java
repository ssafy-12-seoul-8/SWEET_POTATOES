
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	static int[] p;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			p = new int[V+1];
			
			for(int i=1 ; i<=V ; i++) {
				p[i] = i;
			}
			
			for(int i=0 ; i<E ; i++) {
				
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				p[findSet(A)] = findSet(B);
				
			}
			
			for(int i=1 ; i<=V ; i++) {
				p[findSet(i)] = findSet(i);
			}
			
			
			Set<Integer> cnt = new HashSet<>();
			
			for(int i=1 ; i<=V ; i++) {
				cnt.add(p[i]);
			}
			
			int answer = cnt.size();
			
			System.out.println("#"+tc+" "+answer);
			
		}
		
		
		
	}

	private static int findSet(int a) {
		if(a != p[a]) {
			p[a] = findSet(p[a]);
		}
		return p[a];
	}

}
