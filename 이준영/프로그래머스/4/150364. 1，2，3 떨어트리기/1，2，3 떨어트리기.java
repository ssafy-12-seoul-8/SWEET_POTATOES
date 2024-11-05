import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void main(String[] args) {
		int[][] edges = { { 2, 4 }, { 1, 2 }, { 6, 8 }, { 1, 3 }, { 5, 7 }, { 2, 5 }, { 3, 6 }, { 6, 10 }, { 6, 9 } };
		int[] target = { 0, 0, 0, 3, 0, 0, 5, 1, 2, 3 };
		System.out.println(Arrays.toString(solution(edges, target)));
	}

	public static int[] solution(int[][] edges, int[] target) {

		int n = target.length;
		ArrayList<Integer>[] child = new ArrayList[n + 1];
		int[][] possibleNum = new int[n + 1][2]; // 0번 인덱스는 최소, 1번 인덱스는 최대 허용 횟수
		int[] dir = new int[n + 1];				 // 각 노드가 몇 번을 현재 가리키고 있는지
		List<Integer> order = new ArrayList<>(); // 떨어지는 순서를 저장할 리스트
		int[] visited_count = new int[n + 1];	 // 각 노드가 지금까지 몇 번 방문되었는가
		int count = 0;							 // 조건을 만족해야 하는 노드의 개수 (방문횟수가 최소미만인 노드 개수)
		boolean check = true;					 // 떨어뜨리는게 가능한가?
		int len = 0;							 // 떨어뜨리는게 가능할 때 최소 길이

		for (int i = 1; i <= n; i++) {

			child[i] = new ArrayList<>();		 // 자식 노드 저장 리스트
			
			if (target[i - 1] == 0) {			 // 가능한 최소 횟수 저장
				possibleNum[i][0] = 0;
			} else {
				possibleNum[i][0] = (target[i - 1] - 1) / 3 + 1;
			}
			
			possibleNum[i][1] = target[i - 1];	 // 가능한 최대 횟수

			if (target[i - 1] > 0) {			 // 0보다 크면 아직 더 돌아야 됨 - count에 추가
				count += 1;
			}

		}

		for (int[] tmp : edges) {
			child[tmp[0]].add(tmp[1]);
		}

		for (int i = 1; i <= n; i++) {
			child[i].sort(null);				 // 각 노드의 자식들을 크기 순으로 배열
		}

		while (true) {
				
			int start = 1;						 // 루트노드가 1
			while (!child[start].isEmpty()) {    // 리프노드가 아니라면 가고 나서 방향을 바꿔준다.
				int tmp = child[start].get(dir[start]);
				dir[start] = (dir[start] + 1) % child[start].size();
				start = tmp;
			}
			
			len += 1;
			visited_count[start] += 1;
			order.add(start);
			
			if (visited_count[start] > possibleNum[start][1]) { // 최대 횟수를 넘어버렸으면 실패
				check = false;
				break;
			}
			if (visited_count[start] == possibleNum[start][0]) { // 최소 횟수와 같다면 count를 1 줄여줌
				count -= 1;
			}
			if (count == 0) {									 // count가 0이라는 것은 모든 리프 노드가 조건을 만족하는 중이라는 뜻
				break;
			}
		}

		if (!check) {
			return new int[] { -1 };							// 실패했으니 {-1}반환
		}

		int[][] myorder = new int[n + 1][];						// 각 노드에 들어갈 공 순서대로 저장

		for (int i = 1; i <= n; i++) {
			myorder[i] = change(visited_count[i], target[i - 1]); // 아래에서 바꿔줌
		}

		int[] answer = new int[len];							 

		int[] index = new int[n + 1];							// 지금 뽑아야할 인덱스

		for (int i = 0; i < len; i++) {
			int tmp = order.get(i);								// order를 돌면서 출력
			answer[i] = myorder[tmp][index[tmp]++];
		}

		return answer;

	}

	public static int[] change(int k, int n) {
		int[] lst = new int[k];
		int count1 = 0;
		int count2 = 0;
		if (n == k) {
			count1 = k;
		} else {
			count1 = k - ((n - k - 1) / 2 + 1);
			int tmp1 = n - count1;
			int tmp2 = k - count1;
			count2 = 3 * tmp2 - tmp1;
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
