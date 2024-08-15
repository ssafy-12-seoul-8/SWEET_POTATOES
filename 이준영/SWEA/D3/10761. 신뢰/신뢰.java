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
			int len = Integer.parseInt(st.nextToken());
			int o_loc = 1;
			int b_loc = 1;
			int o_time = 0;
			int b_time = 0;
			int time = 0;
			char color= 'B';
			for(int i=0;i<len;i++) {
				char b = st.nextToken().charAt(0);
				int a = Integer.parseInt(st.nextToken());
				if (b=='B') {
					int add_time=Math.abs(a-b_loc);
					if (color=='B') {
						time +=(add_time+1);
						o_time+=(add_time+1);
					} else if (b_time>add_time){
						o_time+=1;
						time+=1;
						color='B';
					} else {
						time+=(add_time-b_time+1);
						o_time+=(add_time-b_time+1);
						color='B';
					}
					b_time=0;
					b_loc=a;
				} else {
					int add_time=Math.abs(a-o_loc);
					if (color=='O') {
						time +=(add_time+1);
						b_time+=(add_time+1);
					} else if (o_time>add_time){
						b_time+=1;
						time+=1;
						color='O';
					} else {
						time+=(add_time-o_time+1);
						b_time+=(add_time-o_time+1);
						color='O';
					}
					o_time=0;
					o_loc=a;
				}
			}
			sb.append("#").append(tc).append(" ").append(time).append("\n");
		}
		System.out.println(sb);
	}
}

