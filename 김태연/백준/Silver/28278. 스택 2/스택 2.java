import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
	
	class Main {
	
		public static void main(String[] args) throws Exception{
	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Stack<Integer> stack = new Stack<>();
			StringBuilder sb = new StringBuilder();
			StringTokenizer st;
			
			int N = Integer.parseInt(br.readLine());
			

			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int K = Integer.parseInt(st.nextToken());
				
				switch (K) {
				case 1:
					stack.push(Integer.parseInt(st.nextToken()));
					break;
				case 2:
					if (!stack.isEmpty()) sb.append(stack.pop() + "\n");
					else sb.append("-1\n");
					break;
				case 3:
					sb.append(stack.size() + "\n");
					break;
				case 4:
					if (stack.isEmpty()) sb.append("1\n");
					else sb.append("0\n");
					break;
				case 5:
					if (!stack.isEmpty()) sb.append(stack.peek() + "\n");
					else sb.append("-1\n");
					break;
				}
			}
			System.out.println(sb);
		}
	}