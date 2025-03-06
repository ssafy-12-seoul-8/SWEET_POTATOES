import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String[] led = {
        "1111110",
        "0110000",
        "1101101",
        "1111001",
        "0110011",
        "1011011",
        "1011111",
        "1110000",
        "1111111",
        "1111011" 
    };
    
    public static void main(String[] args) throws IOException {
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        int[][] diff = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            	
                int cost = 0;
                for (int k = 0; k < 7; k++)
                    if (led[i].charAt(k) != led[j].charAt(k))
                        cost++;
                
                diff[i][j] = cost;
            }
        }
        
        String xStr = formatZero(X, K);
        int cnt = 0;
        
        for (int n = 1; n <= N; n++) {
        	
            if (n == X) continue;
            
            String checkStr = formatZero(n, K);
            int totalCost = 0;
            
            for (int i = 0; i < K; i++) {
                int xDigit = xStr.charAt(i) - '0';
                int cDigit = checkStr.charAt(i) - '0';
                totalCost += diff[xDigit][cDigit];
            }
            
            if (totalCost >= 1 && totalCost <= P)
                cnt++;
        }
        
        System.out.println(cnt);
    }
    
    static String formatZero(int x, int k) {
        String str = Integer.toString(x);
        char[] arr = new char[k];
        int idx = 0;
        int len = str.length();
        
        for (int i = 0; i < k - len; i++)
            arr[idx++] = '0';

        for (int i = 0; i < len; i++)
            arr[idx++] = str.charAt(i);

        return new String(arr);
    }
}