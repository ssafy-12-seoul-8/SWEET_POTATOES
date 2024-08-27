import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[][] parent;
	static int[] depth;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			long distance = 0;
			ArrayList<Integer>[] child = new ArrayList[N+1];
			for(int i=1;i<N+1;i++) {
				child[i] = new ArrayList<>();
			}
			parent = new int[N+1][21];
			depth = new int[N+1];
			boolean[] visited = new boolean[N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=2;i<N+1;i++) {
				int a = Integer.parseInt(st.nextToken());
				parent[i][0]=a;
				child[a].add(i);
				depth[i]=depth[a]+1;
			}
			for(int i=1;i<21;i++) {
				for(int j=2;j<N+1;j++) {
					parent[j][i]=parent[parent[j][i-1]][i-1];
				}
			}
			Queue<Integer> queue = new LinkedList<>();
			int cur = 1;
			queue.add(1);
			while(!queue.isEmpty()) {
				int a = queue.poll();
				if(!visited[a]) {
					distance+=dist(cur,a);
					visited[a]=true;
					for(int i:child[a]) {
						queue.add(i);
					}
					cur=a;
					
				}
			}
			sb.append("#").append(tc).append(" ").append(distance).append("\n");
		}
		System.out.println(sb);
	}
	static int dist(int a,int b) {
		if(a==b) {
			return 0;
		}
		if(depth[a]>depth[b]) {
			int tmp=a;
			a=b;
			b=tmp;
		}
		int count=0;
		int i=20;
		while(depth[a]<depth[b]) {
			if(depth[a]+(1<<i)>depth[b]) {
				i=i-1;
				continue;
			}
			count+=(1<<i);
			b=parent[b][i];
			i=i-1;
		}
		if (a==b)
			return count;
		i=20;
		while(i>=0) {
			if(parent[a][i]==parent[b][i]) {
				i=i-1;
				continue;
			}
			a=parent[a][i];
			b=parent[b][i];
			count+=(1<<(i+1));
			i=i-1;
		}
		return count+2;
	}
}
