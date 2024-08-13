import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
	static LinkedList<Integer>[] state = new LinkedList[4];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1;tc<=T;tc++) {
			int score=0;
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			state = new LinkedList[4];
			for (int i=0;i<4;i++) {
				st = new StringTokenizer(br.readLine());
				state[i] = new LinkedList<Integer>();
				for (int j=0;j<8;j++) {
					state[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			for (int i=0;i<K;i++) {
				Stack<int[]> stack = new Stack<>();
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				a=a-1;
				int check = a-1;
				int direction = -b;
				while(check>=0 && state[check].get(2)!=state[check+1].get(6)) {
					int[] tmp = {check,direction};
					stack.push(tmp);
					check-=1;
					direction*=(-1);
				}
				check = a+1;
				direction =-b;
				while(check<=3 && state[check].get(6)!=state[check-1].get(2)) {
					int[] tmp = {check,direction};
					stack.push(tmp);
					check+=1;
					direction*=(-1);
				}
				rotation(a,b);
				while(!stack.empty()) {
					int[] v = stack.pop();
					rotation(v[0],v[1]);
				}
			}
			for (int i=0;i<4;i++) {
				if (state[i].get(0)==1) {
					score+=pow(2,i);
				}
			}
			sb.append("#").append(tc).append(" ").append(score).append("\n");
			
		}
		System.out.println(sb);
	}
	public static void rotation(int a, int b) {  // a 톱니를 시계(1) 혹은 반시계(-1)
		if (b==1) {
			int tmp = state[a].removeLast();
			state[a].addFirst(tmp);
		} else {
			int tmp = state[a].removeFirst();
			state[a].addLast(tmp);
		}
		
	}
	static int pow(int a,int b) {
		if (b==0) {
			return 1;
		} else {
			return a*pow(a,b-1);
		}
	}
}

