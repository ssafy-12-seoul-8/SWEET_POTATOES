import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, K;
	static int[][] map;
	static boolean[][][] visited;
	
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][K+1];
        
        for (int n = 1; n <= N; n++) {
        	String str = br.readLine();
        	for (int m = 1; m <= M; m++)
        		map[n][m] = str.charAt(m - 1) - '0';
        }
        
        Queue<int[]> bfs = new LinkedList<>();

        bfs.add(new int[] {1, 1, 1, 0});
		visited[1][1][0] = true;
		
		int minCnt = -1;
		while(!bfs.isEmpty()) {
			
			int[] now = bfs.poll();
			int rNow = now[0];
			int cNow = now[1];
			int cnt = now[2];
			int brk = now[3];
			
			if (rNow == N && cNow == M) {
				minCnt = cnt;
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				
				int rNext = rNow + dr[d];
				int cNext = cNow + dc[d];
				
				if (rNext < 1 || rNext > N || cNext < 1 || cNext > M)
					continue;
				int brkNext = brk;
				if (map[rNext][cNext] == 1)
					brkNext++;
				if (brkNext > K || visited[rNext][cNext][brkNext])
					continue;

				bfs.add(new int[] {rNext, cNext, cnt + 1, brkNext});
				visited[rNext][cNext][brkNext] = true;
			}
		}
		
//		System.out.println(minCnt == Integer.MAX_VALUE ? minCnt : -1);
		System.out.println(minCnt);
    }
}