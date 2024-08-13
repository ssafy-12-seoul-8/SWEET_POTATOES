import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt(); // 193
			int[] password = new int[N];

			// 원본 패스워드 받기
			for (int i = 0; i < N; i++) {
				password[i] = sc.nextInt();
			}

			int M = sc.nextInt(); // 초록색 숫자 (10~20)

			// 명령문 반복
			for (int i = 0; i < M; i++) {
				String command = sc.next(); // I 버림
				switch (command.charAt(0)) {

				case 'I': {
					int idx = sc.nextInt(); // idx 번호 받음 // 19
					int K = sc.nextInt(); // 길이 K 의 숫자 배열 생성 // 4

					int[] temp = new int[K];
					for (int j = 0; j < K; j++) {
						temp[j] = sc.nextInt();
					}

					for (int j = N - 1; j >= idx + K; j--) {
						// 원래 있던 값을 먼저 옮겨야함. 이건 밀려쓰는 구문이라, 반드시 9번인덱스 까지 시행해야함.
						password[j] = password[j - K]; // answer[6] = answer[1] , answer[7] = answer[2] ...
					}

					for (int j = 0; j < K; j++) {
						// 삽입 구문
						if (idx + j < N)
							password[idx + j] = temp[j]; // password[1] = new Password[0];
					}
				}
					break;
				case 'D': {
					int idx = sc.nextInt();
					int K = sc.nextInt();
					for (int j = idx; j < N-K; j++) {
						password[j] = password[j + K];
					}
				}
					break;
				}
			}

			System.out.print("#" + test_case);
			for (int i = 0; i < 10; i++) {
				System.out.print(" " + password[i]);
			}
			System.out.println();
		}
	}
}
