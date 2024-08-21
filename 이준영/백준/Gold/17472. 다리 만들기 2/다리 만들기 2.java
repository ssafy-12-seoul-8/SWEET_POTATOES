import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int count = 2; // 섬의 땅을 칠할 값 (
		int[] dy= {0,0,1,-1};
		int[] dx= {1,-1,0,0};
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if (arr[i][j]!=1)
					continue;
				Stack<int[]> stack = new Stack<>();
				stack.push(new int[] {i,j});
				while (!stack.isEmpty()) {
					int[] tmp = stack.pop();
					if (arr[tmp[0]][tmp[1]]==1) {
						arr[tmp[0]][tmp[1]]=count;
						for(int k=0;k<4;k++) {
							int ny=tmp[0]+dy[k];
							int nx=tmp[1]+dx[k];
							if(0<=ny&&ny<N&&0<=nx&&nx<M&&arr[ny][nx]==1) {
								stack.push(new int[]{ny,nx});
							}
						}
					}		
 				}
				count+=1;
			}
		}
//		for(int i=0;i<N;i++) {
//			for(int j=0;j<M;j++) {
//				System.out.print(arr[i][j]+" ");
//			}
//			System.out.println();
//		}
		int[][] distance = new int[count-2][count-2];
		for(int i=0;i<count-2;i++) {
			for(int j=0;j<count-2;j++) {
				distance[i][j]=11;
			}
		}
		for(int i=0;i<N;i++) {
			int start=0;
			int start_index=0;
			for(int j=0;j<M;j++) {
				if(arr[i][j]==0) {
					continue;
				}
				else {
					if(start==0 || start==arr[i][j]) {
						start=arr[i][j];
						start_index=j;
					} else {
						int d = j-start_index-1;	
						if(d>=2 && d<distance[start-2][arr[i][j]-2]) {
							distance[start-2][arr[i][j]-2]=d;
							distance[arr[i][j]-2][start-2]=d;
						}
						start=arr[i][j];
						start_index=j;
					}
				}
			}
		}
//		for(int i=0;i<count-2;i++) {
//			for(int j=0;j<count-2;j++) {
//				System.out.print(distance[i][j]+" ");
//			}
//			System.out.println();
//		}
		for(int j=0;j<M;j++) {
			int start=0;
			int start_index=0;
			for(int i=0;i<N;i++) {
				if(arr[i][j]==0) {
					continue;
				}
				else {
					if(start==0 || start==arr[i][j]) {
						start=arr[i][j];
						start_index=i;
					} else {
						int d = i-start_index-1;
						if(d>=2 && d<distance[start-2][arr[i][j]-2]) {
							distance[start-2][arr[i][j]-2]=d;
							distance[arr[i][j]-2][start-2]=d;
						}
						start=arr[i][j];
						start_index=i;
					}
				}
			}
		}
//		for(int i=0;i<count-2;i++) {
//			for(int j=0;j<count-2;j++) {
//				System.out.print(distance[i][j]+" ");
//			}
//			System.out.println();
//		}
		ArrayList<int[]> road = new ArrayList<>();
		int[] parent = new int[count-2];
		for(int i=0;i<count-2;i++) {
			parent[i]=i;
		}
		for(int i=0;i<count-2;i++) {
			for(int j=i+1;j<count-2;j++) {
				int d = distance[i][j];
				if (d<11) {
					int[] v= {d,i,j};
					road.add(v);
				}
			}
		}
		Collections.sort(road,(a,b)->(a[0]-b[0]));
//		for (int i=0;i<road.size();i++) {
//			System.out.printf("%d %d %d\n",road.get(i)[0],road.get(i)[1],road.get(i)[2]);
//		}
		int count1 = 0;
		int sum=0;
		for(int i=0;i<road.size();i++) {
			int[] tmp = road.get(i);
			int p1 = find(tmp[1],parent);
			int p2 = find(tmp[2],parent);
			if(p1!=p2) {
				sum+=tmp[0];
				parent[p2]=p1;
				count1+=1;
			}
		}
		if(count1<count-3) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
		}
	}
	public static int find(int a,int[] parent) {
		if(parent[a]==a) {
			return a;
		}
		return find(parent[a],parent);
	}
}
