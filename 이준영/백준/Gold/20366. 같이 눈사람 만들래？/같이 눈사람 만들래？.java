import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Map<Integer, Integer> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] num = new int[N];
		int count = 0;
		boolean check = false;
		int duplicate = -1;
		map = new HashMap<>();
		Set<Integer> set = new HashSet<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			num[i] = a;
			if (map.containsKey(a)) {
				map.put(a, map.get(a) + 1);
				duplicate = a;
				if (map.get(a) == 2) {
					count += 1;
				}
				if (map.get(a) == 4) {
					check = true;
				}
			} else {
				map.put(a, 1);
				set.add(a);
			}
		}

		if (count >= 2) {
			check = true;
		}

		if (check) {
			System.out.println(0);
		} else {
			Arrays.sort(num);
			ArrayList<Integer> diff = new ArrayList<>();
			Map<Integer, ArrayList<Integer>> map2 = new HashMap<>();
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (map2.containsKey(num[i] + num[j])) {
						ArrayList<Integer> tmp = map2.get(num[i] + num[j]);
						tmp.add(num[i]);
						map2.put(num[i] + num[j], tmp);
					} else {
						ArrayList<Integer> tmp = new ArrayList<>();
						tmp.add(num[i]);
						map2.put(num[i] + num[j], tmp);
						diff.add(num[i] + num[j]);
					}
				}
			}
			diff.sort(null);
			int start = 0;
			int end = 0;
			int min = Integer.MAX_VALUE;
			while (end < diff.size()) {
				ArrayList<Integer> tmp1 = map2.get(diff.get(start));
				ArrayList<Integer> tmp2 = map2.get(diff.get(end));
				boolean total_check = false;

				outer: for (int i : tmp1) {
					for (int j : tmp2) {
						if (check(new int[] { i, diff.get(start) - i }, new int[] { j, diff.get(end) - j })) {
							total_check = true;
							break outer;
						}
					}
				}
				if (total_check) {
					min = Math.min(min, diff.get(end) - diff.get(start));
				}
				if (end == start) {
					end += 1;
				} else {
					start += 1;
				}
			}
			System.out.println(min);
		}
	}

	public static int compare(int[] a, int[] b) {
		if (a[0] == b[0]) {
			return a[1] - b[1];
		}
		return a[0] - b[0];
	}

	public static boolean check(int[] a, int[] b) {
		int[] tmp = { a[0], a[1], b[0], b[1] };
		Map<Integer, Integer> tmp_map = new HashMap<>();
		for (int i : tmp) {
			if (tmp_map.containsKey(i)) {
				tmp_map.put(i, tmp_map.get(i) + 1);
			} else {
				tmp_map.put(i, 1);
			}
		}
		for (int i : tmp_map.keySet()) {
			if (tmp_map.get(i) > map.get(i)) {
				return false;
			}
		}
		return true;
	}
}
