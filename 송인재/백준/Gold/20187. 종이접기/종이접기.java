import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static int holeNum; //구멍 뚫는 위치
    static char lastHor, lastVer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * k; i++) {
            char fold = st.nextToken().charAt(0);
            if (fold == 'D' || fold == 'U') {
                lastHor = fold; //마지막 가로 접기
            } else {
                lastVer = fold; //마지막 세로 접기
            }
        }

        holeNum = Integer.parseInt(br.readLine());

        // 2x2에서의 왼쪽 위 위치로 구멍 위치 변경
        if (lastVer == 'L' && lastHor == 'U') { //1. 왼쪽 위로 마지막으로 접힌 경우
            holeNum = holeNum;
        }
        if (lastVer == 'R' && lastHor == 'U') { //2. 오른쪽 위로 마지막으로 접힌 경우
            holeNum = ver(holeNum);
        }
        if (lastVer == 'L' && lastHor == 'D') { //3. 왼쪽 아래로 마지막으로 접힌 경우
            holeNum = hor(holeNum);
        }
        if (lastVer == 'R' && lastHor == 'D') { //4. 오른쪽 아래로 마지막으로 접힌 경우
            holeNum = hor(ver(holeNum));
        }

        int one = holeNum; // 2x2에서의 왼쪽 위 위치
        int two = ver(holeNum); // 2x2에서의 오른쪽 위 위치
        int three = hor(holeNum); // 2x2에서의 왼쪽 아래 위치
        int four = hor(ver(holeNum)); // 2x2에서의 오른쪽 아래 위치

        //결국에는 2x2 구멍 4개의 반복
        for (int i = 0; i < Math.pow(2, k); i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < Math.pow(2, k - 1); j++) {
                    System.out.print(one + " ");
                    System.out.print(two + " ");
                }
                System.out.println();
            } else {
                for (int j = 0; j < Math.pow(2, k - 1); j++) {
                    System.out.print(three + " ");
                    System.out.print(four + " ");
                }
                System.out.println();
            }
        }
    }

    //세로 대칭 구멍 위치
    private static int ver(int holeNum) {
        if (holeNum == 0) return 1;
        if (holeNum == 1) return 0;
        if (holeNum == 2) return 3;
        return 2;
    }

    //가로 대칭 구멍 위치
    private static int hor(int holeNum) {
        if (holeNum == 0) return 2;
        if (holeNum == 1) return 3;
        if (holeNum == 2) return 0;
        return 1;
    }
}