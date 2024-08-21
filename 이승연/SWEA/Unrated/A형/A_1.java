import java.util.Scanner;

public class A_1 {

	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			N = sc.nextInt();
			int[][] down = new int[N][N];
			int[][] right = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					down[c][r] = sc.nextInt();
				}
			}
			
			for (int r = 0; r < N; r++) {
				sort(down[r]);
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					right[c][r] = down[r][c];
				}
			}
			
			for (int r = 0; r < N; r++) {
				sort(right[r]);
			}
			
			System.out.printf("#%d ", test_case);
			
			int rowCount = 0;
			int colCount = 0;
			
			for (int i = 0; i < N; i++) {
				if (right[N - 1][i] == 1) {
					rowCount += 1;
				}
				
				if (right[i][N - 1] == 1) {
					colCount += 1;
				}
			}
			
			System.out.println(rowCount + " " + colCount + " ");
			
		}
		
	}
	
	public static void sort(int[] arr) {
		boolean isDone = false;
		
		int start = arr[0];
		
		if (start == 0) {
			isDone = true;
			return;
		}
		
		int idx = 0;
		int startIndex = 0;
		int length = 1;
		double power = 1;
		
		while(!isDone) {
			for (int i = idx; i < N; i++) {
				// 접근 index 가 범위를 벗어났을 때 return
				if (i + 1 >= N) {
					isDone = true;
					return;
				}
				
				// 0인 경우
				if (arr[i + 1] == 0) {
					// 모든 블럭 1칸씩 이동
					arr[startIndex] = 0;
					
					for (int j = startIndex; j < startIndex + length; j++) {
						arr[j + 1] = 1;
					}
					
					idx += 1;
					startIndex += 1;
					power *= 1.9; // power 추가
					
				// 1인 경우
				} else {
					int block = 0;
					
					for (int j = idx + 1; j < N; j++) {
						if (arr[j] == 1) {
							block++;
						} else {
							break;
						}
					}
					
					// 블럭의 저항을 이겨내지 못했을 때
					if (block >= power) {
						isDone = true;
						return;
					// 블럭의 저항을 이겨냈을 때
					} else {
						idx += block;
						length += block;
						power += block;
					}
				}

			}
		}
	}

}
