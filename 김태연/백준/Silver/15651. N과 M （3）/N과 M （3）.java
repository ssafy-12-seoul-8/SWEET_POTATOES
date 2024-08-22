import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 개수제한
		M = Integer.parseInt(st.nextToken());	// 개수제한
		arr = new int[M];
		btk(0); // 깊이 0부터

		System.out.println(sb);
	}


	static void btk(int depth) {
	
		// 출력
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
//				System.out.print(arr[i] + " ");
			}
			sb.append("\n");
//			System.out.println();
			return;
		}

		// 한번 호출할때마다 깊게 들어간다.
		for (int i = 1; i <= N; i++) {
			arr[depth] = i;
			btk(depth+1);
		}
	}
}

/*
 *
 * 판단기준
 * 
 * 1번 자리에 1을 넣는다 -> 2번 자리에 1을 넣거나, 2를 넣거나, 3을 넣거나, 4를 넣는다
 * 
 * 1번 자리에 1 -> 2번 자리에 1 -> 3번 자리에 1을 넣거나, 2를 넣거나, 3을 넣거나, 4를 넣는다.
 * 
 * target == M 인 경우 : 4번 자리에 -> 4번 자리는 없으니까 종료한다.
 * 
 * 
 * 중요한것 : 토 -> 일 (이건 되는걸로 알고있는데 확인해봐야함) 금 토 일 (2박3일)
 */
