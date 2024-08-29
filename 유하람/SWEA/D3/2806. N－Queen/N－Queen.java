import java.util.Scanner;

class Solution
{
    static int N;
	static int answer;
	static boolean[] checkC;
	static boolean[] checkD;
	static boolean[] checkRD;
    
	public static void main(String args[]) throws Exception
	{

        Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			N = sc.nextInt();
			answer = 0;
			checkC = new boolean[N];		// 0 ~ N
			checkD = new boolean[2*N-1];	// c-r+N-1
			checkRD = new boolean[2*N-1];	// r+c
			
			isPossible(0, 0);			
			
			System.out.println("#"+tc+" "+answer);
			
		}
	}
    private static void isPossible(int r, int cnt) {
		
		if(cnt == N) {
			answer++;
			return;
		}
		
		if(r==N) {
			return;
		}
		
		for(int c=0 ; c<N ; c++) {
			
			if(!checkC[c] && !checkD[c-r+N-1] && !checkRD[r+c]) {
				
				checkC[c] = true;
				checkD[c-r+N-1] = true;
				checkRD[r+c] = true;
				
				isPossible(r+1, cnt+1);
				
				checkC[c] = false;
				checkD[c-r+N-1] = false;
				checkRD[r+c] = false;
				
			}
			
		}
    }
    
}