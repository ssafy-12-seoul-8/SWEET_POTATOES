import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] word = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		int len = bomb.length;

		Deque<Character> dq = new LinkedList<>();
		Deque<Character> tmp = new LinkedList<>();

		out : for (char c : word) {
			dq.addLast(c);
			
			// 넣으려는 문자가 폭탄의 마지막 문자일 경우 확인
			if (dq.size()>=len && dq.peekLast()==bomb[len-1]) {
				tmp.clear();
				for(int idx = len-1 ; idx>=0 ; idx--) {
					char t = dq.pollLast();
					tmp.addFirst(t);
					if(t != bomb[idx]) {
						while(!tmp.isEmpty()) {
							dq.addLast(tmp.pollFirst());
						}
						continue out;
					}
				}
			}
		}


		if (dq.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			while(!dq.isEmpty()) {
				sb.append(dq.pollFirst());
			}
			System.out.println(sb);
		}
		

	} // main

}
// Main class
