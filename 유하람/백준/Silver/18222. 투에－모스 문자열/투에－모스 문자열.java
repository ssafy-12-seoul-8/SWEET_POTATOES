import java.util.Scanner;

public class Main {
	
	static long[] pow = new long[61];
	
	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		
		long k = sc.nextLong();
		
		pow[0] = 1;
		
		for(int i=1 ; i<=60 ; i++) {
			pow[i] = 2*pow[i-1]; 
		}
		
		long answer = toemos(k);
		
		System.out.println(answer);
	}

	private static long toemos(long k) {

		if(k==1)
			return 0;
		
		for(int i=1 ; i<61 ; i++) {
			if(pow[i] >= k) {
				return 1-toemos(k-pow[i-1]);
			}
		}
		
		return 0;
			
	}


}
