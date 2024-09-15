import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		String ans = "NO";

		Map<Integer, int[]> map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		outer: for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int a = arr[i] + arr[j];
				if (!map.containsKey(w - a)) {
					map.put(a, new int[] { i, j });
				} else {
					int[] tmp = map.get(w - a);
					int c = tmp[0];
					int d = tmp[1];
					if (i == c || i == d || j == c || j == d) {
						continue;
					} else {
//						System.out.println(i + " " + j + " " + c + " " + d);
						ans = "YES";
						break outer;
					}
				}
			}
		}

		System.out.println(ans);

	}
}
