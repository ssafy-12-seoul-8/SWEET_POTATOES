import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 동서남북
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int N;
    static boolean[][] visited;
    static int[][] map;
    static int size = 2;    // 아기 상어의 초기 크기는 2
    static int sizeCount = 0;
    static int totalTime = 0;
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        int r = 0;
        int c = 0;
        
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                
                if (input == 9) {
                    r = i;
                    c = j;
                    
                    // 아기상어의 시작 위치를 0으로 바꿔둠 -> 왜 그러는지는 생각해보자
                    map[i][j] = 0;
                    
                }
            }
        }
        
        while (true) {
            int[] result = find(r,c);    // 가장 가까운 물고기 찾기
//            find(r,c);
            if (result == null) {    // 물고기가 없다면
                break;
            } else {
                int nr = result[0];    // next row
                int nc = result[1];    // next column
                int distance = result[2];
                
                totalTime += distance;        // 이동하는데 걸린 시간 = 거리
                // 이동
                r = nr;
                c = nc;
                eat(r,c);    // 냠냠
            }
            

        }
        
        
        System.out.println(totalTime);
    }
    
    // BFS 구현
    static int[] find(int r, int c) {
        // 내 위치에서부터 BFS를 돌려서 가까운 곳 찾는다
        Queue<int[]> queue = new LinkedList<int[]>();
        visited = new boolean[N][N];    // 방문할때마다 초기화해야함
        
        int[] start = new int[] {r,c,0};    // r좌표, c좌표, distance값
        queue.offer(start);
        
        visited[r][c] = true;
        
        // 초기화
        int minR = -1;
        int minC = -1;
        int minDist = Integer.MAX_VALUE;
        
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cr = curr[0];
            int cc = curr[1];
            int dist = curr[2];
            
            // 먹을 수 있는 것들 중에서
            if (isEdible(cr,cc)) {
                // 거리가 최단거리보다 작으면 갱신
                if (dist < minDist) {
                    minR = cr;
                    minC = cc;
                    minDist = dist;
                } else if (dist == minDist) {
                    // 거리가 같을 때 : 1. 위쪽 2. 왼쪽 우선
                    if (cr < minR || (cr == minR && cc < minC)) {
                        minR = cr;
                        minC = cc;
                    }
                }
            }
            
            for (int i=0; i<4; i++) {
                // 한 칸씩 이동해보기?
                int nr = cr + dr[i];
                int nc = cc + dc[i];
            
                
                if (isBoundary(nr,nc) && !visited[nr][nc] && canMove(nr,nc)) {
                    queue.offer(new int[] {nr, nc, dist+1});
                    visited[nr][nc] = true;
                }
                
            }
        }

        // 아무 로직도 타지 않음
        if (minR == -1) {
            return null;
        }
        
        return new int[] {minR, minC, minDist};
        
    }

    // 범위 내에 있는지?
    static boolean isBoundary(int nr, int nc) {
        return (nr >= 0 && nr < N && nc >= 0 && nc < N);
    }
    
    static boolean canMove(int nr, int nc) {
        return (map[nr][nc] <= size);    // 크기가 같은 물고기는 먹을 수 없지만, 지나갈 수는 있다.
    }
    
    static boolean isEdible(int row, int column) {
        return map[row][column] != 0 && map[row][column] < size;
    }
    
    static void eat(int nr, int nc) {
        sizeCount++;
        // 내 덩치만큼의 물고기를 먹어치웠다면, 덩치를 1 키우고, 사이즈의 카운트를 초기화한다.
        if (sizeCount == size) {
            sizeCount = 0;
            size++;
        }
        map[nr][nc] = 0;
    }
}
