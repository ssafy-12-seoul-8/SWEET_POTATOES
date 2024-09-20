import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		// 수의 개수
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0 ; i<N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		Stack<Integer> stack = new Stack<>();
		
		int idx = 0;
		
		for(int i=1 ; i<=N ; i++) {
			stack.push(i);
			sb.append("+").append("\n");
			while(idx<N && !stack.isEmpty() && stack.peek()==arr[idx]) {
				stack.pop();
				idx++;
				sb.append("-").append("\n");
			}
		}
		
		if(!stack.isEmpty()) {
			System.out.println("NO");
		}else {
			System.out.println(sb.toString());
		}
		
	}	// main


}

