import java.util.Scanner;

public class Solution {
	
	static int[] p;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			System.out.print("#"+tc+" ");
			
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			p = new int[V+1];
			
			for(int i=1 ; i<=V ; i++) {
				p[i] = i;
			}
			
			for(int i=0 ; i<E ; i++) {
				
				int oper = sc.nextInt();
				int A = sc.nextInt();
				int B = sc.nextInt();
				
				int pa = findSet(A);
				int pb = findSet(B);
				
				if(oper==0) {
					p[pa] = pb;
				}else {
					
					
					if(p[A]==p[B]) {
						System.out.print(1);
					}else {
						System.out.print(0);
					}
				}
				
			}
			
			System.out.println();
		}
		
		
	}


	private static int findSet(int b) {
		if(b != p[b]) {
			p[b] = findSet(p[b]);
		}
		return p[b];
	}


}
