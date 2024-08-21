import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] visited;
	static int[][] arr;
	static int[][] arr2;
	static int[] dy1= {-1,-1,0,0,1,1}; // 짝수행
	static int[] dx1= {0,1,-1,1,0,1}; 
	static int[] dy2= {-1,-1,0,0,1,1}; // 홀수행
	static int[] dx2= {-1,0,-1,1,-1,0};
	static int W;
	static int H;
	static int count=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][W];
		arr2 = new int[H][W];
		visited=new boolean[H][W];
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				arr2[i][j]=1;
			}
		}
		for(int i=0;i<H;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<W;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<H;i++) {
			if(!visited[i][0] &&arr[i][0]==0) {
				visited[i][0]=true;
				dfs(i,0);
			}
			if(!visited[i][W-1]&&arr[i][W-1]==0) {
				visited[i][W-1]=true;
				dfs(i,W-1);
			}
		}
		for(int j=0;j<W;j++) {
			if(!visited[0][j]&&arr[0][j]==0) {
				visited[0][j]=true;
				dfs(0,j);
			}
			if(!visited[H-1][j]&&arr[H-1][j]==0) {
				visited[H-1][j]=true;
				dfs(H-1,j);
			}
		}
//		for(int i=0;i<H;i++) {
//			for(int j=0;j<W;j++) {
//				System.out.print(arr2[i][j]+" ");
//			}
//			System.out.println();
//		}
		visited=new boolean[H][W];
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(arr2[i][j]==1&!visited[i][j]) {
					visited[i][j]=true;
					dfs2(i,j);
				}
			}
		}
		System.out.println(count);
	}
	public static void dfs(int y,int x) {
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[]{y,x});
		while(!stack.isEmpty()) {
			int[] tmp=stack.pop();
			arr2[tmp[0]][tmp[1]]=0;
			if(tmp[0]%2==0) {
				for(int k=0;k<6;k++) {
					int ny=tmp[0]+dy1[k];
					int nx=tmp[1]+dx1[k];
					if(0<=ny&&ny<H&&0<=nx&&nx<W&&!visited[ny][nx]&&arr[ny][nx]==0) {
						arr2[ny][nx]=0;
						visited[ny][nx]=true;
						stack.push(new int[] {ny,nx});
					}
				}
			} else {
				for(int k=0;k<6;k++) {
					int ny=tmp[0]+dy2[k];
					int nx=tmp[1]+dx2[k];
					if(0<=ny&&ny<H&&0<=nx&&nx<W&&!visited[ny][nx]&&arr[ny][nx]==0) {
						arr2[ny][nx]=0;
						visited[ny][nx]=true;
						stack.push(new int[] {ny,nx});
					}
				}
			}		
		}
	}
	public static void dfs2(int y,int x) {
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[]{y,x});
		while(!stack.isEmpty()) {
			int[] tmp=stack.pop();
			int tmp_count=0;
			if(tmp[0]%2==0) {
				for(int k=0;k<6;k++) {
					int ny=tmp[0]+dy1[k];
					int nx=tmp[1]+dx1[k];
					if(0<=ny&&ny<H&&0<=nx&&nx<W&&arr2[ny][nx]==1) {
						tmp_count+=1;
						if(!visited[ny][nx]) {
							visited[ny][nx]=true;
							stack.push(new int[] {ny,nx});
						}
					}
				}
			} else {
				for(int k=0;k<6;k++) {
					int ny=tmp[0]+dy2[k];
					int nx=tmp[1]+dx2[k];
					if(0<=ny&&ny<H&&0<=nx&&nx<W&&arr2[ny][nx]==1) {
						tmp_count+=1;
						if(!visited[ny][nx]) {
							visited[ny][nx]=true;
							stack.push(new int[] {ny,nx});
						}
					}
				}
			}
			count+=(6-tmp_count);
		}
	}
}
