import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] array_N = new int[N];
			int[] array_M = new int[M];
			
			for (int i = 0; i < N; i++) {
				array_N[i] = sc.nextInt();
			}
			
			for (int i = 0; i < M; i++) {
				array_M[i] = sc.nextInt();
			}
			
			if (N > M) {
				int temp = N;
				N = M;
				M = temp;
				
				int[] temp_array = array_N;
				array_N = array_M;
				array_M = temp_array;
			}
			
			// logic
			long max = 0;
			
			// idea : 큰 수 - 작은 수 + 1 -> 모든 경우의 수 구할 수 있다.
			for (int j = 0; j < M - N + 1; j++) {
				long num = 0;
				
				for (int i = 0; i < N; i++) {
					num += array_N[i] * array_M[i + j];
				}
				
				if (max <= num) {
					max = num;
				}
			}
			
			System.out.printf("#%d ", test_case);
			System.out.println(max);
		}
	}

}
