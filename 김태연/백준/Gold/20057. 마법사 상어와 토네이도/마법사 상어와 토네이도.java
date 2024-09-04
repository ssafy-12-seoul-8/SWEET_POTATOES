import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] map;
    // 좌,하,우,상
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { -1, 0, 1, 0 };

    // tdr 다시 확인하기
    static int[][] tdr = { { 0, 1, -1, 2, 1, -1, -2, 1, -1, 0},
            { 2, 1, 1, 0, 0, 0, 0, -1, -1, 1 },
            { 0, -1, 1, -2, -1, 1, 2, -1, 1, 0 },
            { -2, -1, -1, 0, 0, 0, 0, 1, 1, -1 } }; // 여기까지 토네이도 위치

    static int[][] tdc = { { -2, -1, -1, 0, 0, 0, 0, 1, 1, -1 }, { 0, -1, 1, -2, -1, 1, 2, -1, 1, 0 },
            { 2, 1, 1, 0, 0, 0, 0, -1, -1, 1 }, { 0, -1, 1, -2, -1, 1, 2, -1, 1, 0 } };

    static int[] tPercent = { 5, 10, 10, 2, 7, 7, 2, 1, 1, 0 };

    static int dir = 0;
    static int sum = 0;
    static int binaryCount = 0;
    static int L;
    static int moveCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        sum = 0;

        // 토네이도의 시작 지점 (r,c)
        int r = N / 2;
        int c = N / 2;
        L = 1;
        moveCount = 1;
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        while (!(r == 0 && c == 0)) {

            // 1. 주어진 좌표와 방향에서 모래를 흩뿌린다
            spread(r, c, dir);
            moveCount--;

            // 2. 이동 방향으로 토네이도 옮겨놓고
            r = r + dr[dir];
            c = c + dc[dir];
            
            // 3. 다음 방향 계산
            if (moveCount == 0) {
                changeDirection();
            }
        }

        System.out.println(sum);
    }

    // 토네이도의 위치를 x
    static void spread(int r, int c, int dir) {

        int nextR = r + dr[dir];
        int nextC = c + dc[dir];
        
        if (!isBoundary(nextR,nextC)) return;
        
        int sand = map[nextR][nextC];

        for (int i = 0; i < 10; i++) {
            // 이번에 확인할 row 위치
            int row = nextR + tdr[dir][i];

            // 이번에 확인할 column 위치
            int column = nextC + tdc[dir][i];

            // 이번에 움직일 모래의 양
            int sandAmount = (int) (sand * 0.01 * tPercent[i]);

            // 마지막 회차때는
            if (i == 9)
                sandAmount = map[nextR][nextC];

            if (isBoundary(row, column)) {
                map[row][column] += sandAmount;
                map[nextR][nextC] -= sandAmount;
                // 모래 처리 로직
                // 알파 로직 처리
            } else {
                sum += sandAmount;
                map[nextR][nextC] -= sandAmount;
            }

        }

    }

    static boolean isBoundary(int row, int column) {
    	 return row >= 0 && row < N && column >= 0 && column < N;
    }

    static void changeDirection() {
        binaryCount++;
        dir = (dir + 1) % 4;
        if (binaryCount % 2 == 0) {
            L++;
        }
        moveCount = L;
    }

}
