import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		int[] dx= {0,0,1,-1};
		int[] dy= {1,-1,0,0};
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][][] arr = new int[370][370][2];  // y좌표, x좌표, hp, 비활성시작 시간
			int count=0;
			ArrayList<Integer>[][] arr2 = new ArrayList[K+10][11]; // a초에 생명력 활성화되는 생명력 b의 모임 
			for (int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<M;j++) {
					int hp = Integer.parseInt(st.nextToken());
					arr[i+150][j+150][0]=hp;
					arr[i+150][j+150][1]=0;
					if (arr2[hp][hp]==null) {
						ArrayList<Integer> v = new ArrayList<>();
						v.add((i+150)*400+(j+150));
						arr2[hp][hp]=v;
					} else {
						arr2[hp][hp].add((i+150)*400+(j+150));
					}
				}
			}
			
			for (int i=1;i<K;i++) {
				for(int j=10;j>=1;j--) {
					if (arr2[i][j]!=null) {
						for (int l: arr2[i][j]) {
							for (int k=0;k<4;k++) {
								int ny = l/400+dy[k];
								int nx =l%400+dx[k];
								if (arr[ny][nx][0]==0) {
									arr[ny][nx][0]=j;
									arr[ny][nx][1]=i+j+1;
									if (arr2[i+j+1][j]==null) {
										ArrayList<Integer> v = new ArrayList<>();
										v.add(ny*400+nx);
										arr2[i+j+1][j]=v;
									} else {
										arr2[i+j+1][j].add(ny*400+nx);
									}
								}
							}
						}
					}
				}
			}
			for (int i=0;i<N+301;i++) {
				for (int j=0;j<M+301;j++) {
					if (arr[i][j][0]+arr[i][j][1]>K)
						count+=1;
				}
			}	
			sb.append("#").append(tc).append(" ").append(count).append("\n");
		}
		System.out.println(sb);
	}
}


