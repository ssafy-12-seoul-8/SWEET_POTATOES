import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, K;
	static int[][] mountain;
	static int answer;
	static boolean[][] visited;
	
	// 상 우 하 좌
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String t = br.readLine();
		int T = Integer.parseInt(t);
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			String nk = br.readLine();
			StringTokenizer st1 = new StringTokenizer(nk);
			
			//	한 변의 길이
			N = Integer.parseInt(st1.nextToken());	
			//	최대 공사 가능 깊이
			K = Integer.parseInt(st1.nextToken());
			
			int max = 1;	// 최대 높이
			List<int[]> starts = new LinkedList<>();
			mountain = new int[N][N];
			
			for(int r=0 ; r<N ; r++) {
				String row = br.readLine();
				StringTokenizer st2 = new StringTokenizer(row);
				for(int c=0 ; c<N ; c++) {
					mountain[r][c] = Integer.parseInt(st2.nextToken());
					int curr = mountain[r][c];
					if(curr>max) {
						starts.clear();
						max = curr;
						int[] tmp = {r,c};
						starts.add(tmp);
					}else if(curr==max) {
						int[] tmp = {r,c};
						starts.add(tmp);
					}
				}
			}
			
			
			answer = 0;
			
			visited = new boolean[N][N];
			int[][] clone = new int[N][N];
			for(int r=0 ; r<N ; r++) {
				clone[r] = mountain[r].clone();
			}
			
			for(int[] start : starts) {
				int r = start[0];
				int c = start[1];
				visited[r][c] = true;
				move(r, c, 1, 1, visited, clone);
				visited[r][c] = false;
					
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
			
		}
		
		String ans = sb.toString();
		System.out.println(ans);
		
	}

	private static void move(int r, int c, int used, int length, boolean[][] visited, int[][] clone) {
		
		answer = Math.max(answer, length);
		
		for(int d=0 ; d<4 ; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if(isIn(nr,nc) && clone[nr][nc]<clone[r][c] && !visited[nr][nc]) {
				visited[nr][nc] = true;
				move(nr, nc, used, length+1, visited, clone);
				visited[nr][nc] = false;
			}
			
			if(isIn(nr,nc) && mountain[nr][nc]>=mountain[r][c] && mountain[nr][nc]-K<mountain[r][c] && !visited[nr][nc] && used>0) {
				clone[nr][nc] = clone[r][c] - 1;
				visited[nr][nc] = true;
				move(nr, nc, used-1, length+1, visited, clone);
				visited[nr][nc] = false;
				clone[nr][nc] = mountain[nr][nc];
			}
		}
		
	}

	private static boolean isIn(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N) {
			return true;
		}
		return false;
	}



}
