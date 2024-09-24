import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 미로의 가로 크기 M 
		int M = Integer.parseInt(st.nextToken());
		// 미로의 세로 크기 N 
		int N = Integer.parseInt(st.nextToken());
		
		// 미로 정보 입력
		int[][] miro = new int[N][M];
		
		for(int i=0 ; i<N ; i++) {
			String row = br.readLine();
			for(int j=0 ; j<M ; j++) {
				miro[i][j] = row.charAt(j)-'0';
			}
		}
		
		// 각 지점 까지 뚫은 벽 수 
		int[][] degree = new int[N][M];
		
		// 모두 INF 로 초기화
		for(int i=0 ; i<N ; i++) {
			Arrays.fill(degree[i], Integer.MAX_VALUE);
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
			
		});
				
		// 시작점 등록
		pq.add(new int[] {0,0,0});
		
		// 델타 배열 : 상 하 좌 우
		int[] dr = {1, -1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			
			int r = curr[0];
			int c = curr[1];
			
			if(curr[2] >= degree[r][c]) continue;
			
			degree[r][c] = curr[2];
			
			for(int d=0 ; d<4 ;d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr>=0 && nr<N && nc>=0 && nc<M) {
					pq.add(new int[] {nr, nc, curr[2]+miro[nr][nc]});
				}
			}
			
		}
		
		System.out.println(degree[N-1][M-1]);
		
	}	// main



}

