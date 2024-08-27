import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			int max_k=0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][2];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<(1<<N);i++) {
				int score=0;
				int cal=0;
				for(int j=0;j<N;j++) {
					if((i&(1<<j))>0) {
						score+=arr[j][0];
						cal+=arr[j][1];
					}
				}
				if (cal<=L && max_k<score)
					max_k=score;
			}
			sb.append("#").append(tc).append(" ").append(max_k).append("\n");
			
		}
		System.out.println(sb);
	}
}
