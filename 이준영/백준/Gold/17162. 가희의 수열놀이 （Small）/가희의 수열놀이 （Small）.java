import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int Q = Integer.parseInt(st.nextToken());
		int mod = Integer.parseInt(st.nextToken());
		Stack<Integer>[] check = new Stack[mod];
		Stack<Integer> stack = new Stack<>();
		int count=0;
		for(int i=0;i<mod;i++) {
			check[i]=new Stack<>();
		}
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a==1) {
				int b = Integer.parseInt(st.nextToken());
				b=b%mod;
				stack.push(b);
				check[b].push(count++);
			} else if(a==2) {
				if(stack.isEmpty())
					continue;
				int b = stack.pop();
				check[b].pop();
				count-=1;
			} else {
				int min = 2000000;
				for(int j=0;j<mod;j++) {
					if(check[j].isEmpty()) {
						min=2000000;
						break;
					} 
					if(min>check[j].peek()) {
						min=check[j].peek();
					}
				}
				if (min==2000000) {
					sb.append(-1).append("\n");
				} else {
					sb.append(count-min).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
