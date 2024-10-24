import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 회의의 수 1<= N <= 100000
		int N = Integer.parseInt(br.readLine());
		
		// 회의 정보
		int[][] meeting = new int[N][2];
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meeting, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1]>o2[1]) {
					return 1;
				}else if(o1[1]<o2[1]) {
					return -1;
				}else {
					if(o1[0]>o2[0]) {
						return 1;
					}else {
						return -1;
					}
				}
			}
			
		});
		
		int cnt = 0;
		int end = 0;
		
		for(int[] curr : meeting) {
			if(end>curr[0]) continue;
			cnt++;
			end = curr[1];
		}
		
		System.out.println(cnt);

	} // main


}
// Main class
