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
		// dfs로 섬을 표시하기 위한 순회
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
		
		// 각 섬간 거리를 11로 초기화;
		int[][] distance = new int[count-2][count-2];
		for(int i=0;i<count-2;i++) {
			for(int j=0;j<count-2;j++) {
				distance[i][j]=11;
			}
		}
		
		// 가로로 된 도로를 건설하였다고 할 때 각 섬의 거리를 수정하는 코드
		// 이전에 섬이었던 곳의 좌표와 섬의 번호를 저장해 놓고 새로운 섬을 만나면 거리를 계산해서 수정하는 방법 
		for(int i=0;i<N;i++) {
			int start=0;		// 가장 최근 섬의 번호를 저장할 변수
			int start_index=0;  // 가장 최근 섬의 index를 저장할 변수
			for(int j=0;j<M;j++) {
				if(arr[i][j]==0) { //바다이므로 pass
					continue;
				}
				else {
					if(start==0 || start==arr[i][j]) { // 섬인데 가장 최근 섬이 바다거나 현재 섬과 동일하면 start와 start_index를 현재 섬으로 바꿔줌
						start=arr[i][j];
						start_index=j;
					} else {
						int d = j-start_index-1;	 // 가장 최근 섬이 있고 지금 섬과 다르다면 거리를 계산
						if(d>=2 && d<distance[start-2][arr[i][j]-2]) { // 2이상이면서 기존것보다 길이가 짧으면 수정
							distance[start-2][arr[i][j]-2]=d;
							distance[arr[i][j]-2][start-2]=d;
						}
						start=arr[i][j];
						start_index=j;
					}
				}
			}
		}
		// 세로로 된 도로를 건설하였다고 할 때 각 섬의 거리를 수정하는 코드
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
		ArrayList<int[]> road = new ArrayList<>(); // (섬과 섬사이의 도로길이,연결된섬1,연결된섬2)를 저장할 리스트
		int[] parent = new int[count-2];	// 각 섬의 부모를 저장하는 배열
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
		Collections.sort(road,(a,b)->(a[0]-b[0])); // 길이가 짧은 순으로 나열
		int count1 = 0; //도로의 수
		int sum=0; //도로 길이의 합
		for(int i=0;i<road.size();i++) {
			int[] tmp = road.get(i);
			int p1 = find(tmp[1],parent);   
			int p2 = find(tmp[2],parent);
			if(p1!=p2) {	 	// 조상이 같다=이미 연결되어있다이므로 고르지 않음
				sum+=tmp[0];
				parent[p2]=p1;	// 한 섬의 조상을 다른 섬의 부모로 지정
				count1+=1;		
			}
		}
		if(count1<count-3) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
		}
	}
	public static int find(int a,int[] parent) { // 가장 위의 조상을 찾는 함수
		if(parent[a]==a) {
			return a;
		}
		return find(parent[a],parent);
	}
}
