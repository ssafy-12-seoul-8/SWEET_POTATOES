import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		int n = 5;
		int[][] paths = { { 1, 3, 10 }, { 1, 4, 20 }, { 2, 3, 4 }, { 2, 4, 6 }, { 3, 5, 20 }, { 4, 5, 6 } };
		int[] gates = { 1, 2 };
		int[] summits = { 5 };

		System.out.println(Arrays.toString(solution(n, paths, gates, summits)));
	}

	public static int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

		int min_inten = 10000002;							// 가장 작은 intensity
		int low = 0;										// 최소 inten을 가진 최소 인덱스
		int[] inten = new int[n + 1];						// inten을 저장할 배열
		boolean[] visited = new boolean[n + 1];
		Set<Integer> arrived = new HashSet<>();				// 도착지 집합

		ArrayList<int[]>[] road = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			road[i] = new ArrayList<>();
			inten[i] = 10000001;							// inten 초기값 설정
		}

		for (int i : summits) {
			arrived.add(i);									// 도착지 추기
		}
		for (int[] tmp : paths) {							// 길 추가
			int a = tmp[0];
			int b = tmp[1];
			int dis = tmp[2];
			road[a].add(new int[] { b, dis });				// 0번은 도착지, 1번은 거리
 			road[b].add(new int[] { a, dis });
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1])); // inten을 기준으로 우선순위큐
		for (int i : gates) {
			inten[i] = 0;									// 시작지에서 시작
			pq.offer(new int[] { i, 0 });
		}

		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();
			int cur = tmp[0];
			int dist = tmp[1];
			if (!visited[cur]) {
				if (arrived.contains(cur)) {				// 만약 도착지에 도착했다면
					if (dist < min_inten) {					// 처음으로 도착했다면 min_inten 초기화 후 계속
						min_inten = dist;					
						low = cur;
						continue;
					} else if (dist == min_inten) {			// 이전에 도착했던 것과 같은 inten이 들어오면 low를 최신화
						low = Math.min(low, cur);
						continue;
					} else {								// 이전보다 크면 그만 돈다.
						break;
					}
				}
				visited[cur] = true;
				for (int[] tmp2 : road[cur]) {
					int dest = tmp2[0];
					int dist2 = tmp2[1];
					if (!visited[dest] && inten[dest] > Math.max(dist2, dist)) { // 아직 가본적이 없고 기존 inten보다 최신화한 값이 작다면 간다.
						inten[dest] = Math.max(dist, dist2);
						pq.add(new int[] { dest, inten[dest] });
					}
				}
			}
		}
		return new int[] { low, min_inten };

	}
}
