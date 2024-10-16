import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static long finalLeft, finalRight;
	static long[] acid;
	static long result = Long.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		acid = new long[N];
		for (int i=0; i<N; i++) {
			acid[i] = Long.parseLong(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(acid);
		
		// 확인
//		System.out.println(Arrays.toString(acid));
		search(0 , N-1);
		
		System.out.println(finalLeft + " " + finalRight);
		
	}
	
	private static void search(int left, int right) {
		// 0 ~ N-1 까지 검사하는데
		// 인덱스가 만난다면, 종료
		
		// 등호는 빼야하는가?
		while (left < right) {
			long sum = acid[left] + acid[right];
			long diff = Math.abs(sum);
			// 이번시행이 누적기록의 result 보다 작을때
			if (diff < result) {
				result = diff;
				finalLeft = acid[left];
				finalRight = acid[right];
			}
			
			if (sum > 0) {
				right--;
			} else if (sum < 0) {
				left++;
			} else {	// 합이 0일때
				return;
			}
		}
	}
	
}
