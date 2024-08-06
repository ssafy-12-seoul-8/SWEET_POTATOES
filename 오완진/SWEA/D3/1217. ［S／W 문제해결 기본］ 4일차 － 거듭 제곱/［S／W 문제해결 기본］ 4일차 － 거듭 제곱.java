import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			
			int T = sc.nextInt();
			
			int M = sc.nextInt();
			int N = sc.nextInt();
			
			int result = zegop(M, N);
			
			System.out.println("#" + t + " " + result);
		}
	}
	        		
	static int zegop (int M, int N) {
		if (N == 0)
			return 1;
		else
			return M * zegop(M, N-1);
	}
}