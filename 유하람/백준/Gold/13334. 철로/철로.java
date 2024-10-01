import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		// 사람수
		int N = sc.nextInt();

		// 사람들 정보 입력
		List<long[]> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			list.add(new long[] { Math.min(a, b), Math.max(a, b) });
		}

		int d = sc.nextInt();

		Collections.sort(list, new Comparator<long[]>() {

			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[1], o2[1]);
			}
		});

		PriorityQueue<long[]> pq = new PriorityQueue<>(new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[0], o2[0]);
			}
		});

		int answer = 0;

		for (int i = 0; i < N; i++) {
			long[] curr = list.get(i);
			long L = curr[0];
			long R = curr[1];

			if (R - L > d)
				continue;

			pq.add(curr);

			while (!pq.isEmpty() && pq.peek()[0] < R-d) {
				pq.poll();
			}

			answer = Math.max(answer, pq.size());

		}

		System.out.println(answer);

	} // main

} // Main class