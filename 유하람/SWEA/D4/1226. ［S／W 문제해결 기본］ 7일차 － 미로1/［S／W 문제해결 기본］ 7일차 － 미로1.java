import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	
	static int startR;
	static int startC;
	static int finishR;
	static int finishC;
	
	static int[][] miro;
	static int answer;
	static Queue<int[]> queue;
	
	// 상 우 하 좌
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int T=1 ; T<=10 ; T++) {
			
			String n = br.readLine();	// 테스트 케이스 입력
			
			miro = new int[16][16];
			
			for(int i=0 ; i<16 ; i++) {
				String row = br.readLine();
				for(int j=0 ; j<16 ; j++) {
					miro[i][j] = row.charAt(j)-'0';
					if(miro[i][j]==2) {
						startR = i;
						startC = j;
					}
					if(miro[i][j]==3) {
						finishR = i;
						finishC = j;
					}
				}
			}
			
			
			answer = 0;
			
			queue = new LinkedList<>();
			
			int start[] = {startR, startC};
			
			queue.add(start);
			
			DFS();
			
			System.out.println("#"+n+" "+answer);

		
		}
		
		
	}

	private static void DFS() {
		
		int[] curr = queue.poll();
		
		int R = curr[0];
		int C = curr[1];
		
		
		if(R==finishR && C==finishC) {
			answer = 1;
			return;
		}
		
		for(int i=0 ; i<4 ; i++) {
			int nr = R + dr[i];
			int nc = C + dc[i];
			if(nr>=0 && nr<16 && nc>=0 && nc<16 && miro[nr][nc]!=1) {
				int[] tmp = {nr, nc};
				queue.offer(tmp);
				miro[nr][nc] = 1;
			}
		}
		
		if(!queue.isEmpty()) {
			DFS();
		}
		
	}

}
