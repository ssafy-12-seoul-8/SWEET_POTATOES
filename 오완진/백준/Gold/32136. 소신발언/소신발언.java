import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine().trim());
        String line = reader.readLine().trim();

        String[] tokens = line.split(" ");
        int[] cows = new int[N];

        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(tokens[i]);
        }
        
	       
       /*
        * 아이디어
        * 찾은 소의 위치로부터 히터의 위치가 가까워지면 갱신
        * 찾은 소의 위치로부터 히터의 위치가 멀어지면 볼 필요없음
        */

        int L = 0;
        int R = N - 1;
        long minMaxMeltingTime = Long.MAX_VALUE;

        while (L <= R) {
            int H = (L + R) / 2;

            long maxMeltingTimeL = 0;
            for (int i = 0; i < H; i++) {
     		   long meltingTime = (long)Math.abs(H - i) * cows[i];
     		   maxMeltingTimeL = Math.max(maxMeltingTimeL, meltingTime);
            }

            long maxMeltingTimeR = 0;
            for (int i = H + 1; i < N; i++) {
     		   long meltingTime = (long)Math.abs(H - i) * cows[i];
     		   maxMeltingTimeR = Math.max(maxMeltingTimeR, meltingTime);
            }

            long maxMeltingTime = Math.max(maxMeltingTimeL, maxMeltingTimeR);
            minMaxMeltingTime = Math.min(minMaxMeltingTime, maxMeltingTime);

            if (maxMeltingTimeL > maxMeltingTimeR)
                R = H - 1;
            else
                L = H + 1;
        }

        System.out.println(minMaxMeltingTime);
    }
}