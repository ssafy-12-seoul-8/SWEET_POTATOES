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

		N = Integer.parseInt(st.nextToken());		// 3
		M = Integer.parseInt(st.nextToken());		// 1
		st = new StringTokenizer(br.readLine());

		array = new int[N];
		
		// 입력받기
		for (int i=0; i<N; i++) {		// 4 5 2
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		int[] state = new int[M];
		btk(0,state);
		System.out.println(sb);
		
	}

	static void btk(int depth, int[] state) {
		
//		System.out.println("btk 호출. depth : " + depth + " state : " + Arrays.toString(state));
		if (depth == M) {
			for (int i=0; i<M; i++) {
				sb.append(state[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		
		for (int i=0; i<N; i++) {
			state[depth] = array[i];
			btk(depth+1, state);
//			state[depth] = 0;
		}
		
		
	}
	
}
