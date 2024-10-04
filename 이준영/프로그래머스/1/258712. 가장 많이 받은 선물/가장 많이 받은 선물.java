import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

		Map<String, Integer> change = new HashMap<>();
		int len = friends.length;
		int[][] count = new int[len][len];
		int[] score = new int[len];

		for (int i = 0; i < len; i++) {
			change.put(friends[i], i);
		}

		for (int i = 0; i < gifts.length; i++) {
			String[] tmp = gifts[i].split(" ");
			int a = change.get(tmp[0]);
			int b = change.get(tmp[1]);
			count[a][b] += 1;
			score[a] += 1;
			score[b] -= 1;
		}

		for (int i = 0; i < len; i++) {
			int sum = 0;
			for (int j = 0; j < len; j++) {
				if (i == j) {
					continue;
				}
				if (count[i][j] > count[j][i]) {
					sum += 1;
				} else if (count[i][j] == count[j][i] && score[i] > score[j]) {
					sum += 1;
				}
			}
			answer = Math.max(answer, sum);

		}

		return answer;
    }
}