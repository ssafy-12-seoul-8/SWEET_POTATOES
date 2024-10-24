import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		
		String word = br.readLine();
		
		int r = 31;
		long mod = 1234567891;
		long[] memo = new long[L];
		memo[0] = 1;
		
		for(int i=1 ; i<L ; i++) {
			memo[i] = memo[i-1]*r;
			memo[i] %= mod;
		}
		
		long ans = 0;
		
		for(int i=0 ; i<L ; i++) {
			ans += ((word.charAt(i)-'a'+1)*memo[i])%mod;
			ans %= mod;
		}
		
		System.out.println(ans);

	} // main



} // Main class