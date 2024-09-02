import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] dx = {0,1,-1,0,0};
		int[] dy = {0,0,0,-1,1};
		int[] dice = {0,0,0,0,0,0};
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++) {
			int d = Integer.parseInt(st.nextToken());
			int ny = y + dy[d];
			int nx = x + dx[d];
			if(nx<0 || nx>=M || ny<0 || ny>=N) {
				continue;
			}
			y = ny;
			x = nx;
			int tmp = 0;
			switch (d) {
				case 1:
					tmp = dice[0];
					dice[0] = dice[3];
					dice[3] = dice[5];
					dice[5] = dice[2];
					dice[2] = tmp;
					break;
				case 2:
					tmp = dice[0];
					dice[0] = dice[2];
					dice[2] = dice[5];
					dice[5] = dice[3];
					dice[3] = tmp;
					break;
				case 3:
					tmp = dice[0];
					dice[0] = dice[4];
					dice[4] = dice[5];
					dice[5] = dice[1];
					dice[1] = tmp;
					break;
				case 4:
					tmp = dice[0];
					dice[0] = dice[1];
					dice[1] = dice[5];
					dice[5] = dice[4];
					dice[4] = tmp;
					break;
			}
			if(arr[y][x]==0) {
				arr[y][x] = dice[5];
			} else {
				dice[5] = arr[y][x];
				arr[y][x] = 0;
			}
			sb.append(dice[0]).append("\n");
		}
		System.out.println(sb);
	}
}
