import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
//		Stack<Integer> answer = new Stack<Integer>();
		
		// 값 입력하기
		for (int i=N; i>=1; i--) {
			stack.add(i);
		}
		
		// 텅 빌때까지 반복하기
		while (!stack.isEmpty()) {
//			answer.push(stack.pop());
			sb.append(stack.pop() + " ");
		  if(!stack.isEmpty()) stack.add(0, stack.pop());
		}
		
		System.out.println(sb);
	}
 
}
