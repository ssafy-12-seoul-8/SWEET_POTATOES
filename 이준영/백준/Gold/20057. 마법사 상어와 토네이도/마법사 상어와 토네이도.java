import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
 	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] dy = {0,1,0,-1};
		int[] dx = {-1,0,1,0};
		int[][] tdx = new int[4][9]; 
		int[] dx_init = {0,-1,0,1,-2,-1,0,1,0};
							  
		int[][] tdy = new int[4][9];
		int[] dy_init =	{-2,-1,-1,-1,0,1,1,1,2};
		
		for(int j=0;j<9;j++) {
			tdx[0][j] = dx_init[j];
			tdy[0][j] = dy_init[j];
		}
		for(int i=1;i<4;i++) {
			for(int j=0;j<9;j++) {
				tdx[i][j] = tdy[i-1][j];
				tdy[i][j] = -tdx[i-1][j];
			}
		}
							 
		int[] sand = {2,10,7,1,5,10,7,1,2};
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int y = (N-1)/2;
		int x = (N-1)/2;
		int d = 0;
		int total = 0;
		
		for(int k=1;k<N-1;k++) {
			for(int l = 0;l<2;l++) {
				for(int i = 1 ;i<=k;i++) {
					
					y = y + dy[d];
					x = x + dx[d];
					int start = arr[y][x];
					int sum = start;
					
					for(int j=0;j<9;j++) {
						int ny = y + tdy[d][j];
						int nx = x + tdx[d][j];
						int s = (start * sand[j])/100;
						sum-=s;
						if(0<=nx && nx<N && 0<=ny && ny<N) {
							arr[ny][nx]+=s;
						} else {
							total+=s;
						}
						
					}
					int ny = y + dy[d];
					int nx = x + dx[d];
					if(0<=nx && nx<N && 0<=ny && ny<N) {
						arr[ny][nx] += sum;
					}
					else {
						total+=sum;
					}
				}
				d = (d+1)%4;
			}
		}
		for(int l=0;l<3;l++) {
			for(int i = 1 ;i<=N-1;i++) {
				
				y = y + dy[d];
				x = x + dx[d];
				int start = arr[y][x];
				int sum = start;
				
				for(int j=0;j<9;j++) {
					int ny = y + tdy[d][j];
					int nx = x + tdx[d][j];
					int s = (start * sand[j])/100;
					sum-=s;
					if(0<=nx && nx<N && 0<=ny && ny<N) {
						arr[ny][nx]+=s;
					} else {
						total+=s;
					}
				}
				int ny = y + dy[d];
				int nx = x + dx[d];
				if(0<=nx && nx<N && 0<=ny && ny<N) {
					arr[ny][nx] += sum;
				}
				else {
					total+=sum;
				}
			}
			d=(d+1)%4;
		}
		System.out.println(total);
	}
}	
