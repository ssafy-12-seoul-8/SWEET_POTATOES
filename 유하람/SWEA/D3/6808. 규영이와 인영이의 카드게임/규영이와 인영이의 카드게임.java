import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    static int win;
	static int lose;
	static int[] A;
	static int[] B;
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		int T = Integer.parseInt(s);
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String s1 = br.readLine();
			StringTokenizer st = new StringTokenizer(s1);
			
			A = new int[9]; // 규영
			B = new int[9]; // 인영
			
			for(int i=0 ; i<9 ; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			int bIdx = 0;
			
			for(int i=1 ; i<=18 ; i++) {
				if(!contains(A,i)) {
					B[bIdx++] = i;
				}
			}
			
			win = 0;
			lose = 0;
			
			int[] result = new int[9];
			boolean[] visited = new boolean[9];
			
			comb(0, result, visited);
					
			System.out.println("#"+tc+" "+win+" "+lose);
			
			
		}
	}
    
    private static void comb(int idx, int[] result, boolean[] visited) {
		
		if(idx==9) {
			game(A, result);
			return;
		}
		
		for(int i=0 ; i<9 ; i++) {
			if(!visited[i]) {
				
				visited[i] = true;
				result[idx] = B[i];
				
				comb(idx+1, result, visited);
				
				visited[i] = false;

			}
		}
	}
    private static void game(int[] A, int[] result) {
		int awin = 0;
		int bwin = 0;
		
		for(int i=0 ; i<9 ; i++) {
			if(A[i] > result[i]) {
				awin += A[i]+result[i];
			}else if(A[i] < result[i]) {
				bwin += A[i] + result[i];
			}
		}
		
		if(awin > bwin) {
			win++;
		}else if(awin < bwin) {
			lose++;
		}
		
	}

	static boolean contains(int[] A, int key) {
		for(int i : A) {
			if(key == i) {
				return true;
			}
		}
		return false;
	}
}