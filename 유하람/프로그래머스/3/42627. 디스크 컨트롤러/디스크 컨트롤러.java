import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        int N = jobs.length;

		int answer = 0;

		Arrays.sort(jobs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(jobs[i]);
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		int currentTime = 0;

        while (!list.isEmpty() || !pq.isEmpty()) {

            // 현재 시간보다 요청 시간이 작은 작업들을 큐에 추가
            while (!list.isEmpty() && list.get(0)[0] <= currentTime) {
                pq.add(list.remove(0));
            }

            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                currentTime += job[1];
                answer += currentTime - job[0];
            } else {
                // 큐가 비어있다면 다음 작업의 요청 시간으로 시간을 이동
                if (!list.isEmpty()) {
                    currentTime = list.get(0)[0];
                }
            }
        }

		answer /= N;

		System.out.println(answer);
        
        return answer;
    }
}