import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {

			PriorityQueue<Integer> minheap = new PriorityQueue<>();
			PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> b - a);
			int count = 0;
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			sb.append((M + 1) / 2).append("\n");

			for (int i = 0; i < (M - 1) / 10 + 1; i++) {

				st = new StringTokenizer(br.readLine());

				if (i < (M - 1) / 10) {
					for (int j = 0; j < 5; j++) {

						int a = Integer.parseInt(st.nextToken());
						int b = Integer.parseInt(st.nextToken());

						if (minheap.isEmpty()) {
							minheap.offer(a);
						} else {
							int c = maxheap.peek();
							if (c < a) {
								minheap.offer(a);
							} else {
								maxheap.poll();
								maxheap.offer(a);
								minheap.offer(c);
							}
						}
						if (count == 10) {
							sb.append("\n");
							count = 0;
						}
						sb.append(minheap.peek()).append(" ");
						count = count + 1;

						if (maxheap.isEmpty()) {
							int tmp = minheap.peek();
							if (tmp > b) {
								maxheap.offer(b);
							} else {
								minheap.poll();
								minheap.offer(b);
								maxheap.offer(tmp);
							}
						} else {
							int d = minheap.peek();
							if (b < d) {
								maxheap.offer(b);
							} else {
								minheap.poll();
								minheap.offer(b);
								maxheap.offer(d);
							}
						}
					}
				} else {
					for (int j = 0; j < ((M % 10) - 1) / 2; j++) {

						int a = Integer.parseInt(st.nextToken());
						int b = Integer.parseInt(st.nextToken());

						if (minheap.isEmpty()) {
							minheap.offer(a);
						} else {
							int c = maxheap.peek();
							if (c < a) {
								minheap.offer(a);
							} else {
								maxheap.poll();
								maxheap.offer(a);
								minheap.offer(c);
							}
						}

						if (count == 10) {
							sb.append("\n");
							count = 0;
						}

						sb.append(minheap.peek()).append(" ");
						count = count + 1;

						if (maxheap.isEmpty()) {
							int tmp = minheap.peek();
							if (tmp > b) {
								maxheap.offer(b);
							} else {
								minheap.poll();
								minheap.offer(b);
								maxheap.offer(tmp);
							}
						} else {
							int d = minheap.peek();
							if (b < d) {
								maxheap.offer(b);
							} else {
								minheap.poll();
								minheap.offer(b);
								maxheap.offer(d);
							}
						}
					}
					int a = Integer.parseInt(st.nextToken());
					if (minheap.isEmpty()) {
						minheap.offer(a);
					} else {
						int c = maxheap.peek();
						if (c < a) {
							minheap.offer(a);
						} else {
							maxheap.poll();
							maxheap.offer(a);
							minheap.offer(c);
						}
					}
					if (count == 10) {
						sb.append("\n");
						count = 0;
					}
					sb.append(minheap.peek()).append(" ");
					count = count + 1;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
