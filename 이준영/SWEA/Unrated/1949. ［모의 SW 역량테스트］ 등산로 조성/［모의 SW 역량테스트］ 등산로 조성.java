import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int K;
	static int[][] arr;
	static int max_count;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc=1;tc<=T;tc++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			max_count = 0;
			int max = 0;
			List<Integer> lst = new ArrayList<>();
			
			for(int i=0;i<N;i++) {
				
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(max<arr[i][j]) {
						max=arr[i][j];
					}
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(arr[i][j]==max) {
						lst.add(i*9+j);
					}
				}
			}
			
			for(int i:lst) {
				Set<Integer> set = new HashSet<>();
				set.add(i);
				btk(set,i,false);
			}
			sb.append("#").append(tc).append(" ").append(max_count).append("\n");
		}
		System.out.println(sb);
	}
	static void btk(Set<Integer> set,int location, boolean r) {
		
		int y = location/9;
		int x = location%9;
		if(r) {
			boolean check = false;
			for(int k=0;k<4;k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if(0<=nx && nx<N && 0<=ny && ny<N && !set.contains(ny*9+nx) && arr[ny][nx]<arr[y][x]) {
					check = true;
					set.add(ny*9+nx);
					btk(set,ny*9+nx,r);
					set.remove(ny*9+nx);
				}
			}
			if(!check) {
				max_count = Math.max(max_count, set.size());
			}
			return;
		}
		boolean check = false;
		for(int k=0;k<4;k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if(0<=nx && nx<N && 0<=ny && ny<N && !set.contains(ny*9+nx)) {
				if(arr[ny][nx]>=arr[y][x]+K) {
					continue;
				} else if(arr[ny][nx]<arr[y][x]){
					check = true;
					set.add(ny*9+nx);
					btk(set,ny*9+nx,r);
					set.remove(ny*9+nx);
				} else {
					check = true;
					set.add(ny*9+nx);
					int tmp = arr[ny][nx];
					arr[ny][nx] = arr[y][x]-1;
					btk(set,ny*9+nx,true);
					set.remove(ny*9+nx);
					arr[ny][nx] = tmp;
				}
			}
		}
		if(!check) {
			max_count = Math.max(max_count, set.size());
		}
		return;
		
	}
}
