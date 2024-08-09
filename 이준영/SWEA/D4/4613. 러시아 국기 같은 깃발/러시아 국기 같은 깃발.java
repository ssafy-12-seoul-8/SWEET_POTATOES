
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
			int min_count=2501;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] state = new char[N][M];
			int[][] color = new int[N][3];	  // i행을 특정색으로 바꾸기 위해 필요한 칸의수
			int[][] color2 = new int[N+1][3];  // 위의 것을 누적합으로 바꾼 배열
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for (int j=0;j<M;j++) {
					char ch=str.charAt(j);
					state[i][j] = ch;
					switch(ch) {
						case 'W':
							color[i][1]+=1;
							color[i][2]+=1;
							break;
						case 'B':
							color[i][0]+=1;
							color[i][2]+=1;
							break;
						case 'R':
							color[i][0]+=1;
							color[i][1]+=1;
					}
				}
			}	
			for (int i=1;i<N+1;i++) {
				for (int j=0;j<3;j++) {
					color2[i][j]=color2[i-1][j]+color[i-1][j];
				}
			}
			for (int i=0;i<N-2;i++) {
				for(int j=i+1;j<N-1;j++) {
						int count = color2[i+1][0]+color2[j+1][1]-color2[i+1][1]+color2[N][2]-color2[j+1][2];
						if (min_count>count)
							min_count=count;
							
				}
			}
			sb.append('#').append(tc).append(' ').append(min_count).append('\n');
		}
		System.out.println(sb);
	}
		
}
	
