import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] solution = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0 ; i<N ; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(solution);
		
		
		int L = 0;
		int R = N-1;
		long min = 2000000000;
		Map<Long,int[]> map = new HashMap<>();
		
		while(L<R) {
			long sum = solution[L] + solution[R];
			min = Math.min(Math.abs(min), Math.abs(sum));
			map.put(Math.abs(sum), new int[] {L,R});
			
			if(sum>0) {
				R--;
			}else if(sum<0) {
				L++;
			}else {
				break;
			}
			
		}
		
		long ans1 = solution[map.get(min)[0]];
		long ans2 = solution[map.get(min)[1]];
		
		System.out.println(ans1+" "+ans2);
		
		
	} // main

} // Main class