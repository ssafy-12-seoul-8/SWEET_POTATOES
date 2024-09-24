import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int start = 0;		// 히터가 놓일 수 있는 위치 중 가장 왼쪽 인덱스
		int end = N - 1;	// 히터가 놓일 수 있는 위치 중 가장 오른쪽 인덱스
		
		while (end - start > 1) {
			
			int mid = (end + start) / 2;
			long max = 0;
			int max_index = mid;
			
			for (int i = 0; i < N; i++) {
				long a = Math.abs((i - mid) * arr[i]);
				if (a > max) {
					max = a;
					max_index = i;
				}
			}
			
			if (max_index > mid) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		long min = 150000000001l;
		
		for (int i = -1; i < 3; i++) { 	// 그냥 start와 end주변을 다 처리하기 위해 이렇게 했으나 start와 end만 해도 될듯 
			int tmp = start + i;		// 아니면 이분 탐색의 max를 활용해서 지금까지 최소 시간을 저장해서 하는 방법도 좋음
			long max = 0;
			
			for (int j = 0; j < N; j++) {
				long a = Math.abs((j - tmp) * arr[j]);
				if (a > max) {
					max = a;
				}
			}
			if (min > max) {
				min = max;
			}
		}
		System.out.println(min);

	}
}
