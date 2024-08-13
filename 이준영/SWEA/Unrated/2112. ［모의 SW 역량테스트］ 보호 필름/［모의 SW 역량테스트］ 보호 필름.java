import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int K=0,D=0,W=0,l=0;
	static boolean check= false;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			check=false;
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int[][] arr = new int[D][W];
			for (int i=0;i<D;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<W;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (l=0;l<K;l++) {
				ArrayList<Integer> tmp = new ArrayList<>();
				btk(0,0,tmp,arr);
				if (check) {
					sb.append("#").append(tc).append(" ").append(l).append("\n");
					break;
				}
			}
			if (!check) {
				sb.append("#").append(tc).append(" ").append(K).append("\n");
			}
		}
		System.out.println(sb);
	}
	static void btk(int a, int b,ArrayList<Integer> tmp,int[][] arr) {
		if (check) {
			return;
		}
		if(b==l) {
			for(int i=0;i<D-a;i++) {
				tmp.add(2);
			}
			if(checking(tmp,arr))
				check=true;
			for(int i=0;i<D-a;i++) {
				tmp.remove(D-i-1);
			}
			return;
		} else if (a>=D) {
			return;
		} else {
			tmp.add(0);
			btk(a+1,b+1,tmp,arr);
			tmp.remove(a);
			tmp.add(1);
			btk(a+1,b+1,tmp,arr);
			tmp.remove(a);
			tmp.add(2);
			btk(a+1,b,tmp,arr);
			tmp.remove(a);
			return;
		}
	}
	static boolean checking(ArrayList<Integer> tmp,int[][] arr) {
		int[][] arr2 = new int[D][W];
		int f=0;
		for (int i=0;i<D;i++) {
			switch (tmp.get(i)) {
				case 2:
					for (int j=0;j<W;j++) {
						arr2[i][j]=arr[i][j];
					}
					break;
				case 1:
					for (int j=0;j<W;j++) {
						arr2[i][j]=1;
					}
					break;
				case 0:
					for (int j=0;j<W;j++) {
						arr2[i][j]=0;
					}
					break;
			}
		}
		for (int j=0;j<W;j++) {
			int count=1;
			int start=arr2[0][j];
			int e=0;
			for (int i=1;i<D;i++) {
				if (arr2[i][j]==start) {
					count+=1;
				} else {
					if (count>=K) {
						e=1;
						break;
					} else {
						start=arr2[i][j];
						count=1;
					}
				}
			}
			if (count>=K)
				e=1;
			if (e==0) {
				f=1;
				break;
			}
		}
		if (f==0) {
			return true;
		} else {
			return false;
		}
	}
}
