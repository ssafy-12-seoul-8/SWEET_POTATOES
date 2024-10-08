import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int k = Integer.parseInt(st.nextToken());
		char[] arr = new char[2 * k];			// 접는 방법을 저장
		int[][] arr2 = new int[1 << k][1 << k]; // 최종 종이의 상태를 저장할 배열
		int x_len = k - 1;						// 가로로 접을 수록 가로길이의 변화가 적어진다. 
		int y_len = k - 1;						// 세로로 접을 수록 세로길이의 변화가 적어진다.
		int x = 0;								// 현재 x좌표 
		int y = 0;								// 현재 y좌표

		st = new StringTokenizer(br.readLine());
		
		// 다 접었을 때 남은 종이의 왼쪽위 좌표를 생각해보자
		// 아래로 접으면 y좌표가 2^y_len만큼 증가. y_len 감소
		// 위로 접으면 좌표는 그대로 y_len 감소
		// 왼쪽으로 접으면 좌표는 그대로 x_len 감소
		// 오른쪽으로 접으면 x좌표가 2^x_len만큼 증가 x_len 감소
		
		for (int i = 0; i < 2 * k; i++) {
			arr[i] = st.nextToken().charAt(0);
			switch (arr[i]) {
			case 'D':							// 
				y += (1 << y_len);
				y_len--;
				break;
			case 'U':
				y_len--;
				break;
			case 'R':
				x += (1 << x_len);
				x_len--;
				break;
			case 'L':
				x_len--;
				break;
			}
		}

		st = new StringTokenizer(br.readLine());
		int l = Integer.parseInt(st.nextToken()); // 이제 표시를 하자

		arr2[y][x] = l;
		
		// 펼쳤을 때 가장 왼쪽 x좌표와 오른쪽 x좌표, 가장 위 y좌표와 가장 아래 y좌표를 저장하자.
		int y_start = y;
		int y_end = y;
		int x_start = x;
		int x_end = x;

		// 거꾸로 읽으면서 접은 과정의 역으로 종이를 펼치자
		for (int m = 2 * k - 1; m >= 0; m--) {
			switch (arr[m]) {
			// 아래로 접었었다면 위로 펼칠 차례 
			// y_start를 기준으로 대칭되게 y좌표를 바꾸자
			// 0과 2는 서로 바뀌고, 1과 3이 서로 바뀌며, 위쪽만 채우면 된다.
			case 'D':
				for (int i = 2 * y_start - y_end - 1; i <= y_start - 1; i++) {
					for (int j = x_start; j <= x_end; j++) {
						arr2[i][j] = (2 + arr2[2 * y_start - 1 - i][j]) % 4;
					}
				}
				y_start = 2 * y_start - y_end - 1;
				break;
				
			// 위로 접었다면 아래로 펼칠 차례
			// y_end를 기준으로 대칭되게 y좌표를 바꾸자.
			// 0과 2는 서로 바뀌고, 1과 3이 서로 바뀌며, 아래쪽만 채우면 된다.	
			case 'U':
				for (int i = y_end + 1; i <= 2 * y_end - y_start + 1; i++) {
					for (int j = x_start; j <= x_end; j++) {
						arr2[i][j] = (2 + arr2[2 * y_end + 1 - i][j]) % 4;
					}
				}
				y_end = 2 * y_end - y_start + 1;
				break;
			// 오른쪽으로 접었다면 왼쪽으로 펼칠 차례	
			// x_start를 기준으로 대칭되게 x좌표를 바꾸자.
			// 0과 1이 서로 바뀌고 2와 3이 서로 바뀌며, 왼쪽만 채우면 된다.	 
			case 'R':
				for (int i = y_start; i <= y_end; i++) {
					for (int j = 2 * x_start - x_end - 1; j <= x_start - 1; j++) {
						if (arr2[i][2 * x_start - 1 - j] < 2) {
							arr2[i][j] = 1 - arr2[i][2 * x_start - 1 - j];
						} else {
							arr2[i][j] = 5 - arr2[i][2 * x_start - 1 - j];
						}
					}
				}
				x_start = 2 * x_start - x_end - 1;
				break;
			// 왼쪽으로 접었다면 오른쪽으로 펼칠 차례	
			// x_end를 기준으로 대칭되게 x좌표를 바꾸자
			// 0과 1이 서로 바뀌고 2와 3이 서로 바뀌며, 오른쪽만 채우면 된다.
			case 'L':
				for (int i = y_start; i <= y_end; i++) {
					for (int j = x_end + 1; j <= 2 * x_end - x_start + 1; j++) {
						if (arr2[i][2 * x_end + 1 - j] < 2) {
							arr2[i][j] = 1 - arr2[i][2 * x_end + 1 - j];
						} else {
							arr2[i][j] = 5 - arr2[i][2 * x_end + 1 - j];
						}
					}
				}
				x_end = 2 * x_end - x_start + 1;
				break;
			}
		}
		
		// 출력
		for (int i = 0; i < (1 << k); i++) {
			for (int j = 0; j < (1 << k); j++) {
				System.out.print(arr2[i][j] + " ");
			}
			System.out.println();
		}
	}
}
