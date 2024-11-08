import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int[] popSum = new int[n];
		long[] popMul = new long[n];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < n; i++) {
			popSum[i] = Integer.parseInt(st.nextToken());
			popMul[i] = (long) popSum[i] * popSum[i];
			
			if (i > 0) {
				popSum[i] += popSum[i - 1];
				popMul[i] += popMul[i - 1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken()) - 1;
			
			long sum = popSum[r];
			long mul = popMul[r];
			
			if (l > 0) {
				sum -= popSum[l - 1];
				mul -= popMul[l - 1];
			}
			
			sb.append((sum * sum - mul) / 2)
				.append(System.lineSeparator());
		}
		
		System.out.print(sb);
	}
	
}