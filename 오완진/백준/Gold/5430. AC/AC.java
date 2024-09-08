import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int TC = sc.nextInt();
		sc.nextLine();

		for (int tc = 1; tc <= TC; tc++) {
			Deque<Integer> AC = new LinkedList<>();
			boolean isReverse = false;
			boolean isError = false;
			
			char[] cmdArr = sc.nextLine().toCharArray();
			int N = sc.nextInt();
			sc.nextLine();
			
			String input = sc.nextLine();
			if (N > 0) {
			    String[] nums = input.substring(1, input.length() - 1).split(",");
			    for (String num : nums) {
			        AC.addLast(Integer.parseInt(num));
			    }
			}
			
			for (char cmd : cmdArr) {
				
				int num;						// 의미없는 num
				if (cmd == 'R')
					isReverse = !isReverse;
				else {
					if (!AC.isEmpty())
						num = isReverse ? AC.pollLast() : AC.pollFirst();
					else {
						isError = true;
						break;
					}
				}
				
			}//cmd
			
			if (!isError) {
				
				sb.append("[");
				while(!AC.isEmpty()) {
					sb.append(isReverse ? AC.pollLast() : AC.pollFirst());
					if (!AC.isEmpty())
						sb.append(",");
				}
				sb.append("]").append("\n");
				
			} else {
				sb.append("error").append("\n");
			}
			
			
		}//tc
		
		System.out.println(sb);
		
	}
}