import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	
    static int[][] board;
    
    static List<int[]> positions;
    static boolean[] p_visited;
    
    static List<int[]> virus;
    
    static int wall_count = 0;
    static int safe_count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
         
		// 1(벽)을 놓을 수 있는 모든 좌표
		positions = new ArrayList<>();
		virus = new ArrayList<>();
		
        for (int n = 0; n < N; n++) {
        	st = new StringTokenizer(br.readLine());
        	for (int m = 0; m < M; m++) {
        		int p = Integer.parseInt(st.nextToken());
        		
        		if (p == 0) {
        			positions.add(new int[] {n, m});
        		} else if (p == 2) {
        			virus.add(new int[] {n, m});
        		}
        		
        		board[n][m] = p;
        	}
        }
        
        wall_count = (N * M) - positions.size() - virus.size();
        
        p_visited = new boolean[positions.size()];
		
        int[][] arr = new int[3][2]; // 벽 3개의 좌표
		combination(0, 0, arr);
    
		bw.write(safe_count + "\n");
		
		br.close();
		bw.close();
	}
	
	public static void combination(int depth, int idx, int[][] position) {
		if (depth == 3) {
			checkCount(position);
			return;
		}
		
		for (int i = idx; i < positions.size(); i++) {
			if (p_visited[i] == false) {
				p_visited[i] = true;
				position[depth] = positions.get(i);
				combination(depth + 1, i + 1, position);
				p_visited[i] = false;
			}
		}
	}
	
	public static void checkCount(int[][] position) {
		int[][] temp = new int[N][M];
		
		for (int n = 0; n < N; n++) {
        	temp[n] = board[n].clone();
        }
		
		// 벽 삽입
		for (int i = 0; i < position.length; i++) {
			temp[position[i][0]][position[i][1]] = 1;
		}
		
//		for (int n = 0; n < N; n++) {
//        	System.out.println(Arrays.toString(temp[n]));
//        }
		
		// 상 하 좌 우
		int[] dy = {-1, 1, 0, 0};
		int[] dx = {0, 0, -1, 1};
		
		int count_virus = virus.size();
		
		// 바이러스 상 하 좌 우 움직이면서 퍼뜨리기
		for (int i = 0; i < virus.size(); i++) {
			Queue<int[]> queue = new LinkedList<>();
			
			queue.add(virus.get(i));
			
			while(!queue.isEmpty()) {
				int[] curr = queue.poll();
				int y = curr[0];
				int x = curr[1];
				
				if (temp[y][x] == 0) {
					count_virus++;
					temp[y][x] = 2;
				}
				
				for (int j = 0; j < 4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];
					
					if (ny >= 0 && nx >= 0 && ny < N && nx < M && temp[ny][nx] == 0	
						) {
						queue.add(new int [] {ny, nx});
					}
				}
			}
		}
		
//		for (int n = 0; n < N; n++) {
//        	System.out.println(Arrays.toString(temp[n]));
//        }
		
		safe_count = Math.max(safe_count, (N * M) - (count_virus + wall_count + 3));

	}
	
}
