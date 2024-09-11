import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] requests = new int[n];
        int left = 0;
        int right = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            requests[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, requests[i]);
        }
        
        int m = Integer.parseInt(br.readLine());
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int totalBudget = allocateBudget(requests, mid);
            
            if (totalBudget <= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(left - 1);
    }
    
    static int allocateBudget(int[] requests, int limit) {
        int sum = 0;
        
        for (int i = 0; i < requests.length; i++) {
            sum += requests[i] > limit ? limit : requests[i];
        }
        
        return sum;
    }
}