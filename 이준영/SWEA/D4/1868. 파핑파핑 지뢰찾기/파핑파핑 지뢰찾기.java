import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] dx= {0,0,1,1,1,-1,-1,-1};
	static int[] dy= {1,-1,0,1,-1,0,1,-1};
	static int N = 0;
	static char[][] c;
	static int[][] d;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int count = 0 ;
			c = new char[N][N];
			d = new int[N][N];
			visited = new boolean[N][N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for(int j=0;j<N;j++) {
					c[i][j]=str.charAt(j);
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					for(int k=0;k<8;k++) {
						int ny = i+dy[k];
						int nx = j+dx[k];
						if(0<=nx && nx<N && 0<=ny && ny<N && c[ny][nx]=='*')
							d[i][j]+=1;
					}
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if (!visited[i][j]&&c[i][j]=='.'&&d[i][j]==0) {
						count+=1;
						visited[i][j]=true;
						dfs(i,j);
					}
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j] && c[i][j]=='.')
						count+=1;
				}
			}
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
		
	}
	static void dfs(int y,int x) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {y,x});
		while(!que.isEmpty()) {
			int[] tmp =que.poll();
			int a=tmp[0];
			int b=tmp[1];
			for(int k=0;k<8;k++) {
				int ny = a+dy[k];
				int nx = b+dx[k];
				if(0<=nx && nx<N && 0<=ny && ny<N && !visited[ny][nx]) {
					visited[ny][nx]=true;
					if(d[ny][nx]==0)
						que.add(new int[] {ny,nx});
				}
					
			}
		}
	}
}
