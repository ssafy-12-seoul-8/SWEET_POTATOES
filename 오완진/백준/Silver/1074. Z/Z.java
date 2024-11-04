import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, R, C, cnt;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		cnt = 0;
		search(R, C, (int)Math.pow(2, N));
		System.out.println(cnt);
	}
	
	static void search(int r, int c, int size) {
		
		if (size == 1)
			return;
		
		if (r < size / 2) {
			if (c < size / 2) {		// 2사분면
				search(r, c, size / 2);
			} else {				// 1사분면
				cnt += size * size / 4;
				search(r, c - size / 2, size / 2);
			}
		} else {
			if (c < size / 2) {		// 3사분면
				cnt += (size * size / 4) * 2;
				search(r - size / 2, c, size / 2);
			} else {				// 4사분면
				cnt += (size * size / 4) * 3;
				search(r - size / 2, c - size / 2, size / 2);
			}
		}
	}
}