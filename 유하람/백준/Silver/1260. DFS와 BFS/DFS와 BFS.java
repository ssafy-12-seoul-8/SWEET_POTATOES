import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);		
		
		int N = sc.nextInt();	// 정점의 개수
		int M = sc.nextInt();	// 간선의 개수
		int V = sc.nextInt();	// 탐색을 시작 할 정점의 번호
		
		List<Integer>[] list = new LinkedList[N+1];
		
		for(int i=0 ; i<N+1 ; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		for(int i=0 ; i<M ; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=1 ; i<N+1 ; i++) {
			Collections.sort(list[i]);
		}
		
		// DFS
		Stack<Integer> stack = new Stack<>();
		boolean[] visited1 = new boolean[N+1];
		stack.push(V);
		while(!stack.isEmpty()) {
			int curr = stack.pop();
			if(visited1[curr]) continue;
			visited1[curr] = true;
			System.out.print(curr+" ");
			
			for(int i= list[curr].size()-1 ; i>=0 ; i--) {
				stack.push(list[curr].get(i));
			}
		}
		System.out.println();
		
		// BFS
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited2 = new boolean[N+1];
		queue.add(V);
		while(!queue.isEmpty()) {
			int curr = queue.remove();
			if(visited2[curr]) continue;
			visited2[curr] = true;
			System.out.print(curr+" ");
			
			for(int i : list[curr]) {
				queue.add(i);
			}
		}
	}

}
