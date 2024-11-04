import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new int[] { a, b };
		}

		Arrays.sort(arr, (a, b) -> (a[0] - b[0]));
		List<Integer> lst = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int a = arr[i][1];
			if (lst.isEmpty()) {
				lst.add(a);
			} else {
				int start = 0;
				int end = lst.size() - 1;
				if (lst.get(end) < a) {
					lst.add(a);
				} else {
					while (start < end) {
						int mid = (start + end) / 2;
						if (a <= lst.get(mid)) {
							end = mid;
						} else {
							start = mid + 1;
						}
					}
					lst.set(end, a);
				}
			}
		}
		System.out.println(N - lst.size());
	}
}
