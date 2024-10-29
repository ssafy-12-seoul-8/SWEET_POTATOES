import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[][] edges, int[] target) {
        int n = target.length;
		ArrayList<Integer>[] child = new ArrayList[n + 1];
		int[][] possibleNum = new int[n + 1][2]; // 0번 인덱스는 최소, 1번 인덱스는 최대
		int[] dir = new int[n + 1];
		List<Integer> order = new ArrayList<>();
		int[] visited_count = new int[n + 1];
		int count = 0;
		boolean check = true;
		int len = 0;

		for (int i = 1; i <= n; i++) {

			child[i] = new ArrayList<>();
			if (target[i - 1] == 0) {
				possibleNum[i][0] = 0;
			} else {
				possibleNum[i][0] = (target[i - 1] - 1) / 3 + 1;
			}
			possibleNum[i][1] = target[i - 1];

			if (target[i - 1] > 0) {
				count += 1;
			}

		}
//		for (int i = 1; i <= n; i++) {
//			System.out.println(possibleNum[i][0] + " " + possibleNum[i][1]);
//		}
		for (int[] tmp : edges) {
			child[tmp[0]].add(tmp[1]);
		}

		for (int i = 1; i <= n; i++) {
			child[i].sort(null);
		}

		while (true) {
			int start = 1;
			while (!child[start].isEmpty()) {
				int tmp = child[start].get(dir[start]);
				dir[start] = (dir[start] + 1) % child[start].size();
				start = tmp;
			}
			len += 1;
			visited_count[start] += 1;
			order.add(start);
			if (visited_count[start] > possibleNum[start][1]) {
				check = false;
				break;
			}
			if (visited_count[start] == possibleNum[start][0]) {
				count -= 1;
			}
			if (count == 0) {
				break;
			}
		}

		if (!check) {
			return new int[] { -1 };
		}

		int[][] myorder = new int[n + 1][];

		for (int i = 1; i <= n; i++) {
			myorder[i] = change(visited_count[i], target[i - 1]);
		}

		int[] answer = new int[len];

		int[] index = new int[n + 1];

		for (int i = 0; i < len; i++) {
			int tmp = order.get(i);
			answer[i] = myorder[tmp][index[tmp]++];
		}

		return answer;
    }
    public static int[] change(int k, int n) {
		int[] lst = new int[k];
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		if (n == k) {
			count1 = k;
		} else {
			count1 = k - ((n - k - 1) / 2 + 1);
			int tmp1 = n - count1;
			int tmp2 = k - count1;
			count2 = 3 * tmp2 - tmp1;
			count3 = tmp1 - 2 * tmp2;
		}
		for (int i = 0; i < count1; i++) {
			lst[i] = 1;
		}
		for (int i = count1; i < count1 + count2; i++) {
			lst[i] = 2;
		}
		for (int i = count1 + count2; i < k; i++) {
			lst[i] = 3;
		}

		return lst;
	}
}