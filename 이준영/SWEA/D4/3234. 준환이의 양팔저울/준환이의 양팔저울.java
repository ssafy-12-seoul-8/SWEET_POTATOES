import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int N, cnt, sum;
    static int[] m;
    static int[] pow= {1,2,4,8,16,32,64,128,256,512};
    static int[] fac= { 0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(in.readLine());
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(in.readLine());
            m = new int[N];
            cnt = 0;
            sum = 0;

            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            for (int i = 0; i < N; i++) {
                m[i] = Integer.parseInt(st.nextToken());
                sum += m[i];
            }
            Arrays.sort(m);
            recur(0, 0, 0, 0,sum);
            answer.append('#').append(tc + 1).append(' ').append(cnt).append('\n');
        }

        System.out.print(answer);
        in.close();
    }

    private static void recur(int index, int left, int right, int flag,int remain) {
        if (index == N) {
            cnt++;
            return;
        }
    	if (remain+right<=left) {
        	cnt+=pow[N-index]*fac[N-index];
        	return;
        }

        for (int i = N-1; i >=0; i--) {
            if ((flag&(3<<(2*i))) == 0) { // 아직 사용되지 않은 추라면
                recur(index + 1, left + m[i], right, flag | (1 << (2 * i)),remain-m[i]);  // 왼쪽에 놓기
                if (left>=right+m[i]) {
                	recur(index + 1, left, right + m[i], flag | (2 << (2 * i)),remain-m[i]);  // 오른쪽에 놓기
                }
            }
        }
    }
}
