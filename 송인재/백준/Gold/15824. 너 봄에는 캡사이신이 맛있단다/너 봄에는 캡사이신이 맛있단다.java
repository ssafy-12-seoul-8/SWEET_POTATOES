import java.io.*;
import java.util.*;
	
public class Main {
	
	static int div = 1_000_000_007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] scovilles = new long[n];
		int[] power = new int[n];
		power[0] = 1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			scovilles[i] = Long.parseLong(st.nextToken());
			
			if (i > 0) {
				power[i] = (power[i - 1] * 2) % div;
			}
		}
		
		Arrays.sort(scovilles);
		
		long total = 0;
		
		for (int i = 0; i < n; i++) {
			int whenMax = power[i];
			int whenMin = power[n - 1 - i];
			
			total += scovilles[i] * (whenMax - whenMin);
			total %= div;
		}
		
		System.out.println(total);
	}
	
}
