import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
	public int solution(int[][] jobs) {

		// 1. 수행시간이 짧은 작업부터 처리
		// 2. 단, 앞선 작업들이 끝난 후에 처리되도록

		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

		int N = jobs.length;
		int time = 0;
		int idx = 0;
		int sum = 0;
		
		while (idx < N || !pq.isEmpty()) {
			while (idx < N && jobs[idx][0] <= time)
				pq.add(jobs[idx++]);
			
			if (!pq.isEmpty()) {
				int[] job = pq.poll();
				time += job[1];
				sum += time - job[0];
			} else
				time = jobs[idx][0];
		}
		
		return sum / N;
	}
}