import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			char[][] top = new char[3][3];
			char[][] bottom = new char[3][3];
			char[][] left = new char[3][3];
			char[][] right = new char[3][3];
			char[][] front = new char[3][3];
			char[][] back = new char[3][3];

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					top[i][j] = 'w';
					bottom[i][j] = 'y';
					left[i][j] = 'g';
					right[i][j] = 'b';
					front[i][j] = 'r';
					back[i][j] = 'o';
				}
			}

			st = new StringTokenizer(br.readLine());
			for (int l = 0; l < n; l++) {
				String str = st.nextToken();
				char a = str.charAt(0);
				char b = str.charAt(1);
				char tmp;
				switch (a) {
				case 'U':
					switch (b) {
					case '+':
						for (int i = 0; i < 3; i++) {
							tmp = front[0][i];
							front[0][i] = right[0][i];
							right[0][i] = back[0][i];
							back[0][i] = left[0][i];
							left[0][i] = tmp;
						}
						for (int i = 0; i < 2; i++) {
							tmp = top[0][i];
							top[0][i] = top[2 - i][0];
							top[2 - i][0] = top[2][2 - i];
							top[2][2 - i] = top[i][2];
							top[i][2] = tmp;
						}
						break;
					case '-':
						for (int i = 0; i < 3; i++) {
							tmp = front[0][i];
							front[0][i] = left[0][i];
							left[0][i] = back[0][i];
							back[0][i] = right[0][i];
							right[0][i] = tmp;
						}
						for (int i = 0; i < 2; i++) {
							tmp = top[0][i];
							top[0][i] = top[i][2];
							top[i][2] = top[2][2 - i];
							top[2][2 - i] = top[2-i][0];
							top[2-i][0] = tmp;
						}
						break;
					}
					break;
				case 'D':
					switch (b) {
					case '+':
						for (int i = 0; i < 3; i++) {
							tmp = front[2][i];
							front[2][i] = left[2][i];
							left[2][i] = back[2][i];
							back[2][i] = right[2][i];
							right[2][i] = tmp;
						}
						for (int i = 0; i < 2; i++) {
							tmp = bottom[0][i];
							bottom[0][i] = bottom[2 - i][0];
							bottom[2 - i][0] = bottom[2][2 - i];
							bottom[2][2 - i] = bottom[i][2];
							bottom[i][2] = tmp;
						}
						break;
					case '-':
						for (int i = 0; i < 3; i++) {
							tmp = front[2][i];
							front[2][i] = right[2][i];
							right[2][i] = back[2][i];
							back[2][i] = left[2][i];
							left[2][i] = tmp;
						}
						for (int i = 0; i < 2; i++) {
							tmp = bottom[0][i];
							bottom[0][i] = bottom[i][2];
							bottom[i][2] = bottom[2][2 - i];
							bottom[2][2 - i] = bottom[2-i][0];
							bottom[2-i][0] = tmp;
						}
						break;
					}
					break;

				case 'F':
					switch (b) {
					case '+':
						for (int i = 0; i < 3; i++) {
							tmp = top[2][i];
							top[2][i] = left[2 - i][2];
							left[2 - i][2] = bottom[2][i];
							bottom[2][i] = right[i][0];
							right[i][0] = tmp;
						}
						for (int i = 0; i < 2; i++) {
							tmp = front[0][i];
							front[0][i] = front[2 - i][0];
							front[2 - i][0] = front[2][2 - i];
							front[2][2 - i] = front[i][2];
							front[i][2] = tmp;
						}
						break;
					case '-':
						for (int i = 0; i < 3; i++) {
							tmp = top[2][i];
							top[2][i] = right[i][0];
							right[i][0] = bottom[2][i];
							bottom[2][i] = left[2 - i][2];
							left[2 - i][2] = tmp;
						}
						for (int i = 0; i < 2; i++) {
							tmp = front[0][i];
							front[0][i] = front[i][2];
							front[i][2] = front[2][2 - i];
							front[2][2 - i] = front[2-i][0];
							front[2-i][0] = tmp;
						}
					}
					break;
				case 'B':
					switch (b) {
					case '+':
						for (int i = 0; i < 3; i++) {
							tmp = top[0][i];
							top[0][i] = right[i][2];
							right[i][2] = bottom[0][i];
							bottom[0][i] = left[2 - i][0];
							left[2 - i][0] = tmp;
						}
						for (int i = 0; i < 2; i++) {
							tmp = back[0][i];
							back[0][i] = back[2 - i][0];
							back[2 - i][0] = back[2][2 - i];
							back[2][2 - i] = back[i][2];
							back[i][2] = tmp;
						}
						break;
					case '-':
						for (int i = 0; i < 3; i++) {
							tmp = top[0][i];
							top[0][i] = left[2 - i][0];
							left[2 - i][0] = bottom[0][i];
							bottom[0][i] = right[i][2];
							right[i][2] = tmp;
						}
						for (int i = 0; i < 2; i++) {
							tmp = back[0][i];
							back[0][i] = back[i][2];
							back[i][2] = back[2][2 - i];
							back[2][2 - i] = back[2-i][0];
							back[2-i][0] = tmp;
						}
						break;
					}
					break;
				case 'L':
					switch (b) {
					case '+':
						for (int i = 0; i < 3; i++) {
							tmp = top[i][0];
							top[i][0] = back[2 - i][2];
							back[2 - i][2] = bottom[2 - i][2];
							bottom[2 - i][2] = front[i][0];
							front[i][0] = tmp;
						}
						for (int i = 0; i < 2; i++) {
							tmp = left[0][i];
							left[0][i] = left[2 - i][0];
							left[2 - i][0] = left[2][2 - i];
							left[2][2 - i] = left[i][2];
							left[i][2] = tmp;
						}
						break;
					case '-':
						for (int i = 0; i < 3; i++) {
							tmp = top[i][0];
							top[i][0] = front[i][0];
							front[i][0] = bottom[2 - i][2];
							bottom[2 - i][2] = back[2 - i][2];
							back[2 - i][2] = tmp;
						}
						for (int i = 0; i < 2; i++) {
							tmp = left[0][i];
							left[0][i] = left[i][2];
							left[i][2] = left[2][2 - i];
							left[2][2 - i] = left[2-i][0];
							left[2-i][0] = tmp;
						}
						break;
					}
					break;
				case 'R':
					switch (b) {
					case '+':
						for (int i = 0; i < 3; i++) {
							tmp = top[i][2];
							top[i][2] = front[i][2];
							front[i][2] = bottom[2 - i][0];
							bottom[2 - i][0] = back[2 - i][0];
							back[2 - i][0] = tmp;
						}
						for (int i = 0; i < 2; i++) {
							tmp = right[0][i];
							right[0][i] = right[2 - i][0];
							right[2 - i][0] = right[2][2 - i];
							right[2][2 - i] = right[i][2];
							right[i][2] = tmp;
						}
						break;
					case '-':
						for (int i = 0; i < 3; i++) {
							tmp = top[i][2];
							top[i][2] = back[2 - i][0];
							back[2 - i][0] = bottom[2 - i][0];
							bottom[2 - i][0] = front[i][2];
							front[i][2] = tmp;
						}
						for (int i = 0; i < 2; i++) {
							tmp = right[0][i];
							right[0][i] = right[i][2];
							right[i][2] = right[2][2 - i];
							right[2][2 - i] = right[2-i][0];
							right[2-i][0] = tmp;
						}
						break;
					}
					break;
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					sb.append(top[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
