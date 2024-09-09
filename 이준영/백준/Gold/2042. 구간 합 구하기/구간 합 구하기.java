import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[][] arr;
	static long[] arr2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		arr = new long[4 * N][3];
		arr2 = new long[N+1];

		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			arr2[i] = Long.parseLong(st.nextToken());
		}

		start(1, 1, N);

		for (int i = 0; i < M + K; i++) {

			st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				change(b, c, 1, 1, N);
			} else {
				sb.append(sum(b,c,1,1,N)).append("\n");
			}
		}
		System.out.println(sb);

	}

	public static void start(int index, int left, int right) {
		if (left == right) {
			arr[index] = new long[] { arr2[left], left, right };
			return;
		}
		int mid = (left + right) / 2;
		start(index * 2, left, mid);
		start(index * 2 + 1, mid + 1, right);
		arr[index] = new long[] { arr[index * 2][0] + arr[index * 2 + 1][0], left, right };
	}

	public static void change(long num, long mini, int index, int start, int end) {
		if (start == end) {
			arr[index][0] = mini;
			return;
		}
		int mid = (start + end) / 2;
		if (num <= mid) {
			change(num, mini, index * 2, start, mid);
		} else {
			change(num, mini, index * 2 + 1, mid + 1, end);
		}
		arr[index][0] = arr[index * 2][0] + arr[index * 2 + 1][0];
		return;
	}
	public static long sum(long num_s, long num_e, int index, int start, int end) {
		if(num_e<start) {
			return 0;
		}
		if(num_s>end) {
			return 0;
		}
		if(num_s<=start && end<=num_e) {
			return arr[index][0];
		}
		int mid = (start + end) / 2;
		return sum(num_s,num_e,index*2,start,mid)+sum(num_s,num_e,index*2+1,mid+1,end);
	}
}
