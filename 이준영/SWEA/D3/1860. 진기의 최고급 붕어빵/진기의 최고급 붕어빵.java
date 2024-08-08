
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			Stack<Integer> stack = new Stack<>();
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			for (int i=1;i<n;i++) {
				int j;
				int data=arr[i];
				for (j=i-1;j>=0 && arr[j]>data;j--) {
					arr[j+1]=arr[j];
				}
				arr[j+1]=data;
			}
			for (int i=n-1;i>=0;i--) {
				stack.push(arr[i]);
			}
			int check=1,sum=0;
			for (int i=0;i<n;i++) {
				int data=stack.pop();
				sum+=1;
				int count = (data/m)*k;
				if(sum>count) {
					check=0;
					break;
				}
			}
			String result;
			if (check==0) {
				result="Impossible";
			} else {
				result="Possible";
			}
			System.out.printf("#%d %s\n",tc,result);
		}
	}
}
