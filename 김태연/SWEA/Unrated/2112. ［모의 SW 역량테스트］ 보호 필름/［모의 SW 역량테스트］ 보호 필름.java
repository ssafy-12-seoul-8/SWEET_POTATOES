import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

public class Solution {

	static int D;
	static int W;
	static int K;
	static int[][] arr;
	static boolean isPassed;

	public static void main(String[] args) throws IOException {

//		 Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			isPassed = false;
			// 두께 D
			// 가로크기 W
			// 합격기준 K 가 주어진다.
//			 	
//			int D = sc.nextInt();	// 두께 6
//			int W = sc.nextInt();	// 가로 8
//			int K = sc.nextInt();	// 합격 3

			String[] secondInput = br.readLine().split(" ");
			D = Integer.parseInt(secondInput[0]);
			W = Integer.parseInt(secondInput[1]);
			K = Integer.parseInt(secondInput[2]);

			arr = new int[D][W];

			// A : 0, B : 1
			for (int i = 0; i < D; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(line[j]) + 1;
				}
			}

			int chance = 0;

			// 첫 번째 인수는 'n' 번 줄에 어떤 약물을 넣고, 앞으로 몇번 더 약물을 넣을 수 있는지?
			// 두 번째 인수는 n 번 줄에 '어떤 약물'을 넣고, 앞으로 몇번 더 약물을 넣을 수 있는지?
			// 세 번째 인수는 n 번 줄에 어떤 약물을 넣고, 앞으로 '몇번' 더 약물을 넣을 수 있는지?

			// isPassed = true 가 될 때 까지 실행함
			if (check(arr))
				System.out.println("#" + test_case + " " + chance);
			else {

				while (!isPassed) {
					chance++;
					btk(0, 0, chance, arr);
					btk(0, 1, chance, arr);
					btk(0, 2, chance, arr);
				}

				System.out.println("#" + test_case + " " + chance);

			}
		}
	}

	// 투약하는 메서드
	// 주의 : 투약은 가로로 한다.
	static void dropDrug(int row, int drugType ,int[][] array) {
		for (int j = 0; j < W; j++) {
			array[row][j] = drugType;
		}
	}

	// 2차원 배열 전체 검사하기
	static boolean check(int[][] changedArray) {

		int count = 0;
		// 바깥 for문 : column 변경
		for (int j = 0; j < W; j++) {
			boolean lineChecked = false;
			count = 1; // column 바꿀때마다 count 초기화

			// 내부 for문 : row 변경
			for (int i = 1; i < D; i++) {
				if (changedArray[i][j] == changedArray[i - 1][j]) {
					count++;
				} else {
					count = 1;
				}

				// 세로줄에서 count가 K에 도달하면, 즉 테스트를 통과하면 다음 라인으로 바로 넘어간다.
				if (count == K) {
					lineChecked = true;
					break;
				}

			}
			// 한 줄 검사가 끝난 시점.
			// 이번 검사가 통과하지 못했다면 바로 false 반환
			if (!lineChecked)
				return false;
		}

		// 모든 검사가 끝날때까지 return이 일어나지 않았다면, 즉 모든 검사가 통과했다면 true 반환
		isPassed = true;
		return true;
	}

	// 몇번 위치에 약물을 넣을지를 정해보자
	// chance : 몇번이나 약물을 투약할지.
	// array[] : 약물을 투약할 위치를 저장하는 배열
	static void btk(int row, int drugType, int chance , int[][] array) {

		if (chance == 0) {
			check(array);
			return;
		}
		if (isPassed)
			return;
		if (chance > D - row + 1)
			return; // 가능성이 없는 함수 제거
		if (row == D)
			return; // boundary 를 넘어가면 취소한다.

		// row 에 약물을 떨어뜨리는 경우
		int[] temp = new int[W];
		for (int i=0; i<W; i++) {
			temp[i] = array[row][i];
		}
		
		if (drugType != 0) {
			dropDrug(row , drugType, array);
			chance--;
		}
		
		btk(row+1, 0, chance, array);
		btk(row+1, 1, chance, array);
		btk(row+1, 2, chance, array);
		// 원상복귀
		array[row] = temp;
		
	}
}
