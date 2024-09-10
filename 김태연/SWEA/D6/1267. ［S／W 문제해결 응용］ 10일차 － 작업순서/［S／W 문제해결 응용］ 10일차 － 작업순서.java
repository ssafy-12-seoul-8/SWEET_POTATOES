import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	boolean[] priority;

	public Node(boolean[] priority) {
		super();
		this.priority = priority;
	}
	
}

public class Solution {

	static int V,E;
	static boolean[] isDone;
	static int[] count;
	static Node[] nodes;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			StringBuilder sb = new StringBuilder();

			sb.append("#").append(test_case);
			
			V = sc.nextInt();
			E = sc.nextInt();
			// 앞에꺼 -> 뒤에꺼
			
			nodes = new Node[V+1];
			count = new int[V+1];		// 할 일의 개수
			isDone = new boolean[V+1];
			
			for (int i=1; i<=V; i++) {
				boolean[] priority = new boolean[V+1];
				Node node = new Node(priority);
				nodes[i] = node;
			}
			
			
			
			for (int i=0; i<E; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				nodes[to].priority[from] = true;	// to번 노드의 선행조건으로 from을 추가함
				count[to]++;
			}
			
			for (int i=1; i <= 1000; i++) {
//				System.out.println("시행");
				List<Integer> todoList = new ArrayList<>();
				// 할 일의 개수가 0개이면
				
//				System.out.println("1번의 선행개수 : " + count[1]);
				
				for (int j=1; j<= V; j++) {
					if (count[j] == 0) {		// 선행조건의 수가 0개이면
						todoList.add(j);		// 할일에 j를 더해둔다
					}
				}
				
				// 그 다음 한번에 일처리를 한다
				int size = todoList.size();
				for (int j=0; j < size; j++) {
					int target = todoList.get(j);	// target = 4번, 8번
					work(target);					// 4번 일하기, 8번 일 하기
													// 처리되는 로직 : 1번의 priority[4] = false 로 바꾸고
													// count[1]-- 한다.
					isDone[target] = true;			// isDone[4] = true 로 바꾸고
					count[target]--;				// count[4]-- 한다.
					sb.append(" ").append(target);
				}
				
				// 끝났다면 종료한다.
				if (isDone()) break;			// 0 이 한개도 없다면 종료한다.
				
			}
			System.out.println(sb);
			
		}
	}
	
	static void work(int target) {
		// 이미 끝낸일이라면 종료하고
		if (isDone[target]) return;
		
//		System.out.println(target + "번 일 처리");
		// 끝낸 일이 아니라면
		// 나를 포함하는 과목들을 찾아내서 제거한다
		for (int i=1; i<=V; i++) {
//			System.out.println(i + " 에 대해서 시행");
			
			if (nodes[i].priority[target]) {
				nodes[i].priority[target] = false;
				count[i]--;
				
			}
//			isDone[target] = true;
//			System.out.println(i + " 의 카운트는 : " + " " + count[i]);
		}
			
	}
	
	static boolean isDone() {
		
		for (int i=1; i<= V; i++) {
			if (isDone[i]) continue;
			// 선수과목에 0이 한개라도 있다 -> 계속한다
			if (count[i] == 0) return false; // 안 했는 과목들의 선수과목에 0이 없다 -> 종료 
		}
		// 선수과목에 0이 한개도 없다
		return true;	// true
	}
}
