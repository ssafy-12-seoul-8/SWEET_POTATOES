import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[] dx = {-1,0,1,0}; // 좌, 상, 우, 하
		int[] dy = {0,-1,0,1}; 
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] field = new char[H][W];
			int direction = 0;
			int x=0;
			int y=0;
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for(int j=0;j<W;j++) {
					field[i][j]=str.charAt(j);
					if(field[i][j]=='<') {
						y=i;
						x=j;
						direction = 0;
					} else if(field[i][j]=='^') {
						y=i;
						x=j;
						direction = 1;
					} else if(field[i][j]=='>') {
						y=i;
						x=j;
						direction = 2;
					} else if(field[i][j]=='v') {
						y=i;
						x=j;
						direction = 3;
					}
				}
			}
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int i=0;i<N;i++) {
				char ch = str.charAt(i);
				switch (ch){
					case 'U':
						direction = 1;
						field[y][x]='^';
						if (0<=y-1 && field[y-1][x]=='.') {
							field[y-1][x] = '^';
							field[y][x]='.';
							y=y-1;
						}
						break;
					case 'D':
						direction = 3;
						field[y][x] = 'v';
						if (y+1<H && field[y+1][x]=='.') {
							field[y+1][x] = 'v';
							field[y][x]='.';
							y=y+1;
						}
						break;
					case 'L':
						direction = 0;
						field[y][x] = '<';
						if (0<=x-1 && field[y][x-1]=='.') {
							field[y][x-1] = '<';
							field[y][x]='.';
							x=x-1;
						}
						break;
					case 'R':
						direction = 2;
						field[y][x] = '>';
						if (x+1<W && field[y][x+1]=='.') {
							field[y][x+1] = '>';
							field[y][x]='.';
							x=x+1;
						}
						break;
					case 'S':
						int b_y = y;
						int b_x = x;
						while(0<=b_y && b_y<H && 0<=b_x && b_x<W && field[b_y][b_x]!='*'&&field[b_y][b_x]!='#') {
							b_y = b_y + dy[direction];
							b_x = b_x + dx[direction];
						}
						if(0<=b_y && b_y<H && 0<=b_x && b_x<W) {

							if(field[b_y][b_x]=='*'){
								field[b_y][b_x]='.';
							}
						}
						break;			
				}
			}
			sb.append("#").append(tc).append(" ");
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					sb.append(field[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
