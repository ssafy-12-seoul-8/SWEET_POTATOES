

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr= new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());;
			}
			for (int i=1;i<N;i++) {
				int data= arr[i];
				int j;
				for(j=i-1;j>=0 && arr[j]>data;j--) {
					arr[j+1]=arr[j];
				}
				arr[j+1]=data;
			}
			System.out.printf("#%d ",tc);
			for (int i=0;i<N;i++) {
				System.out.printf("%d ",arr[i]);
			}
			System.out.println();
		}
		
		
	}
}
