import java.util.Scanner;

class Main {

    static char[][] arr;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();
        arr = new char[N][N];
        int max = 0;

        // 문자 입력받기
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        // 브루트포스 사용
        // 1. 오른쪽으로 바꾸기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                // 스왑 (i,j) <-> (i,j+1)
                swap(i, j, i, j + 1);
                max = Math.max(max, findMax());
                swap(i, j, i, j + 1); // 제자리로
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                // 아래랑 스왑
                swap(i, j, i + 1, j);
                max = Math.max(max, findMax());
                swap(i, j, i + 1, j); // 원위치시킴
            }
        }

        System.out.println(max);
    }

    // 위치바꾸기
    static void swap(int bx, int by, int ax, int ay) {
        char temp = arr[bx][by];
        arr[bx][by] = arr[ax][ay];
        arr[ax][ay] = temp;
    }

    // 최대값 찾기
    static int findMax() {
        int max = 0;

        // 행 확인
        for (int i = 0; i < N; i++) {
            int cnt = 1;    // 이부분 첨에 틀렸음(저번에도 한번 틀림)
            for (int j = 1; j < N; j++) {
                if (arr[i][j] == arr[i][j - 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        // 열 확인
        for (int j = 0; j < N; j++) {
            int cnt = 1;
            for (int i = 1; i < N; i++) {
                if (arr[i][j] == arr[i - 1][j]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        return max;
    }
}
