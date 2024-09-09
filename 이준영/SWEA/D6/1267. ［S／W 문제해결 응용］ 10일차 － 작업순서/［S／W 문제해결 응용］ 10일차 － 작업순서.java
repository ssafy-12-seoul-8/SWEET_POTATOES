import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int[] count = new int[V + 1];
			
			Queue<Integer> queue = new LinkedList<>();
			ArrayList<Integer>[] lst = new ArrayList[V+1];
			st = new StringTokenizer(br.readLine());
			
			for(int i = 1 ; i<V+1;i++) {
				lst[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < E; i++) {
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				lst[a].add(b);
				count[b]+=1;
				
			}
			
			sb.append("#").append(tc).append(" ");
			
			for(int i=1;i<V+1;i++) {
				if(count[i]==0) {
					queue.add(i);
					sb.append(i).append(" ");
				}
			}
			
			while(!queue.isEmpty()) {
				int a = queue.poll();
				for(int b:lst[a]) {
					count[b]-=1;
					if(count[b]==0) {
						queue.offer(b);
						sb.append(b).append(" ");
					}
				}
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
