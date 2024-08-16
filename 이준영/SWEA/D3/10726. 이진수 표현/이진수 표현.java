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
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			boolean check = true;
			while(N>0) {
				if(M%2==0) {
					check=false;
					break;
				}
				M=M/2;
				N=N-1;
			}
			sb.append("#").append(tc).append(" ");
			if(check) {
				sb.append("ON").append("\n");
			} else {
				sb.append("OFF").append("\n");
			}
		}
		System.out.println(sb);
	}
}
