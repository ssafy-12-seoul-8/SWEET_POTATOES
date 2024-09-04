import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] arr;
	static int max = 0;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				visited[i][j] = true;
				btk(i,j,1,arr[i][j]);
				visited[i][j] = false;
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				ex(i,j);
			}
		}
		System.out.println(max);
	}
	static void btk(int y,int x, int len, int sum) {
		if(len==4) {
			max = Math.max(max, sum);
			return;
		}
		for(int k = 0; k < 3 ;k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if(0<=nx && nx<M && 0<=ny && ny<N && !visited[ny][nx]) {
				visited[ny][nx] = true;
				btk(ny,nx,len+1,sum+arr[ny][nx]);
				visited[ny][nx] = false;
			}
		}
		return;
	}
	static void ex(int y,int x) {
		for(int l=0;l<4;l++) {
			int count = arr[y][x];
			for(int k=0;k<4;k++) {
				if(k==l) {
					continue;
				}
				int ny = y + dy[k];
				int nx = x + dx[k];
				if(0<=nx && nx<M && 0<=ny && ny<N ) {
					count += arr[ny][nx];
				} else {
					count = 0;
					break;
				}
			}
			max = Math.max(max, count);
		}
	}
}