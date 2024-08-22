import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];

		btk(1, 0);

		System.out.println(sb);
	}

	static void btk(int start, int depth) {

		// M에 도착하면 출력
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n"); // 줄 바꿈
			return;
		}

		for (int i = start; i <= N; i++) {
			// 입력하려는 숫자가, 앞에 숫자보다 크거나 같아야 함.
			arr[depth] = i;
			btk(i, depth + 1);
		}

	}
}
