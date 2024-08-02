import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10; // 10

		for (int test_case = 1; test_case <= T; test_case++) {

			test_case = sc.nextInt();

			int[][] array = new int[100][100];

			// array 입력받기
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					array[i][j] = sc.nextInt();
				}
			}

			int max = 0;
			int sum;
			// 행 합 구하기
			for (int r = 0; r < 100; r++) {
				sum = 0;
				for (int c = 0; c < 100; c++) {
					sum += array[r][c];
				}
				max = Math.max(sum, max);
			}

			// 열 합 구하기
			for (int c = 0; c < 100; c++) {
				sum = 0;
				for (int r = 0; r < 100; r++) {
					sum += array[r][c];
				}
				max = Math.max(sum, max);
			}

			// 오른쪽 아래로 가는 대각선 합 구하기

			sum = 0;
			for (int i = 0; i < 100; i++) {

				sum += array[i][i];
			}

			max = Math.max(max, sum);
			
			
			// 왼쪽 아래로 가는 대각선 합 구하기
			
			sum = 0;
			for (int i=0; i<100; i++) {
				sum += array[99-i][i];
			}
			
			max = Math.max(max, sum);
			
			System.out.println("#" + test_case + " " + max);
		}
	}
}