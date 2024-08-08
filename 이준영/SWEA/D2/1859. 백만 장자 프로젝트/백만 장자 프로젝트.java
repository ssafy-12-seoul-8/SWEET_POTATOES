
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			Stack<Integer> stack = new Stack<>();
			for (int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			long max_sum=0;
			long sum=0;
			int len=0;
			int bottom=0;
			for(int i=N-1;i>=0;i--) {
				if (stack.isEmpty()) {
					bottom=arr[i];
					stack.push(arr[i]);
				} else if(bottom>arr[i]){
					sum+=arr[i];
					len+=1;
				}else{
					max_sum+=bottom*len-sum;
					stack.pop();
					len=0;
					sum=0;
					bottom=arr[i];
					stack.push(arr[i]);
				}
			}
			if(!stack.isEmpty()) {
				max_sum+=bottom*len-sum;
			}
			System.out.printf("#%d %d\n",tc,max_sum);
			
		}
	}
}
