import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] price = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		List<Integer>[] road = new ArrayList[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
			road[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {

			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			road[a].add(b);
			road[b].add(a);

		}

		int total_price = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				int min_price = 10001;
				Queue<Integer> queue = new LinkedList<>();
				queue.add(i);
				while(!queue.isEmpty()) {
					int tmp = queue.poll();
					if(!visited[tmp]) {
						visited[tmp] = true;
						min_price = Math.min(min_price,price[tmp]);
						for(int j:road[tmp]) {
							if(!visited[j]) {
								queue.add(j);
							}
						}
					}
				}
				total_price += min_price;
			}
		}
		if(total_price<=k) {
			System.out.println(total_price);
		} else {
			System.out.println("Oh no");
		}
	}
}
