import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        
        long left = 1;
        long right = K;
        
        while(left < right) {
        	long mid = (left + right) / 2;
        	long count = 0;
        	
        	for (int num = 1; num <= N; num++) {
        		count += Math.min((mid / num), N);
        	}
        	
        	// System.out.println("left : " + left + ", right : " + right);
        	// System.out.println(mid + ", " + count);
        	
        	if (K <= count) {
    			right = mid;
    		}
        	else {
        		left = mid + 1;
        	}
        	
        }
        
        System.out.println(left);
        
    }
}