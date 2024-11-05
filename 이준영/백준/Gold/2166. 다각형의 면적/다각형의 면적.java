import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		// 신발끈 공식 쓰기위한 배열
		long[][] arr = new long[2][N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[0][i] = Long.parseLong(st.nextToken());
			arr[1][i] = Long.parseLong(st.nextToken());
		}
		
		arr[0][N] = arr[0][0];
		arr[1][N] = arr[1][0];
		
		// 정답 구하기
		long answer = 0;
		for (int i = 0; i < N; i++) {
			answer += arr[0][i] * arr[1][i + 1];
			answer -= arr[0][i + 1] * arr[1][i];
		}
		answer = Math.abs(answer);
		System.out.print(answer / 2);
		if (answer % 2 == 0) {
			System.out.println(".0");
		} else {
			System.out.println(".5");
		}
	}
}
