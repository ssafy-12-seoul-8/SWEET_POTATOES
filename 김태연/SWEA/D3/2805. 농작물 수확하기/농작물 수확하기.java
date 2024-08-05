import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt(); // 1

    for (int test_case = 1; test_case <= T; test_case++) {

        int N;
        N = sc.nextInt();
        int[][] arr = new int[N][N];
        String line;
        for (int i = 0; i < N; i++) {
            line = sc.next();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        // 입력 다 받았고, 합계 구해야함
        // 함수로 구하면 쉬울것같음

        int L = N/2;
//        System.out.println("L 값은 : " + L);
//        System.out.println("L+N 값은 : " + (L+N));
        int sum = 0;
        // (0,0) ~ (6,6)
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {

                if (y <= x + L && y >= x - L && y <= -x +L + N - 1 && y >= -x + L) {
//                    System.out.println(x + " , " + y + " 를 포함합니다");
                    sum += arr[x][y];
//                    System.out.println("sum : " + sum);
                }
            }
        }

        System.out.println("#" + test_case + " " + sum);
    }
}
}