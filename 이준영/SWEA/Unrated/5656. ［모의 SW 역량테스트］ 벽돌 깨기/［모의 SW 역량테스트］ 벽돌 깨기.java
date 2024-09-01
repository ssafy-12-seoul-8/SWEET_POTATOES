import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int H;
	static int W;
	static int N;
	static int min_count;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1 ; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			arr = new int[H][W];
			min_count=181;
			int[] a = new int[N];
			
			for(int i=0;i<H;i++)
			{
				st = new StringTokenizer(br.readLine());
				
				for(int j=0;j<W;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			btk(0,a);
			
			sb.append("#").append(tc).append(" ").append(min_count).append("\n");
			
		}
		System.out.println(sb);
	}
	
	static void btk(int len, int[] state) {
		
		if(len==N) {
			check(state);
			return;
		}
		
		for(int i = 0 ; i<W ; i++) {
			state[len] = i;
			btk(len+1, state);
		}
		
	}
	static void check(int[] state) {
		int count = 0;
		int[][] b = new int[H][W];
		int[][] c = new int[H][W];
		
		for (int i=0; i<H;i++) {
			for(int j=0;j<W;j++) {
				b[i][j] = arr[i][j];
				c[i][j] = arr[i][j];
			}
		}
		
		for(int l=0;l<N;l++) {
			int j = state[l];
			boolean[][] visited = new boolean[H][W];
			Stack<int[]> stack2 = new Stack<>();
			
			for(int i = 0; i < H; i++) {
				if(b[i][j]!=0) {
					stack2.push(new int[] {i,j});
					break;
				}
			}
			while(!stack2.isEmpty()) {
				
				int[] tmp = stack2.pop();
				int y = tmp[0];
				int x = tmp[1];
				
				if(!visited[y][x]) {
					
					visited[y][x] = true;
					c[y][x] = 0;
					
					for(int i=1 ; i<b[y][x];i++) {
						for(int k=0;k<4;k++) {
							
							int ny = y + dy[k]*i;
							int nx = x + dx[k]*i;
							
							if(0<=nx && nx<W && 0<=ny && ny<H && !visited[ny][nx] && b[ny][nx]!=0) {
								stack2.push(new int[] {ny,nx});
							}
						}
					}
				}
			}
//			for(int i = 0 ;i<H;i++) {
//				for(j = 0;j<W;j++) {
//					System.out.print(c[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			for(j = 0 ; j < W ; j++) {
				Stack<Integer> stack = new Stack<>();
				
				for(int i = 0; i<H ; i++) {
					b[i][j] = 0;
					if(c[i][j]!=0) {
						stack.push(c[i][j]);
						c[i][j] = 0;
						b[i][j] = 0;
					}
				}
				int stack_len = stack.size();
				for(int i = H-1 ; i>H-1-stack_len;i--) {
					c[i][j] = stack.pop();
					b[i][j] = c[i][j];
				}
			}
//			for(int i = 0 ;i<H;i++) {
//				for(j = 0;j<W;j++) {
//					System.out.print(b[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		for(int i = 0 ;i<H;i++) {
			for(int j = 0;j<W;j++) {
				if(c[i][j]!=0) {
					count+=1;
				}
			}
		}
		if (min_count>count) {
			min_count = count;
		}
		
	}
}
