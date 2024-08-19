import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] dx = {0,0,0,1,-1};
		int[] dy = {0,1,-1,0,0};
		int[][] arr = new int[R][C];
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0;j<C;j++) {
				if(str.charAt(j)=='O') {
					arr[i][j]=1;
				} else {
					arr[i][j]=-1;
				}
			}
		}
		for(int time=2;time<=N;time++) {
			if(time%2==0) {
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++) {
						arr[i][j]+=1;
					}
				}
			} else {
				ArrayList<int[]> arr2 = new ArrayList<>();
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++) {
						arr[i][j]+=1;
						if (arr[i][j]==3) {
							int[] v = {i,j};
							arr2.add(v);
						}
					}
				}
				for(int i=0;i<arr2.size();i++) {
					int y = arr2.get(i)[0];
					int x = arr2.get(i)[1];
					for (int k=0;k<5;k++) {
						int ny=y+dy[k];
						int nx=x+dx[k];
						if(0<=ny&&ny<R&&0<=nx&&nx<C)
							arr[ny][nx]=-1;
					}
							
				}
			}
		}
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j]==-1) {
					System.out.print(".");
				} else {
					System.out.print("O");
				}
			}
			System.out.println();
		}
	}
}
