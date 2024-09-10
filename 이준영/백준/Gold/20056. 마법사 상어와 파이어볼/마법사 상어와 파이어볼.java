import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Map<Integer, ArrayList<int[]>> map = new HashMap<>();

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			ArrayList<int[]> lst = new ArrayList<>();
			lst.add(new int[] { m, s, d });
			map.put((y - 1) * 50 + (x - 1), lst);

		}
		while (K > 0) {
//			for (int i : map.keySet()) {
//				ArrayList<int[]> lst2 = map.get(i);
//				for(int[] tmp:lst2) {
//					System.out.println(i/50+" "+i%50+" "+tmp[0]+" "+tmp[1]+" "+tmp[2]);
//				}
//			}
//			System.out.println();
			Map<Integer, ArrayList<int[]>> map2 = new HashMap<>();
			for (int i : map.keySet()) {
				ArrayList<int[]> lst2 = map.get(i);
				for (int[] tmp2 : lst2) {
					int y = i / 50;
					int x = i % 50;
					int speed = tmp2[1] % N; // 속도를 N으로 나눈 나머지만 사용
					int ny = (y + speed * dy[tmp2[2]]) % N;
					int nx = (x + speed * dx[tmp2[2]]) % N;
					ny = (ny + N) % N;
					nx = (nx + N) % N;
					if (map2.containsKey(ny * 50 + nx)) {
						ArrayList<int[]> lst = map2.get(ny * 50 + nx);
						lst.add(tmp2);
						map2.put(ny * 50 + nx, lst);
					} else {
						ArrayList<int[]> lst = new ArrayList<>();
						lst.add(tmp2);
						map2.put(ny * 50 + nx, lst);
					}
				}
			}

//			for (int i : map2.keySet()) {
//				ArrayList<int[]> lst2 = map2.get(i);
//				for(int[] tmp:lst2) {
//				System.out.println(i/50+" "+i%50+" "+tmp[0]+" "+tmp[1]+" "+tmp[2]);
//				}
//			}
//			System.out.println();

			map.clear();
			for (int tmp : map2.keySet()) {
				ArrayList<int[]> arr = map2.get(tmp);
				if (arr.size() == 1) {
					map.put(tmp, arr);
					continue;
				}
				int count = 0;
				int sum = 0;
				int check = 0;
				int v = 0;
				int d = 1;
				for (int[] lst : arr) {
					count += 1;
					sum += lst[0];
					v += lst[1];
					if (lst[2] % 2 == 0) {
						check += 1;
					}
				}
				if (sum < 5) {
					continue;
				}
				sum = sum / 5;
				v = v / count;
				if (check == count || check == 0) {
					d = 0;
				}
				ArrayList<int[]> lst = new ArrayList<>();
				for (int i = 0; i < 4; i++) {
					lst.add(new int[] { sum, v, 2 * i + d });
				}
				map.put(tmp, lst);
			}
			K = K - 1;
		}
		int count = 0;
		for (int i : map.keySet()) {
			ArrayList<int[]> lst2 = map.get(i);
			for (int[] tmp : lst2) {
				count = count + tmp[0];
			}
		}
		System.out.println(count);

	}
}
