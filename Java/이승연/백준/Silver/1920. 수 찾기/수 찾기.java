import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
        	targets[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < M; i++) {
        	int left = 0;
        	int right = N - 1;
        	
        	boolean isFound = false;
        	
        	while(left <= right) {
        		int mid = (left + right) / 2;
        		
        		if (targets[i] == nums[mid]) {
        			isFound = true;
        			break;
        		}
        		
        		if (targets[i] < nums[mid]) {
        			right = mid - 1;
        		} else {
        			left = mid + 1;
        		}
        	}
        	
        	if (isFound) {
        		sb.append("1\n");
        	} else {
        		sb.append("0\n");
        	}
        
        }
        
        System.out.println(sb);
    }
}