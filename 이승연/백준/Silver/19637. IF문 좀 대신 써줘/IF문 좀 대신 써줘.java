import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	
	static String[] NAME;
	static int[] POWER;
	
	static int[] test = {100, 100, 1000};
	static int target = 1000;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		NAME = new String[N];
		POWER = new int[N];
		
		for (int i = 0, idx = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			NAME[idx] = st.nextToken();
			POWER[idx] = Integer.parseInt(st.nextToken());
			idx++;
		}
		
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(br.readLine());
			
			int left = 0;
			int right = N - 1;
			
			while(left <= right) {
				int mid = (left + right) / 2;
				
				if (left == right) {
					break;
				}
				
				if (num <= POWER[mid]) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}
			
			System.out.println(NAME[left]);
		}
		
		br.close();
		
	}

}
