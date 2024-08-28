import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int N = 0;
	static int M = 0;
	static int[][] arr;
	static int minimum = 100;
	static int count1;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int count = -3;
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]!=1) {
					count+=1;
				}
			}
		}
		
		btk(0,0);
		System.out.println(count-minimum);
	}
	
	static void btk(int cur,int len) {
		
		if(len==3) {
			check();
			return;
		}
		
		if (cur==N*M) {
			return;
		}
		
		btk(cur+1,len);
		
		int y = cur/M;
		int x = cur%M;
		
		if(arr[y][x]==0) {
			
			arr[y][x]=1;
			btk(cur+1,len+1);
			arr[y][x]=0;
			
		}
	}
	
	static void check() {
		
		count1 = 0;
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]==2) {
					bfs(i,j);
				}
			}
		}
		if (minimum>count1) {
			minimum=count1;
		}
	}
	
	static void bfs(int start_y,int start_x) {
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {start_y,start_x});
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int y = tmp[0];
			int x = tmp[1];
			if(!visited[y][x]) {
				count1+=1;
				visited[y][x]=true;
				for(int k=0;k<4;k++) {
					int ny = y + dy[k];
					int nx = x + dx[k];
					if(0<=ny && ny<N && 0<=nx && nx<M && arr[ny][nx]==0 && !visited[ny][nx]) {
						queue.add(new int[] {ny,nx});
					}
				}
			}
		}
		return;
	}
}
