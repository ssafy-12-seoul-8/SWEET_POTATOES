import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> min_pq = new PriorityQueue<>();
		PriorityQueue<Integer> max_pq = new PriorityQueue<>((a, b) -> (b - a));

		int N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(br.readLine());
			if (i == 0) {
				max_pq.offer(a);
			} else if (i == 1) {
				int b = max_pq.peek();
				if (b > a) {
					max_pq.poll();
					max_pq.offer(a);
					min_pq.offer(b);
				} else {
					min_pq.offer(a);
				}
			} else {
				int b = max_pq.peek();
				int c = min_pq.peek();
				if (i % 2 == 0) {
					if (c > a) {
						max_pq.offer(a);
					} else {
						min_pq.poll();
						max_pq.offer(c);
						min_pq.offer(a);
					}
				} else {
					if (a > b) {
						min_pq.offer(a);
					} else {
						max_pq.poll();
						min_pq.offer(b);
						max_pq.offer(a);
					}
				}
			}
			sb.append(max_pq.peek()).append("\n");
		}
		System.out.println(sb);
	}
}
