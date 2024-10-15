import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] num = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			num[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			num[a].add(b);
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
		int count = 0;
		for (int i = N; i >= 1; i--) {
			if(!num[i].isEmpty()) {
				for(int j:num[i]) {
					pq.offer(j);
				}
			}
			if(!pq.isEmpty()) {
				count += pq.poll();
			}
		}
		
		System.out.println(count);

	}
}
