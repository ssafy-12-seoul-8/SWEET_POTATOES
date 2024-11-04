import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int n, int[][] edge) {
       int answer = 0;
		int count = 0;
		boolean[] visited = new boolean[n + 1];
		ArrayList<Integer>[] roads = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			roads[i] = new ArrayList<>();
		}

		for (int[] tmp : edge) {
			int a = tmp[0];
			int b = tmp[1];
			roads[a].add(b);
			roads[b].add(a);
		}

		Queue<Integer> queue = new LinkedList<>();

		visited[1] = true;
		queue.offer(1);

		while (!queue.isEmpty()) {
			count = answer;
			answer = 0;
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				int tmp = queue.poll();
				for (int j : roads[tmp]) {
					if (!visited[j]) {
						visited[j] = true;
						queue.offer(j);
						answer +=1;
					}
				}
				
			}
			
		}
		return count;
    }
}