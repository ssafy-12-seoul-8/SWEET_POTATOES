import java.util.Scanner;

public class Solution {

	static int N;
	static int K;
	static int[] arr;
	static int result;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			result = 0;
			// 2개의 자연수
			N = sc.nextInt();
			K = sc.nextInt();
			
			
			arr = new int[N];	// 1 2 1 2
			
			for (int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			combination(0,0);
			
			System.out.println("#" + test_case + " " + result);
			
		}
	}
	
	static void combination(int index, int sum) {
		// 기저 조건
		// 사용하는 숫자가 4개가 초과하면 그만둔다
		
		if (sum == K)  {	// 합에 도달하면 그만둔다.
			result++; 
			return;
		}
		
		if (index == N) {
			return;
		}
		
		
		// index 번째 값을 쓰는 경우
		sum += arr[index];
		combination(index+1, sum);
		
		// index 번째 값을 쓰지 않는 경우
		sum -= arr[index];
		combination(index+1, sum);
		
	}
}
