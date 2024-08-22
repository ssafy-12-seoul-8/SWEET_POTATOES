import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int minimum = 1000000;
	static int M=0;
	static int len2=0;
	static int len1=0;
	static Map<Integer, Boolean> map = new HashMap<>();
	static ArrayList<int[]>[] distance;
	static ArrayList<int[]> chicken;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		ArrayList<int[]> home = new ArrayList<>();
		chicken = new ArrayList<>();
		map = new HashMap<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i][j]=a;
				if(a==1) {
					home.add(new int[] {i,j});
				} else if(a==2) {
					chicken.add(new int[] {i,j});
					map.put(51*i+j, false);
				}
			}
		}
		len1 = home.size();
		len2 = chicken.size();
		distance = new ArrayList[len1];
 		for(int i=0;i<len1;i++) {
			distance[i]=new ArrayList<>();
			int[] tmp=home.get(i);
			for(int j=0;j<len2;j++) {
				int[] tmp2 = chicken.get(j);
				distance[i].add(new int[] {Math.abs(tmp[0]-tmp2[0])+Math.abs(tmp[1]-tmp2[1]),tmp2[0],tmp2[1]});
			}
			Collections.sort(distance[i], (a,b)->a[0]-b[0]);
		}
 		btk(0,0);
 		System.out.println(minimum);	
	}
	static void btk(int cur, int count) {
		if(count==M) {
			check();
			return;
		}
		if(cur==len2) {
			return;
		}
		btk(cur+1,count);
		int[] tmp=chicken.get(cur);
		map.put(tmp[0]*51+tmp[1], true);
		btk(cur+1,count+1);
		map.put(tmp[0]*51+tmp[1], false);
	}
	static void check() {
		int sum=0;
		for(int i=0;i<len1;i++) {
			for(int j=0;j<len2;j++) {
				int[] tmp = distance[i].get(j);
				if(map.get(tmp[1]*51+tmp[2])) {
					sum+=tmp[0];
					break;
				}
			}
		}
		if (sum<minimum) {
			minimum=sum;
		return;
		}
	}
}