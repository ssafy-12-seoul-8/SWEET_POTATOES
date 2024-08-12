
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int count=0;
		boolean[] visited = new boolean[N+1];
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>(); 
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (!map.containsKey(a)) {
				ArrayList<Integer> v = new ArrayList<>();
				v.add(b);
				map.put(a,v);
			} else {
				ArrayList<Integer> v = map.get(a);
				v.add(b);
				map.put(a,v);
			}
			if (!map.containsKey(b)) {
				ArrayList<Integer> v = new ArrayList<>();
				v.add(a);
				map.put(b,v);
			} else {
				ArrayList<Integer> v = map.get(b);
				v.add(a);
				map.put(b,v);
			}
		}
		visited[1]=true;
		stack.push(1);
		while (!stack.isEmpty()) {
			int a = stack.pop();
			if (map.containsKey(a)) {
				for (int i:map.get(a)) {
					if (!visited[i]) {
						count+=1;
						stack.push(i);
						visited[i]=true;
					}
				}
			}	
		}
		System.out.println(count);
	}
}
