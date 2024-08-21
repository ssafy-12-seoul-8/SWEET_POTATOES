import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N;
    public static int M;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[M];
        
        // btk를 호출할때마다 한칸씩 더 깊게 들어감
        btk(0);
        
        System.out.print(sb.toString());
    }

    public static void btk(int depth) { 
        // M에 도착하면 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");  // 줄바꿈
            return;
        }
        
        // 아직 M에 도착하지 않았으면 한칸 더 깊게 들어감
        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            btk(depth + 1);
        }
    }
}
