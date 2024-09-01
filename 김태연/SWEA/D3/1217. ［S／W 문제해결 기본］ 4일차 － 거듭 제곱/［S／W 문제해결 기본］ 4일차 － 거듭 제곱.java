import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int test_case = 1; test_case <= 10; test_case++) {
			sc.nextInt();
			
			int N = sc.nextInt();	// 9
			int M = sc.nextInt();	// 8
			
			// 9의 8제곱
			int result = power(N,M);
			System.out.println("#" + test_case + " " + result);
			
		}
	}
	
	static int power(int N, int M) {
		if (M==1) return N;
		return N * power(N,M-1);
	}
}

