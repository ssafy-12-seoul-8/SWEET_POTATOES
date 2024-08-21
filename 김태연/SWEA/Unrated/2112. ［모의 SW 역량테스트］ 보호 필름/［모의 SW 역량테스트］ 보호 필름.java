import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	static int D;
	static int W;
	static int K;
	static int[][] arr;
	static boolean isPassed;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			isPassed = false;	// 초기화

			
			String[] secondInput = br.readLine().split(" ");
			D = Integer.parseInt(secondInput[0]); // 두께 6
			W = Integer.parseInt(secondInput[1]); // 가로 8
			K = Integer.parseInt(secondInput[2]); // 합격 3

			arr = new int[D][W];

			for (int i = 0; i < D; i++) {
				String[] line = br.readLine().split(" ");
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(line[j]) + 1; // A 를 1로, B를 2로 바꿔서 저장함 ( 투약하지 않는 경우를 0으로 만들기 위함 ) 
				}
			}

			int chance = 0;

			// 첫 번째 인수는 'n' 번 줄에 어떤 약물을 넣고, 앞으로 몇 번 더 약물을 넣을 수 있는지?
			// 두 번째 인수는 n 번 줄에 '어떤 약물'을 넣고, 앞으로 몇 번 더 약물을 넣을 수 있는지?
			// 세 번째 인수는 n 번 줄에 어떤 약물을 넣고, 앞으로 '몇 번' 더 약물을 넣을 수 있는지?
			
			if (check(arr))
				System.out.println("#" + test_case + " " + chance);
			else {

				while (!isPassed) {					// isPassed = true 가 될 때 까지 실행함
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
	static void dropDrug(int row, int drugType ,int[][] array) {
		for (int j = 0; j < W; j++) {				// 주의 : 투약은 가로로 한다.
			array[row][j] = drugType;
		}
	}

	
	static boolean check(int[][] changedArray) {	// 2차원 배열 전체 검사하기
		int count = 0;
		
		for (int j = 0; j < W; j++) {				// 바깥 for문 : column 변경
			boolean lineChecked = false;
			count = 1; // column 바꿀때마다 count 초기화

			
			for (int i = 1; i < D; i++) {			// 내부 for문 : row 변경
				if (changedArray[i][j] == changedArray[i - 1][j]) {
					count++;
				} else {
					count = 1;
				}
				
				if (count == K) {					// 세로줄에서 count가 K에 도달하면, 즉 테스트를 통과하면 다음 라인으로 바로 넘어간다.
					lineChecked = true;
					break;
				}
			}
			// 세로 한 줄 검사가 끝난 시점, 오른쪽으로 한칸 이동.
			if (!lineChecked)						// 이번 검사가 통과하지 못했다면 바로 false 반환				
				return false;
		}
		isPassed = true;							// 모든 검사가 끝날때까지 return이 일어나지 않았다면, 즉 모든 검사가 통과했다면 true 반환
		return true;
	}

	
	// 'n' 번 줄에 '어떤 약물'을 넣고, 앞으로 '몇 번' 더 약물을 넣을 수 있는지?
	// row : '몇 번재 줄'
	// drugType : '어떤 약물'
	// chance : 약물 투약 가능 횟수(= 남은 횟수)
	// array[][] : 추적하고있는 전체 배열
	static void btk(int row, int drugType, int chance , int[][] array) {

		// 기저조건 1. 남은 횟수가 0이면 검사하고 종료
		if (chance == 0) {
			check(array);
			return;
		}
		
		// 기저조건 2. 이미 통과했다면 종료
		if (isPassed)
			return;
		
		// 기저조건 3. 가능성이 없으면 종료 (남은 줄보다, 남은 약물이 더 많은 경우)
		if (chance > D - row + 1)
			return; 
		
		// 기저조건 4. 범위를 벗어나면 종료
		if (row == D)
			return; 

		
		// 임시 배열 복사 (원복하기 위해서)
		int[] temp = new int[W];
		for (int i=0; i<W; i++) {
			temp[i] = array[row][i];
		}
		
		// 시행 : row 에 약물을 떨어뜨림
		if (drugType != 0) {
			dropDrug(row , drugType, array);
			chance--;
		}
		
		// 추적 1. 다음번에는 약물 안떨어뜨리는 경우 
		btk(row+1, 0, chance, array);

		// 추적 2. 다음번에는 약물 A를 떨어뜨리는 경우 
		btk(row+1, 1, chance, array);
		
		// 추적 3. 다음번에는 약물 B를 떨어뜨리는 경우 
		btk(row+1, 2, chance, array);

		// 원상복귀
		array[row] = temp;
	}
}
