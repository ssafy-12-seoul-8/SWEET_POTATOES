import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int[][] arr;
	static int[][] row; // N행의 최소, 최대 Core
	static int[][] col;
	static int len=0;
	static int count=0;
	static int l=0;
	static int N=0;
	static ArrayList<int[]> lst;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			count=0;
			l=10000;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			row = new int[N][2]; // N행의 최소, 최대 Core
			col = new int[N][2]; // N열의 최소, 최대 Core
			lst = new ArrayList<>();
			for(int i=0;i<N;i++) {
				row[i][0]=13;
				row[i][1]=-1;
				col[i][0]=13;
				col[i][1]=-1;
			}
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
					if(arr[i][j]==1) {
						row[i][0]=Math.min(row[i][0], j);
						row[i][1]=Math.max(row[i][1], j);
						col[j][0]=Math.min(col[j][0], i);
						col[j][1]=Math.max(col[j][1], i);
						if(i==0 || j==0||i==N-1||j==N-1) {
							continue;
						} else {
							lst.add(new int[] {i,j});
						}
					}
				}
			}
//			for(int i=0;i<N;i++) {
//				System.out.println(row[i][0]+" "+row[i][1]);
//			}
//			System.out.println();
//			for(int i=0;i<N;i++) {
//				System.out.println(col[i][0]+" "+col[i][1]);
//			}
//			System.out.println();
//			for(int i[]:lst) {
//				System.out.println(i[0]+" "+i[1]);
//			}
			len = lst.size();
			btk(0,0,0);
			sb.append("#").append(tc).append(" ").append(l).append("\n");
		}
		System.out.println(sb);
	}
	static void btk(int index,int count1,int len1) {
		if(index==len) {
			if(count1>count) {
				count=count1;
				l=len1;
			} else if(count1==count) {
				l=Math.min(l, len1);
			}
			return;
		}
		btk(index+1,count1,len1);
		int i = lst.get(index)[0];
		int j = lst.get(index)[1];
		if(row[i][0]==j) {
			int[] tmp = new int[j];
			for (int k=0;k<j;k++) {
				tmp[k]=col[k][0];
			}
			for(int k=0;k<j;k++) {
				col[k][0]=i;
			}
			btk(index+1,count1+1,len1+j);
			for(int k=0;k<j;k++) {
				col[k][0]=tmp[k];
			}
		}
		if(row[i][1]==j) {
			int[] tmp = new int[N-j];
			for (int k=j+1;k<N;k++) {
				tmp[k-j-1]=col[k][0];
			}
			for(int k=j+1;k<N;k++) {
				col[k][0]=i;
			}
			btk(index+1,count1+1,len1+N-1-j);
			for(int k=j+1;k<N;k++) {
				col[k][0]=tmp[k-j-1];
			}
		}
		if(col[j][0]==i) {
			btk(index+1,count1+1,len1+i);
		}
		if(col[j][1]==i) {
			int[] tmp = new int[N-i];
			int[] tmp2 = new int[N-i];
			for (int k=i+1;k<N;k++) {
				tmp[k-i-1]=row[k][0];
				tmp2[k-i-1]=row[k][1];
			}
			for(int k=i+1;k<N;k++) {
				row[k][0]=Math.min(row[k][0], j);
				row[k][1]=Math.max(row[k][1], j);
			}
			btk(index+1,count1+1,len1+N-1-i);
			for(int k=i+1;k<N;k++) {
				row[k][0]=tmp[k-i-1];
				row[k][1]=tmp2[k-i-1];
			}
		}
		return;
	}
}
