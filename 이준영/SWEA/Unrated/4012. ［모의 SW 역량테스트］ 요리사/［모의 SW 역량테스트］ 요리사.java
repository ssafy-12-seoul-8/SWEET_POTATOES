import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int mini = 10000000;
	static int N;
	static int[][] arr ;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			mini = 10000000;
			arr = new int[N][N];
			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			ArrayList<Integer> arr1 = new ArrayList<>();
			ArrayList<Integer> arr2 = new ArrayList<>();
			btk(0,0,arr1,arr2);
			sb.append("#").append(tc).append(" ").append(mini).append("\n");
		}
		System.out.println(sb);
	}
	static void btk(int count1,int count2,ArrayList<Integer> arr1,ArrayList<Integer> arr2) {
		if (count1>N/2|count2>N/2) {
			return;
		}
		if (count1+count2==N)
			check(arr1,arr2);
		arr1.add(count1+count2);
		btk(count1+1,count2,arr1,arr2);
		arr1.remove(count1);
		arr2.add(count1+count2);
		btk(count1,count2+1,arr1,arr2);
		arr2.remove(count2);
		
	}
	static void check(ArrayList<Integer> arr1,ArrayList<Integer> arr2) {
		int sum=0;
		for(int k=0;k<N/2;k++) {
			for(int j=0;j<N/2;j++) {
				sum=sum+arr[arr1.get(k)][arr1.get(j)]-arr[arr2.get(k)][arr2.get(j)];
			}
		}
		sum=Math.abs(sum);
		if(mini>sum)
			mini=sum;
	}
}
