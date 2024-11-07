import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, TC, start, end;
	static long tmp1, tmp2, score;
	static long[] sums1, sums2;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		TC = Integer.parseInt(st.nextToken());
		
		tmp1 = 0;
		tmp2 = 0;
		sums1 = new long[N + 1];
		sums2 = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int num = Integer.parseInt(st.nextToken());
			tmp1 += num;
			tmp2 += num * num;
			sums1[i] = tmp1;
			sums2[i] = tmp2;
		}
		
		for (int tc = 1; tc <= TC; tc++) {
			
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			score = (sums1[end] - sums1[start - 1]) * (sums1[end] - sums1[start - 1]);
			score -= (sums2[end] - sums2[start - 1]);
			score /= 2;

			sb.append(score).append("\n");
		}//tc
		
		System.out.println(sb);
	}
}