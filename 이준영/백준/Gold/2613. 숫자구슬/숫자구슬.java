import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		num = new int[N];
		st = new StringTokenizer(br.readLine());

		int start = 0;
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if (start < num[i]) {
				start = num[i];
			}
		}

		int end = 30000;

		while (start < end) {
			int mid = (start + end) / 2;
			if (check(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		sb.append(start).append("\n");
		int count = 0;
		int i = 0;
		int sum = 0;
		List<Integer> lst = new ArrayList<>();
		int[] result = new int[M];
		while (i < N) {
			if (sum + num[i] > start) {
				lst.add(count);
				count = 1;
				sum = num[i];
			} else {
				sum += num[i];
				count += 1;
			}
			i++;
		}
		lst.add(count);
		i = 0;
		count = M - lst.size();
		for (int j = 0; j < lst.size(); j++) {
			if (count == 0) {
				result[i++] = lst.get(j);
			} else {
				if (lst.get(j) - 1 <= count) {
					for (int k = 0; k < lst.get(j) ; k++) {
						result[i++] = 1;
						count = count - 1;
					}
					count = count + 1;
				} else {
					for (int k = 0; k < count ; k++) {
						result[i++] = 1;
					}
					result[i++] = lst.get(j) - count;
					count = 0;
				}
			}
		}
		for (int j = 0; j < M; j++) {
			sb.append(result[j]).append(" ");
		}
		System.out.println(sb);

	}

	public static boolean check(int mid) {
		int count = 0;
		int i = 0;
		int sum = 0;
		while (i < N) {
			if (sum + num[i] > mid) {
				count += 1;
				sum = num[i];
			} else {
				sum += num[i];
			}
			i++;
		}
		if (0 < sum) {
			count += 1;
		}
		if (count <= M) {
			return true;
		}
		return false;
	}
}
