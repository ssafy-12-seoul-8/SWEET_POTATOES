import java.io.*;
import java.util.*;

public class Main {

    static int roundResult;
    static int[][] stats;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int round = 4;
        int teams = 6;
        stats = new int[teams][3];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < round; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            roundResult = 0;
            boolean notPossible = false;

            for (int j = 0; j < teams; j++) {
                int sum = 0;

                for (int k = 0; k < 3; k++) {
                    stats[j][k] = Integer.parseInt(st.nextToken());
                    sum += stats[j][k];
                }

                if (sum != 5) {
                    notPossible = true;
                    break;
                }
            }

            if (notPossible) {
                sb.append(roundResult)
                    .append(" ");
                
                continue;
            }

            backtrack(0, 1);
            sb.append(roundResult)
                .append(" ");
        }

        System.out.println(sb);
    }

    static void backtrack(int home, int away) {
        if (roundResult == 1) {
            return;
        }

        if (home == 5) {
            roundResult = 1;

            return;
        }

        if (stats[home][0] - 1 >= 0 && stats[away][2] - 1 >= 0) {
            stats[home][0] -= 1;
            stats[away][2] -= 1;

            if (away == 5) {
                backtrack(home + 1, home + 2);
            } else {
                backtrack(home, away + 1);
            }

            stats[home][0] += 1;
            stats[away][2] += 1;
        }

        if (stats[home][1] - 1 >= 0 && stats[away][1] - 1 >= 0) {
            stats[home][1] -= 1;
            stats[away][1] -= 1;

            if (away == 5) {
                backtrack(home + 1, home + 2);
            } else {
                backtrack(home, away + 1);
            }

            stats[home][1] += 1;
            stats[away][1] += 1;
        }

        if (stats[home][2] - 1 >= 0 && stats[away][0] - 1 >= 0) {
            stats[home][2] -= 1;
            stats[away][0] -= 1;

            if (away == 5) {
                backtrack(home + 1, home + 2);
            } else {
                backtrack(home, away + 1);
            }

            stats[home][2] += 1;
            stats[away][0] += 1;
        }
    }

}

/*
시간 복잡도
- 6팀이 각각 승, 무, 패가 3가지 경우 가능 -> 3^6 = 729 -> 복잡한 고려 안해도 완전탐색으로 충분히 가능해보임

접근
- 총 진행 경기는 한 팀이 5팀과 각각 경기를 하니 6 * 5 / 2 = 15
- A가 B에 승, 무, 패, C에 승, 무, 패, ... F에 승, 무, 패 이후 B가 C에 승, 무, 패...E까지 반복하면 모든 경우의 수 탐색
- A가 B에 승 -> A가 C에 승...-> A가 F에 승 -> A가 다섯 경기를 치뤘으니 B가 C에승 -> B가 D에 승... -> E까지 반복
- 시작 -> A부터 남은 경기 확인 -> 남은 경기가 있는 팀부터 진행
 */