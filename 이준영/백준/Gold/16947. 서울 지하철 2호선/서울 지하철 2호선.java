import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int[] count1 = new int[N+1];				// 각 역에 연결된 역의 수 - 첫 순환에 사용
		int[] count2 = new int[N+1];				// 각 역에 연결된 역의 수 - 두번째 순환의 시작역을 알기 위해 사용
		int[] depth = new int[N+1];					// 순환선으로부터의 깊이를 저장할 배열
		boolean[] visited = new boolean[N+1];		// 첫 순환에서 true로 바뀌는 건 순환선에 포함안됨
		List<Integer>[] arr = new ArrayList[N+1];   // 각 역에 연결된 역을 arrayList로 저장
		
		for(int i=1;i<=N;i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
			count1[a]+=1;
			count1[b]+=1;
			count2[a]+=1;
			count2[b]+=1;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			if(count1[i]==1) {
				queue.add(i);
				count1[i]=0;
			}
		}
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			if(!visited[a]) {
				visited[a] = true;
				for(int i:arr[a]) {
					if(!visited[i]) {
						count1[i]-=1;
						if(count1[i]==1) {
							queue.add(i);
						}
						break;
					}
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(!visited[i] && count2[i]>=3) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			for(int i:arr[a]) {
				if(visited[i]) {
					visited[i] = false;
					depth[i] = depth[a]+1;
					queue.add(i);
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			sb.append(depth[i]).append(" ");
		}
		System.out.println(sb);
	}
}
