import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] board = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		
		// 상 우 하 좌
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		
		Queue<int[]> queue = new LinkedList<>();
		
		int cnt = 0;
		int maxSize = 0;
		int size = 0;
		
		for(int i=0 ; i<n ; i++) {
			for(int j=0 ; j<m ; j++) {
				if(board[i][j]==1 && !visited[i][j]) {
					queue.add(new int[] {i,j});
					visited[i][j] = true;
					cnt++;
					size = 0;
					while(!queue.isEmpty()) {
						int[] tmp = queue.poll();
						int r = tmp[0];
						int c = tmp[1];
						size++;
						
						for(int d=0 ; d<4 ; d++) {
							int nr = r + dr[d];
							int nc = c + dc[d];
							
							if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc]==1 && !visited[nr][nc]) {
								queue.add(new int[] {nr,nc});
								visited[nr][nc] = true;
							}
						}
					}
					maxSize = Math.max(maxSize, size);
				}
			}
		}
		
		System.out.println(cnt+"\n"+maxSize);
		
		
	} // main


}
