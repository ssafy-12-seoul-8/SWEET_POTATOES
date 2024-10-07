import java.io.*;
import java.util.*;
	
public class Main {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long base = Long.parseLong(st.nextToken());
		long exp = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());
			
		System.out.println(pow(base, exp, c));
	}
		
	static long pow(long base, long exp, long c) {			
		if (exp == 1) {
			return base % c;
		}
			
		long temp = pow(base, exp / 2, c);
		long prob = temp * temp % c;
			
		return exp % 2 == 1 ? prob * base % c : prob;
	}
	
}
