import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {

				if (o1[1] > o2[1]) {
					return 1;
				} else if (o1[1] < o2[1]) {
					return -1;
				} else {
					if (o1[0] > o2[0]) {
						return 1;
					} else {
						return -1;
					}
				}
			}

		});

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.add(new int[] { i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		int time = 0;
		int wait = 0;

		PriorityQueue<int[]> tmp = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int[] start = pq.poll();
		time = start[1] + start[2];

		while (!pq.isEmpty()) {

			while (!pq.isEmpty() && pq.peek()[1] <= time) {
				tmp.add(pq.poll());
			}
			
			int[] curr;
			
			if (!tmp.isEmpty()) {
				curr = tmp.poll();
			}else {
				curr = pq.poll();
			}
			

			if (time > curr[1]) {
				wait = Math.max(wait, time - curr[1]);
			}

			time = Math.max(time, curr[1]) + curr[2];
		}
		
		while(!tmp.isEmpty()) {
			int[] curr = tmp.poll();
			
			if (time > curr[1]) {
				wait = Math.max(wait, time - curr[1]);
			}

			time = Math.max(time, curr[1]) + curr[2];
		}

		System.out.println(wait);

	} // main

} // Main class
