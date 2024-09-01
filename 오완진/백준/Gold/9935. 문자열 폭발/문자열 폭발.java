import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner (System.in);
		
		Deque <Character> strQ = new LinkedList<>();
		Deque <Character> tmpQ = new LinkedList<>();
		
		char[] charArr = sc.nextLine().toCharArray();
		char[] bombArr = sc.nextLine().toCharArray();
		int B = bombArr.length;

		outer:
		for (char ch : charArr) {
			strQ.addLast(ch);
			
			if (strQ.size() >= B && strQ.peekLast() == bombArr[B - 1]) {
				tmpQ.clear();
				
				for (int b = B - 1; b >= 0; b--) {		// 뒤에서부터 검사
					char tmp = strQ.pollLast();
					tmpQ.addFirst(tmp);
					
					if (tmp != bombArr[b]) {
						while (!tmpQ.isEmpty()) {
							strQ.addLast(tmpQ.pollFirst());
						}
						continue outer;
					}
				}
				
			}
		}
		
		if (strQ.isEmpty())
			System.out.println("FRULA");
		else {
			while (!strQ.isEmpty())
				sb.append(strQ.pollFirst());
				System.out.println(sb);
		}
		
	}
}
