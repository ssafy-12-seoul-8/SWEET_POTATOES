import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] parent;
	static int[] depth;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		parent = new int[N + 1][21];
		depth = new int[N + 1];
		boolean[] visited = new boolean[N+1];
		ArrayList<Integer>[] connected = new ArrayList[N+1];

		for (int i = 1; i < N + 1; i++) {
			connected[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			connected[a].add(b);
			connected[b].add(a);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		
		while(!queue.isEmpty()) {
			int a = queue.poll();
			for(int i:connected[a]) {
				if(!visited[i]) {
					depth[i] = depth[a]+1;
					visited[i]=true;
					parent[i][0] = a;
					queue.add(i);
				}
			}
		}
		
		
		
		for (int i = 1; i < 21; i++) {
			for (int j = 1; j <= N; j++) {
				parent[j][i] = parent[parent[j][i - 1]][i - 1];
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<M;i++) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(find(a,b)).append("\n");
			
		}
		System.out.println(sb);
		
	}
	static int find(int a,int b) {
		
		if(a==b) {
			return a;
		}
		
		if(depth[a]>depth[b]) {
			int tmp=a;
			a=b;
			b=tmp;
		}
		
		int i=20;
		
		while(depth[a]<depth[b]) {
			if(depth[a]+(1<<i)>depth[b]) {
				i=i-1;
				continue;
			}
			b=parent[b][i];
			i=i-1;
		}
		
		if (a==b)
			return a;
		
		i=20;
		while(i>=0) {
			if(parent[a][i]==parent[b][i]) {
				i=i-1;
				continue;
			}
			a=parent[a][i];
			b=parent[b][i];
			i=i-1;
		}
		
		return parent[a][0];
	}
}
