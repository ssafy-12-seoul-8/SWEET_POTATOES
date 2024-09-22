import java.util.Scanner;

public class Main {
	
	static long N;
	static final long M = 1_000_000_007;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextLong();
		
		long[] result = fibo(N);
		System.out.println(result[0]);
		
	}
	
	static long[] fibo(long n) {
		if (n == 0)
			return new long[] {0, 1};

		/*
		 * fb(2k) = fb(k)*(2fb(k+1) - fb(k))
		 * fb(2k+1) = fb(k+1)^2 + fb(k))^2
		 */
		
		long[] newFibb = fibo(n / 2);
		
		long fbK = newFibb[0];
		long fbKplus1 = newFibb[1];
		
        long fb2K = (fbK * ((2 * fbKplus1 % M - fbK + M) % M)) % M;
        long fb2Kplus1 = (fbKplus1 * fbKplus1 % M + fbK * fbK % M) % M;
        
        if (n % 2 == 0)
        	return new long[] {fb2K, fb2Kplus1};
        else
        	return new long[] {fb2Kplus1, (fb2K + fb2Kplus1) % M};
    }
	
}