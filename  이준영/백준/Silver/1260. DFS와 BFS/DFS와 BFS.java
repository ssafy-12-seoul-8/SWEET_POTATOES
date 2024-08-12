import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i=1;i<N+1;i++) {
			ArrayList<Integer> v = new ArrayList<>();
			map.put(i, v);
		}
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			ArrayList<Integer> v1 = map.get(a);
			ArrayList<Integer> v2 = map.get(b);
			v1.add(b);
			v2.add(a);
		}
		for (int i=1;i<N+1;i++) {
			ArrayList<Integer> v = map.get(i);
			Collections.sort(v,(a,b)->b-a);
			map.put(i, v);
		}
		boolean[] visited = new boolean[N+1];
		Stack<Integer> stack = new Stack<>();
		stack.push(V);
		while (!stack.isEmpty()) {
			int a = stack.pop();
			if (!visited[a]) {
				sb.append(a).append(" ");
				visited[a]=true;
				stack.addAll(map.get(a));
			}
		}
		sb.append("\n");
		for (int i=1;i<N+1;i++) {
			ArrayList<Integer> v = map.get(i);
			Collections.sort(v);
			map.put(i, v);
		}
		visited = new boolean[N+1];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(V);
		while(!queue.isEmpty()) {
			int a=queue.poll();
			if(!visited[a]) {
				sb.append(a).append(" ");
				visited[a]=true;
				queue.addAll(map.get(a));
			}
			
		}
		System.out.println(sb);
	}
}
