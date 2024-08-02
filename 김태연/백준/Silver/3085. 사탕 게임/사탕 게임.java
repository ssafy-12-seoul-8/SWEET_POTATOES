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

        // 브루트포스 방법을 사용하여 모든 경우의 수를 확인
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                // 오른쪽과 자리바꿈
                swap(i, j, i, j + 1);
                max = Math.max(max, findMax());
                swap(i, j, i, j + 1); // 원위치
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                // 아래쪽과 자리바꿈
                swap(i, j, i + 1, j);
                max = Math.max(max, findMax());
                swap(i, j, i + 1, j); // 원위치
            }
        }

        System.out.println(max);
    }

    static void swap(int x1, int y1, int x2, int y2) {
        char temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
    }

    static int findMax() {
        int max = 0;

        // 행 확인
        for (int i = 0; i < N; i++) {
            int cnt = 1;
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
