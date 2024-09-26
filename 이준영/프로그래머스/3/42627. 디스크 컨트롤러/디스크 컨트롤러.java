import java.util.Arrays;
import java.util.PriorityQueue;
class Solution {
    public static int solution(int[][] jobs) {
        int n = jobs.length;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> compare1(o1, o2));
		Arrays.sort(jobs, (o1, o2) -> compare2(o1,o2));

		int time = 0;
		int arr_index = 0;
		int count = 0;
		int ans = 0;
		while (count < n) {

			while (arr_index < n && time >= jobs[arr_index][0]) {
				pq.offer(jobs[arr_index++]);
			}
			if (pq.isEmpty()) {

				time = jobs[arr_index][0] + jobs[arr_index][1];
				ans = ans + (time - jobs[arr_index][0]);
				arr_index += 1;
				count += 1;

			} else {

				int[] tmp = pq.poll();
				time = time + tmp[1];
				ans = ans + (time - tmp[0]);
				count += 1;
			}
		}
		return ans / n;
    }
	public static int compare1(int[] o1, int[] o2) {
		if (o1[1] == o2[1]) {
			return o1[0] - o2[0];
		}

		return o1[1] - o2[1];
	}
	
	public static int compare2(int[] o1, int[] o2) {
		if(o1[0] == o2[0]) {
			return o1[1] -o2[1]; 
		}
		return o1[0] - o2[0];
	}
}