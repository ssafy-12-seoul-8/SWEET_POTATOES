import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dy = {-1,0,1,0};
		int[] dx = {0,1,0,-1};
		int count = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
 		
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			if(arr[y][x]==0) {
				arr[y][x] = 2;
				count+=1;
			} 
			if(arr[y][x]==1) {
				break;
			}
			int e = 0;
			for(int i=1;i<5;i++) {
				int ny = y + dy[(dir-i+4)%4];
				int nx = x + dx[(dir-i+4)%4];
				if(arr[ny][nx]==0) {
					y=ny;
					x=nx;
					e=1;
					dir=(dir-i+4)%4;
					break;
				}
			}
			if(e==1) {
				continue;
			}
			y = y - dy[dir];
			x = x - dx[dir];
			
		}
		System.out.println(count);
	}
}
