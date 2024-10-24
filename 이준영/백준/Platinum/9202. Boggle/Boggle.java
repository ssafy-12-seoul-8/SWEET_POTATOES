import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Main {

	static int[] score = { 0, 0, 0, 1, 1, 2, 3, 5, 11 };
	static boolean[][] visited;
	static char[][] dice;
	static int sum;
	static Set<Node> find;
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static String find_string;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		Trie trie = new Trie();

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			trie.insert(str);
		}

		br.readLine();
		int b = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < b; tc++) {

			StringBuilder sb2 = new StringBuilder();
			dice = new char[4][4];
			for (int i = 0; i < 4; i++) {
				String str = br.readLine();
				for (int j = 0; j < 4; j++) {
					dice[i][j] = str.charAt(j);
				}
			}

			visited = new boolean[4][4];
			find = new HashSet<>();
			sum = 0;
			find_string = "";
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (!trie.root.child.containsKey(dice[i][j])) {
						continue;
					}

					visited[i][j] = true;
					btk(i, j, trie.root.child.get(dice[i][j]));
					visited[i][j] = false;
				}
			}
			sb.append(sum).append(" ").append(find_string).append(" ").append(find.size()).append("\n");
			if(tc<b-1) {
				br.readLine();
			}
		}
		System.out.println(sb);
	}

	static class Node {
		Map<Character, Node> child;
		int end;
		String str;

		public Node() {
			this.child = new HashMap<>();
			this.end = -1;
			this.str = "";
		}
	}

	static class Trie {
		Node root;

		public Trie() {
			this.root = new Node();
		}

		public void insert(String str) {
			Node cur = root;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (cur.child.containsKey(c)) {
					cur = cur.child.get(c);
				} else {
					Node new_Node = new Node();
					new_Node.str = cur.str + c;
					cur.child.put(c, new_Node);
					cur = new_Node;
				}
			}
			cur.end = score[str.length()];
		}
//		public void print() {
//			Set<Node> set = new HashSet<>();
//			Stack<Node> stack =new Stack<>();
//			stack.add(root);
//			while(!stack.isEmpty()) {
//				Node tmp = stack.pop();
//				if(!set.contains(tmp)) {
//					set.add(tmp);
//					System.out.println(tmp.str);
//					for(Node tmp2:tmp.child.values()) {
//						stack.push(tmp2);
//					}
//				}
//			}
//			
//		}
	}

	public static void btk(int y, int x, Node cur) {

		if (cur.end != -1) {
			if (!find.contains(cur)) {
				find.add(cur);
				sum = sum + cur.end; 
				if(find_string.length()<cur.str.length()) {
					find_string = cur.str;
				} else if (find_string.length()==cur.str.length()) {
					if(find_string.compareTo(cur.str)>0) {
						find_string = cur.str;
					}
				}
			}
		}

		if (cur.child.isEmpty()) {
			return;
		}

		for (int k = 0; k < 8; k++) {
			int ny = y + dy[k];
			int nx = x + dx[k];
			if (0 <= ny && ny < 4 && 0 <= nx && nx < 4 && !visited[ny][nx] && cur.child.containsKey(dice[ny][nx])) {
				visited[ny][nx] = true;
				btk(ny, nx, cur.child.get(dice[ny][nx]));
				visited[ny][nx] = false;
			}
		}
	}
}
