import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int[] dx= {1,-1,0,0};
		int[] dy= {0,0,1,-1};
		boolean check=false;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0;j<M;j++) {
				arr[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		arr[0][0]=2;
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] {0,0});
		while (!check) {
			Stack<int[]> stack2 = new Stack<>();
			while(!stack.isEmpty()) {
				int[] tmp = stack.pop();
				for(int k=0;k<4;k++) {
					int ny = tmp[0]+dy[k];
					int nx = tmp[1]+dx[k];
					if(0<=ny &&ny<N&&0<=nx&&nx<M &&arr[ny][nx]==1) {
						arr[ny][nx]=arr[tmp[0]][tmp[1]]+1;
						if(ny==N-1&&nx==M-1) {
							check=true;
						} else {
							stack2.push(new int[]{ny,nx});
						}
					}
				}
			}
			stack=stack2;
		}
		System.out.println(arr[N-1][M-1]-1);
	}
}