import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static boolean[] on;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] switches = new int[n][m];
        int[] offNum = new int[n];
        on = new boolean[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            on[i] = true;

            for (int j = 0; j < m; j++) {
                switches[i][j] = line.charAt(j) - '0';

                if (switches[i][j] == 0) {
                    offNum[i] += 1;

                    if (on[i]) {
                        on[i] = false;
                    }
                }
            }

            if (on[i]) {
                max++;
            }
        }

        int k = Integer.parseInt(br.readLine());

        if (k % 2 != 0) {
            max = 0;
        }

        for (int i = 0; i < n; i++) {
            int rowEven = offNum[i] % 2;
            int kEven = k % 2;

            if (rowEven != kEven || on[i] || offNum[i] > k) {
                continue;
            }

            int[][] copied = new int[n][m];

            for (int j = 0; j < n; j++) {
                copied[j] = Arrays.copyOf(switches[j], switches[j].length);
            }

            for (int j = 0; j < m; j++) {
                if (copied[i][j] != 0) {
                    continue;
                }

                copied[i][j] = 1;

                for (int l = 0; l < n; l++) {
                    if (i == l) {
                        continue;
                    }

                    copied[l][j] = (copied[l][j] + 1) % 2;
                }
            }

            max = Math.max(max, calculateMax(copied));
        }

        System.out.println(max);
    }

    static int calculateMax(int[][] switches) {
        int max = 0;

        for (int i = 0; i < n; i++) {
            boolean isOn = true;

            for (int j = 0; j < m; j++) {
                if (switches[i][j] == 0) {
                    isOn = false;

                    break;
                }
            }

            if (isOn) {
                on[i] = true;
                max++;
            }
        }

        return max;
    }

}

/*
시간 복잡도
- N = 50, M = 50, K = 1000
- O(2^M) = O(2^50) = 너무 큼
- O(N^3) = O(50^3) = O(125000) -> 이 정도로 생각할 수 있을 듯
- O(N^4) = O(50^4) -> 이 정도가 맥스일 듯

접근
- 모든 열의 스위치 경우의 수 조합 -> O(2^M) -> 시간 초과 예상
- 행 별로 0의 개수가 있을 것 => 행 별로 각 0을 켜거나 껐을 때 탁자의 상태로 판단 가능
- 행 별로 0개수랑 k가 짝수 / 0개수랑 k가 홀수 -> 그 행은 켜질 수 있음 => 홀짝이 나뉘는 경우 한 번 더 키거나 꺼야하기 때문에 해당 행은 켜질 수 없음
- 행 별로 루프(N)돌며 행의 0 개수 파악 -> 홀짝이 맞을 경우 0을 모두 켜서(N) 해당 열의 모든 스위치 전환(M) -> O(NNM) = O(125000) => 0의
 개수가 맞는 행만 켜도 될 것 같음
- 이미 확인했던 행과 같은 구성의 행의 스위치 작업을 하면 불필요할 수 있음 -> 해당 행이 켜졌었는지 캐싱 가능할지? => 켜졌었는지 행 별 flag를 설정하면 될 듯
*/