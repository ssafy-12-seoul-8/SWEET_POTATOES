import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N;
    static int[][] board;
    static boolean[][] visited;
     
    static int count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		board = new int[N][N];
        visited = new boolean[N][N];
         
        // 현재 좌표 x, y
        // 모든 행에 좌표 하나씩은 꼭 찍혀야 한다.
        // 0 - 8 - 16 - 24 계속 가지 늘어나는 중
         
        btk(-1, 0);
		
		bw.write(count + "\n");
		
		br.close();
		bw.close();
	}
	
	public static void btk (int x, int y) {
        if (x == N - 1) {
             
//          for (int i = 0; i < N; i++) {
//              System.out.println(Arrays.toString(visited[i]));
//          }
             
            count += 1;
             
            return;
        }
         
        for (int i = 0; i < N; i++) {
            // 가능한 경우에만 호출
            if (isPossible(x + 1, i)) {
                visited[x + 1][i] = true;
                btk(x + 1, i);
                visited[x + 1][i] = false;
            }
        }
    }
     
    public static boolean isPossible(int x, int y) { // 행, 열
        // 상 check
        for (int i = 0; i < x; i++) {
            int nx = x - i - 1;
             
            if (nx >= 0 && visited[nx][y] == true) {
                return false;
            }
        }
         
        // 좌상 check
        for (int i = 0; i < x; i++) {
            int nx = x - i - 1;
            int ny = y - i - 1;
             
            if (nx >= 0 && ny >= 0 && visited[nx][ny] == true) {
                return false;
            }
        }
         
        // 우상 check
        for (int i = 0; i < x; i++) {
            int nx = x - i - 1;
            int ny = y + i + 1;
             
            if (nx >= 0 && ny < N && visited[nx][ny] == true) {
                return false;
            }
        }
         
        return true;
    }
	
}
