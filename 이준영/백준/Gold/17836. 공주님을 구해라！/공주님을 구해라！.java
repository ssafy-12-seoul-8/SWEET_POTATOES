import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		int minimum=T+1;
		int[][] arr = new int[N][M];
		Stack<int[]> stack = new Stack<>();
		boolean[][] visited = new boolean[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				
			}
		}
		int time=1;
		int[] v = {0,0};
		stack.push(v);
		visited[0][0]=true;
		outer:while(time<=T) {
			Stack<int[]> stack2 = new Stack<>();
			while(!stack.isEmpty()) {
				int[] tmp=stack.pop();
				for(int i=0;i<4;i++) {
					int ny = tmp[0]+dy[i];
					int nx = tmp[1]+dx[i];
					if(0<=ny&&ny<N&&0<=nx&&nx<M&&!visited[ny][nx]&&arr[ny][nx]!=1) {
						visited[ny][nx]=true;
						if(ny==N-1&&nx==M-1) {
							minimum = Math.min(minimum,time);
							break outer;
						} else if(arr[ny][nx]==2) {
							minimum=Math.min(minimum, time+(N+M-2-ny-nx));
							int[] tmp2 = {ny,nx};
							stack2.push(tmp2);
						} else {
							int[] tmp2 = {ny,nx};
							stack2.push(tmp2);
						}
					}
				}
			}
			stack=stack2;
			time+=1;
		}
		if(minimum==T+1) {
			System.out.println("Fail");
		} else {
			System.out.println(minimum);
		}
		
	}
}
