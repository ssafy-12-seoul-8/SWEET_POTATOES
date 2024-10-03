import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] arr = new String[N];
		int[] power = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken();
			power[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(br.readLine());
			int start = 0;
			int end = N - 1;
			while (start < end) {
				int mid = (start + end) / 2;
				if(power[mid]<num) {
					start = mid+1;
				} else {
					end = mid;
				}
			}
			
			sb.append(arr[end]).append("\n");
		}
		
		System.out.println(sb);
	}
}
