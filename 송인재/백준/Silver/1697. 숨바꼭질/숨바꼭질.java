import java.io.*;
import java.util.*;
	
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] map = new int[100_001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sb = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		map[sb] = 1;
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(sb);
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			int prev = curr - 1;
			int nextDistance = map[curr] + 1;
			
			if (prev >= 0 && (map[prev] == 0 || map[prev] > nextDistance)) {
				map[prev] = nextDistance;
				
				queue.add(prev);
			}
			
			int next = curr + 1;
			
			if (next < 100_001 && (map[next] == 0 || map[next] > nextDistance)) {
				map[next] = nextDistance;
				
				queue.add(next);
			}
			
			int jump = 2 * curr;
			
			if (jump < 100_001 && (map[jump] == 0 || map[jump] > nextDistance)) {
				map[jump] = nextDistance;
				
				queue.add(jump);
			}
		}
		
		System.out.println(map[goal] - 1);
	}
	
}
