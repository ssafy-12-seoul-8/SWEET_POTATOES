import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] basket;
	static int[][] move;
	static int[] dr = {0,0,-1,-1,-1,0,1,1,1};
	static int[] dc = {0,-1,-1,0,1,1,1,0,-1};
	static List<int[]> cloud;
	static boolean[][] isCloud;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 크기 N ( 2 <= N <= 50 )
		N = Integer.parseInt(st.nextToken());
		
		// 이동 횟수 M
		int M = Integer.parseInt(st.nextToken());
		
		// 각 바스켓 안의 물의 양
		basket = new int[N][N];
		
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<N ; j++) {
				basket[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		move = new int[M][2];
		
		for(int i=0 ; i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			move[i][0] = Integer.parseInt(st.nextToken());
			move[i][1] = Integer.parseInt(st.nextToken());
		}
		
		cloud = new ArrayList<>();
		cloud.add(new int[] {N-1,0});
		cloud.add(new int[] {N-1,1});
		cloud.add(new int[] {N-2,0});
		cloud.add(new int[] {N-2,1});
		
		for(int i=0 ; i<M ; i++) {

			doMove(i);
			copyWater();
			makeCloud();
			
		}
		
		int sum = 0;
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				sum += basket[i][j];
			}
		}
		
		
		System.out.println(sum);
		
	} // main

	private static void doMove(int i) {
		List<int[]> list = new ArrayList<>();
		isCloud = new boolean[N][N];
		
		while(!cloud.isEmpty()) {
			int[] curr = cloud.remove(0);
			int r = curr[0];
			int c = curr[1];
			
			int nr = (r + dr[move[i][0]]*move[i][1] + move[i][1]*N)%N;
			int nc = (c + dc[move[i][0]]*move[i][1] + move[i][1]*N)%N;
			
			list.add(new int[] {nr,nc});
			basket[nr][nc]++;
			isCloud[nr][nc] = true;

		}
		
		while(!list.isEmpty()) {
			cloud.add(list.remove(0));
		}
		
		
	}

	private static void copyWater() {
		// d = 2, 4, 6, 8
		for(int i=0 ; i<cloud.size() ; i++) {
			int[] tmp = cloud.get(i);
			int r = tmp[0];
			int c = tmp[1];
			for(int j=1 ; j<=4 ; j++) {
				int nr = r + dr[j*2];
				int nc = c + dc[j*2];
				
				if(nr>=0 && nr<N && nc>=0 && nc<N && basket[nr][nc]!=0) {
					basket[r][c]++;
				}
			}
		}
	}

	private static void makeCloud() {
		List<int[]> newCloud = new ArrayList<>();
		
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				int[] tmp = {i,j};
				if(basket[i][j]>=2 && !isCloud[i][j]) {
					newCloud.add(tmp);
					basket[i][j] -= 2;
				}
			}
		}
		cloud.clear();
		for(int[] c : newCloud) {
			cloud.add(c);
		}
	}


} // Main class