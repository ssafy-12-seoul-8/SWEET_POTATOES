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
		
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(array);
		
		int[] memory = new int[M];
		boolean[] isUsed = new boolean[N];
		// 첫 번째 파라미터는 깊이
		// 두 번째 파라미터는 상태
		// 세 번째 파라미터는 사용되었는지
		btk(0,memory, isUsed);
		
		System.out.print(sb);
	}

	
	
	static void swap(int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	
	static void btk(int depth, int[] memory, boolean[] isUsed) {
		if (depth == M) {
			for (int i = 0; i < memory.length; i++) {
				sb.append(memory[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (isUsed[i]) continue;
			memory[depth] = array[i];
			isUsed[i] = true;
			btk(depth+1 , memory, isUsed);
			isUsed[i] = false;
		}
	}
}
