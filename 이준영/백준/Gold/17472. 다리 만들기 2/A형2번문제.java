package problem17472;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class A형2번문제 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int count = 2; // 섬의 땅을 칠할 값 (1보다 큰 값)
		ArrayList<int[]> island = new ArrayList<>();
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
				int k=i;
				int l=j;
				while (l<M&&arr[i][l]==1) {
					l+=1;
				}
				while(k<N&&arr[k][l-1]==1) {
					k+=1;
				}
				for(int m=i;m<k;m++) {
					for(int n=j;n<l;n++) {
						arr[m][n]=count;
					}
				}
				int[] v = {i,j,k-1,l-1};
				island.add(v);
				count+=1;
			}
		}
		ArrayList<int[]> road = new ArrayList<>();
		int[] parent = new int[count-2];
		for(int i=0;i<count-2;i++) {
			parent[i]=i;
		}
		for(int i=0;i<count-2;i++) {
			for(int j=i+1;j<count-2;j++) {
				int d = dist(island.get(i),island.get(j));
				if (d>0) {
					int[] v= {d,i,j};
					road.add(v);
				}
			}
		}
		Collections.sort(road,(a,b)->(a[0]-b[0]));
		for (int i=0;i<road.size();i++) {
			System.out.printf("%d %d %d\n",road.get(i)[0],road.get(i)[1],road.get(i)[2]);
		}
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
	public static int dist(int[] a,int[] b) {
		if(a[0]<=b[2] &&b[0]<=a[2]) {
			int d = Math.min(Math.abs(a[1]-b[3]),Math.abs(a[3]-b[1]))-1;
			if(d>=2) {
				return d;
			} else {
				return 0;
			}
		} else if(a[1]<=b[3] && b[1]<=a[3]) {
			int d = Math.min(Math.abs(a[0]-b[2]),Math.abs(a[2]-b[0]))-1;
			if(d>=2) {
				return d;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
}
