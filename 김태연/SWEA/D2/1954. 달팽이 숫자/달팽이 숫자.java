import java.util.Scanner;

class Solution {

static int[][] array;
// 우 하 좌 상
static int[] dr = { 0, 1, 0, -1 };
static int[] dc = { 1, 0, -1, 0 };
static int dir;
static int N;

public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int T;
    T = sc.nextInt(); // 2

    for (int test_case = 1; test_case <= T; test_case++) {
        N = sc.nextInt(); // 3, 4

        
        System.out.println("#" + test_case);
        int r = 0;
        int c = 0;

        array = new int[N][N];

        // n*n번만큼 시행

        // 초기 진행방향 : 오른쪽
        dir = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // 현재 자리에 점수 찍고
                array[r][c] = N * i + j + 1;

                // 전진할 수 있는지 판단
                if (isBoundary(r, c, dir) && isZero(r, c, dir)) {
                    r = r + dr[dir];
                    c = c + dc[dir];
//                        System.out.print("전진!");
//                        System.out.println("현재 r , c 값 : " + r + " , " + c);
                    } else {
//                        System.out.println("방향전환");
                        dir++;
                        dir %= 4;
                        r = r + dr[dir];
                        c = c + dc[dir];
                    }
                }
            }

            // 배열 출력
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }

    }
}

static boolean isBoundary(int r, int c, int dir) {
    if (r + dr[dir] >= 0 && r + dr[dir] < N && c + dc[dir] >= 0 && c + dc[dir] < N)
        return true;
    return false;
}

static boolean isZero(int r, int c, int dir) {
    if (array[r + dr[dir]][c + dc[dir]] == 0)
        return true;
    return false;
}
}