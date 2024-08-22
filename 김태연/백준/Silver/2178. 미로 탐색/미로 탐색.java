import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] maize;
    static boolean[][] isVisited;
    static int[] dr = { 0, 0, 1, -1 }; // 동 서 남 북
    static int[] dc = { 1, -1, 0, 0 }; // 동 서 남 북

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maize = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maize[i][j] = line.charAt(j) - '0';
            }
        }

        // 시행
        int result = bfs(0, 0);

        // 출력
        System.out.println(result);
        br.close();
    }

    static int bfs(int startRow, int startColumn) {
    	
    	// 분기점들을 저장할 큐 생성
        Queue<int[]> queue = new LinkedList<>();
        
        // 먼저 {0,0} 부터 queue에 저장.
        queue.add(new int[] { startRow, startColumn });
        
        isVisited[startRow][startColumn] = true;

        // BFS 구현 : while문 사용
        while (!queue.isEmpty()) {
//        	System.out.println("queue : " + Arrays.toString(queue.peek()));
        	// 마지막 == '제일 멀리 갔는 곳' 이라는 뜻
            int[] current = queue.poll();	// 마지막 위치 뽑기
            
            int currentRow = current[0];	// 마지막 row
            int currentColumn = current[1];	// 마지막 column
            int currentDepth = maize[currentRow][currentColumn];	// 마지막 깊이 : 

            // 목적지에 도달하면 깊이(최단 경로)를 반환
            if (currentRow == N - 1 && currentColumn == M - 1) {
                return currentDepth;
            }

            // 4방향 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nextRow = currentRow + dr[dir];
                int nextColumn = currentColumn + dc[dir];

                if (inBoundary(nextRow, nextColumn) && !isVisited[nextRow][nextColumn] && maize[nextRow][nextColumn] == 1) {
                    queue.add(new int[] { nextRow, nextColumn });
                    isVisited[nextRow][nextColumn] = true;
                    maize[nextRow][nextColumn] = currentDepth + 1;
                }
            }
        }

        // 목적지에 도달하지 못한 경우(이 문제에서는 발생하지 않음)
        return -1;
    }

    static boolean inBoundary(int row, int column) {
        return row >= 0 && row < N && column >= 0 && column < M;
    }
}
