import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			String line = br.readLine();
			
			int N = line.length();
			boolean[] memory = new boolean[N];
			
			// 배열 입력받기 : 1일때 true, 0일때 false
			for (int i=0; i<N; i++) {
				int input = line.charAt(i) - '0';
				if (input == 1) memory[i] = true;
			}

			boolean toggle = true;
			int count = 0;
			for (int i=0; i<N; i++) {
				if (memory[i] == toggle) {
					count++;
					toggle = !toggle;
				}
			}
			

			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}

		System.out.println(sb);
	}
}
