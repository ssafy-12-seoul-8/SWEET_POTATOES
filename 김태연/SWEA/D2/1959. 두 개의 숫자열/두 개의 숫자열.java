import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] arr = new int[N];
			int[] arr2 = new int[M];

			// 첫 번째 숫자열 받기
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			// 두 번째 숫자열 받기
			for (int i = 0; i < M; i++) {
				arr2[i] = sc.nextInt();
			}

			int[] longArr;
			int[] shortArr;
			if (arr.length > arr2.length) {
				longArr = arr;
				shortArr = arr2;
			} else {
				longArr = arr2;
				shortArr = arr;
			}

			int diff = longArr.length - shortArr.length;

			
			int max = 0;
			for (int i = 0; i <= diff; i++) {
				int sum = 0;
				for (int j = 0; j < shortArr.length; j++) {
					int product = longArr[i+j] * shortArr[j];
					sum += product;
				}
				
				max = Math.max(max, sum);
			}

			System.out.println("#" + test_case + " " + max);
		}
	}
}
