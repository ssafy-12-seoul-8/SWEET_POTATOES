import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M;
	static int N;
	static int count;
	static List<Integer> lst;
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static int[][] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		lst = new ArrayList<>();
		
		count = 0;
		
		arr = new int[M][N];
		
		for(int l=0;l<K;l++) {
			
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int i=y1;i<y2;i++) {
				for(int j=x1;j<x2;j++) {
					arr[i][j] = 1;
				}
			}
		}
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]==0) {
					bfs(i,j);
				}
			}
		}
		System.out.println(count);
		Collections.sort(lst);
		for(int i:lst) {
			System.out.print(i+" ");
		}
	}
	static void bfs(int y, int x) {
		
		int tmp_count = 0;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {y,x});
		
		while(!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int tmp_y = tmp[0];
			int tmp_x = tmp[1];
			if(arr[tmp_y][tmp_x]==0) {
				arr[tmp_y][tmp_x]=-1;
				tmp_count +=1;
				for(int k=0;k<4;k++) {
					int ny = tmp_y+dy[k];
					int nx = tmp_x+dx[k];
					if(0<=nx && nx<N && 0<=ny && ny<M && arr[ny][nx]==0) {
						queue.add(new int[] {ny,nx});
					}
				}
			}
		}
		
		lst.add(tmp_count);
		count+=1;
	}
}
