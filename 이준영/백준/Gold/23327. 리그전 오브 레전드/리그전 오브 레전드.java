import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		long[] num = new long[N + 1];
		long[] presum = new long[N + 1];
		long[] multisum = new long[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			num[i] = Long.parseLong(st.nextToken());
			presum[i] = presum[i - 1] + num[i];
			multisum[i] = multisum[i - 1] + num[i] * presum[i - 1];
		}

		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Long c = multisum[b] - multisum[a-1] - (presum[a-1]*(presum[b]-presum[a-1]));
			sb.append(c).append("\n");
		}
		System.out.println(sb);
	}
}
