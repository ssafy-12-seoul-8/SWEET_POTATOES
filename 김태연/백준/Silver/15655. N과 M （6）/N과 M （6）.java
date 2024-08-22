import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	static int[] array;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		array = new int[N];
		
		// 입력받기
		for (int i=0; i<N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		int[] state = new int[M];
		btk(0, 0,state);
		
		System.out.println(sb);
	}
	
	static void btk(int idx, int depth, int[] state) {
		
		if (depth == M) {
			for (int i=0; i<M; i++) {
				sb.append(state[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		if (idx == N) return;
		
		// 숫자를 사용
		state[depth] = array[idx];
		btk(idx+1, depth+1, state);
		
		// 숫자를 사용하지 않는 경우
		state[depth] = 0;
		btk(idx+1, depth, state);	// 이러면 처음꺼랑 완전히 같아지기때문에, 숫자를 입력해야함
		
	}
	
}
