import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt(); // 11
			int[] password = new int[N];

			// 원본 패스워드 받기
			for (int i = 0; i < N; i++) {
				password[i] = sc.nextInt();
			}

			int[] answer = new int[10];

			for (int i = 0; i < 10; i++) {
				answer[i] = password[i];
			}

			int M = sc.nextInt(); // 초록색 숫자 (5~M~10)

			//명령문 반복
			for (int i = 0; i < M; i++) {
				sc.next(); // I 버림
				int idx = sc.nextInt(); // idx 번호 받음 // 1
				int K = sc.nextInt(); // 길이 K 의 숫자 배열 생성 // 5

				if (idx < 10) { // 인덱스 번호가 10 이상이면 의미없음.

					int[] temp = new int[K];
					for (int j = 0; j < K; j++) {
						temp[j] = sc.nextInt();
					}
					
					
					for (int j = 9; j>=idx+K; j--) {
						// 원래 있던 값을 먼저 옮겨야함. 이건 밀려쓰는 구문이라, 반드시 9번인덱스 까지 시행해야함.
						answer[j] = answer[j - K];	// answer[6] = answer[1] , answer[7] = answer[2] ... 
					}
					
					for (int j=0; j<K; j++) {
						// 삽입 구문
						if (idx + j < 10) answer[idx + j] = temp[j]; // password[1] = new Password[0];
					}

				} else {
					// idx 가 10 이상이라면 값 다 버림
					for (int j = 0; j < K; j++) {
						sc.nextInt();
					}
				}

			}

			System.out.print("#" + test_case);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + answer[i]);
			}
			System.out.println();
		}
	}
}