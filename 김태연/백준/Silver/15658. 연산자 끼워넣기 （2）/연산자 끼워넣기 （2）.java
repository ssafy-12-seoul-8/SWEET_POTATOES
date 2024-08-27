import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] numbers;
	static int[] operations;
	static int N;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {

		// 특이사항
		// 1. 연산자 우선순위를 무시하고, 앞에서부터 진행

		// 2. 나눗셈은 정수 몫으로만 취한다

		// 3. 음수를 양수로 나눌때에는, 양수로 바꾼 뒤 몫을 취하고, 그 몫을 음수로 바꿈.

		// 만들 수 있는 식의 결과가 최대인 것과, 최소인 것을 구함.

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		numbers = new int[N]; // 숫자 넣을 배열 생성
		// 셋째줄에는 덧셈 뺄셈 곱셈 나눗셈의 갯수가 주어짐.
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		operations = new int[4]; // 연산자 담을 배열

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operations[i] = Integer.parseInt(st.nextToken());
		}
		// 입력 끝.

		
		// 초기값 대입
		btk(1, operations, numbers[0]);

		System.out.println(max);
		System.out.println(min);
	}

	static void btk(int numberIdx, int[] operations, int result) {

		// numbers 에서 아무런 수를 가져온다. 수는 최대 11개까지 있다.

		// 만약 현재 인덱스가 numbers[] 배열의 마지막을 초과했다면, 수를 다쓴거니까 출력한다
		if (numberIdx == N) {
//			System.out.println("끝났따");
			min = Math.min(result, min);
			max = Math.max(result, max);
			return;
		}


		
		// 가져올 수 있는 operation 의 종류는 4가지이나, 가져오기 전에 해당 연산자가 남아있는지 꼭 알아야한다.
		if (operations[0] > 0) {

			
			// 만약 +가 존재한다면, +를 선택해볼 수 있고
			operations[0]--;
			result += numbers[numberIdx++];	// result += numbers[1++]	// numberIdx = 2
			btk(numberIdx, operations, result);	// 백트랙킹 돌리고			// (2, +하나빠진 연산자, 더해진결과)
			
			operations[0]++;	// 값을 복귀한다							// + 연산자
			result -= numbers[--numberIdx];								// 2 -> 1 복귀, 결과 이전으로 복귀
		} 
		
		if (operations[1] > 0) {
			
			// -가 존재한다면, -를 선택해볼 수 있다.
			operations[1]--;
			
			result -= numbers[numberIdx++];
			btk(numberIdx, operations, result);
			
			operations[1]++;
			result += numbers[--numberIdx];
		} 
		
		if (operations[2] > 0) {
			
			operations[2]--;
			result *= numbers[numberIdx++];
			btk(numberIdx, operations, result);
			
			operations[2]++;
			result /= numbers[--numberIdx];
		} 
		
		if (operations[3] > 0) {
			operations[3]--;
			result /= numbers[numberIdx++];
			btk(numberIdx, operations, result);
			operations[3]++;
			result *= numbers[--numberIdx];
		} 
		

	}

}
