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
		
		for(int tc=1;tc<=10;tc++) {
			
			st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			boolean[] visited = new boolean[101];
			ArrayList<Integer>[] arr = new ArrayList[101];
			
			for(int i=1;i<101;i++) {
				arr[i] = new ArrayList<>();
			}
			
			for(int i=0;i<len/2;i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a].add(b);
			}
			
			Queue<Integer> queue = new LinkedList<>();
			queue.add(start);
			visited[start] = true;
			
			int last = 0;
			
			while(!queue.isEmpty()) {
				Queue<Integer> queue2 = new LinkedList<>();
				for(int i:queue) {
					for(int j:arr[i]) {
						if(!visited[j]) {
							queue2.add(j);
							visited[j] = true;
						}
					}
				}
				if(queue2.isEmpty()) {
					for(int i:queue) {
						if(i>last) {
							last=i;
						}
					}
					break;
				} else {
					queue = queue2;
				}
			}
			sb.append("#").append(tc).append(" ").append(last).append("\n");
		}
		System.out.println(sb);
	}
}
