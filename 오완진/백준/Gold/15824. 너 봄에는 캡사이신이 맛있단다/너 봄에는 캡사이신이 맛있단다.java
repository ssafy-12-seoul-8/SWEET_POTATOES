import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int mod = 1_000_000_007;
	
	static int N, sum;
	static int[] food;
	
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int N = sc.nextInt();
    	
    	int[] food = new int[N + 1];
    	for (int i = 1; i <= N; i++)
    		food[i] = sc.nextInt();
    	
    	Arrays.sort(food);
    	
    	long sum = 0;
    	
    	for (int i = 1; i <= N; i++) {
    		int cntL = i - 1;
    		int cntR = N - i;
    		
    		long powL = pow(cntL);
    		long powR = pow(cntR);
    		
    		long maxScovile = food[i] * (powL - 1);
    		long minScovile = food[i] * (powR - 1);
    		
    		sum = (sum + maxScovile - minScovile + mod) % mod;
    	}
    	
    	System.out.println(sum);
	}
    
    static long pow(int k) {
    	if (k == 0)
    		return 1;
    	if (k % 2 == 0) {
    		long half = pow(k / 2);
    		return (half * half) % mod;
    	} else
    		return (2 * pow(k - 1)) % mod;
    }
}