import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int min_inten = 10000002;
		int low = 0;
		int[] inten = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		Set<Integer> arrived = new HashSet<>();

		ArrayList<int[]>[] road = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			road[i] = new ArrayList<>();
			inten[i] = 10000001;
		}

		for (int i : summits) {
			arrived.add(i);
		}
		for (int[] tmp : paths) {
			int a = tmp[0];
			int b = tmp[1];
			int dis = tmp[2];
			road[a].add(new int[] { b, dis });
			road[b].add(new int[] { a, dis });
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
		for (int i : gates) {
			inten[i] = 0;
			pq.offer(new int[] { i, 0 });
		}

		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();
			int cur = tmp[0];
			int dist = tmp[1];
			if (!visited[cur]) {
				if (arrived.contains(cur)) {
					if (dist < min_inten) {
						min_inten = dist;
						low = cur;
						continue;
					} else if (dist == min_inten) {
						low = Math.min(low, cur);
						continue;
					} else {
						break;
					}
				}
				visited[cur] = true;
				for (int[] tmp2 : road[cur]) {
					int dest = tmp2[0];
					int dist2 = tmp2[1];
					if (!visited[dest] && inten[dest] > Math.max(dist2, dist)) {
						inten[dest] = Math.max(dist, dist2);
						pq.add(new int[] { dest, inten[dest] });
					}
				}
			}
		}
		return new int[] { low, min_inten };

    }
}