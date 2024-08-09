import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {
        	
        	int N = sc.nextInt();
        	int[] danjo = new int[N];
        	for (int i = 0; i < N; i++) {
        		danjo[i] = sc.nextInt();
        	}
        	
        	int max = -1;
        	for (int i = 0; i < N - 1; i++) {
        		for (int j = i + 1; j < N; j++) {
        			int num = isDanjo(danjo[i], danjo[j]);
        			max = Math.max(max, num);
        		}
        	}
        	
        	System.out.println("#" + tc + " " + max);
        }
    }
    	
    static int isDanjo(int a, int b) {
    	
    	int c = a * b;
    	int[] jaritsu = new int[10];
    	
    	int j = 0;
    	for (int i = 1000000000; i > 0; i /= 10) {
    		jaritsu[j++] = c / i;
    		c %= i;
    	}
    	
    	for (int i = 0; i < jaritsu.length - 1; i++) {
    		if (jaritsu[i] > jaritsu[i+1]) {
    			return -1;
    		}
    	}
    	return a * b;
    }
    
}