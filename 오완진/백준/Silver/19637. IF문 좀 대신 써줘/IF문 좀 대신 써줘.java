import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] firstLine = br.readLine().split(" ");
        int N1 = Integer.parseInt(firstLine[0]);
        int N2 = Integer.parseInt(firstLine[1]);
        
        String[] titles = new String[N1];
        int[] limits = new int[N1];
        HashSet<Integer> check = new HashSet<>();
        
        int idx = 0;
        for (int i = 0; i < N1; i++) {
            String line = br.readLine();
            String[] splits = line.split(" ");
            int limit = Integer.parseInt(splits[1]);
            
            // 중복값 제거
            // 이거로도 시간초과 떠서 버퍼드리더 가져옴
            if (!check.contains(limit)) {
                check.add(limit);
                titles[idx] = splits[0];
                limits[idx] = limit;
                idx++;
            }
        }
        
        for (int i = 0; i < N2; i++) {
            int power = Integer.parseInt(br.readLine());
            
            int L = 0;
            int R = idx - 1;
            while (L <= R) {
                int M = (L + R) / 2;
                if (limits[M] < power)
                    L = M + 1;
                else
                    R = M - 1;
            }
            
            sb.append(titles[L]).append("\n");
        }
        
        System.out.print(sb);
    }
}
