import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int N;
	static int[][] arr;
	static List<Integer> A;
	static List<Integer> B;
	static int minDiff;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			minDiff = Integer.MAX_VALUE;
			N = sc.nextInt();		// 4
			arr = new int[N][N];
			
			for (int i = 0; i< N; i++) {
				for (int j = 0; j < N; j ++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			A = new ArrayList<>();
			B = new ArrayList<>();
			
			combination (0,0,0);
			// 반드시 식재료들은 N/2 개씩 나누어야 한다.
			
			System.out.println("#" + test_case + " " + minDiff);
			
		}
	}
	
	static void combination (int index, int sumA, int sumB) {
		
		if (index == N) {
			int diff = Math.abs(sumA - sumB);
			minDiff = Math.min(minDiff, diff);
			return;
		}

		
		if (A.size() < N/2 ) {
			int sum = 0;
			for (int i=0; i < A.size(); i++) {
				sum += arr[index][A.get(i)];
				sum += arr[A.get(i)][index];
				
			}
			A.add(index);
			combination(index+1, sumA + sum, sumB);
			A.remove(A.size() - 1);
			// 초기화?
		}

		if (B.size() < N/2 ) {
			int sum = 0;
			for (int i=0; i < B.size(); i++) {
				sum += arr[index][B.get(i)];
				sum += arr[B.get(i)][index];
				
			}
			B.add(index);
			combination(index+1, sumA, sumB + sum);
			B.remove(B.size() - 1);
			// 초기화?
		}

		
		
	}
}
