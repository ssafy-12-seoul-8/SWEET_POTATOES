package problem3234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int count=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			count=0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			boolean[] check = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			btk(0,0,0,check,arr,N);
			System.out.printf("#%d %d\n",tc,count);
		}
		
	}
	static void btk(int left_sum,int right_sum,int c,boolean[] check,int[] arr,int N) {
		if (c==N) {
			count+=1;
			return;
		} else {
			for (int i=0;i<N;i++) {
				if (!check[i]) {
					check[i]=true;
					btk(left_sum+arr[i],right_sum,c+1,check,arr,N);
					if(left_sum>=right_sum+arr[i]) {
						btk(left_sum,right_sum+arr[i],c+1,check,arr,N);
					}
					check[i]=false;
				}
			}
			return;
		}
	}
}
