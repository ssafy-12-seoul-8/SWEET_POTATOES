import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static class Node {
		boolean end;
		Map<Character, Node> map;

		public Node() {
			this.end = false;
			map = new HashMap<>();
		}
	}
	
	public static class Trie {
		Node head;
		String check;
		public Trie(){
			this.head = new Node();
			this.check = "YES";
		}
		
		public void insert(String str) {
			Node cur = this.head;
			int len = str.length();
			for(int i = 0 ; i< len-1 ;i++) {
				if(cur.map.containsKey(str.charAt(i))) {
					cur = cur.map.get(str.charAt(i));
				} else {
					Node tmp = new Node();
					cur.map.put(str.charAt(i), tmp);
					cur = tmp;
				}
			}
			
			if(cur.map.containsKey(str.charAt(len-1))) {
				cur = cur.map.get(str.charAt(len-1));
				this.check = "NO";
			} else {
				Node tmp = new Node();
				cur.map.put(str.charAt(len-1), tmp);
				cur = tmp;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			String[] phone_number = new String[n];
			for(int i = 0; i<n;i++) {
				phone_number[i] = br.readLine();
			}
			
			Arrays.sort(phone_number, (a,b)->(b.length()-a.length()));
			Trie trie = new Trie();
			for(int i = 0 ; i<n;i++) {
				if(trie.check.equals("NO")) {
					break;
				}
				trie.insert(phone_number[i]);
				
			}
			
			sb.append(trie.check).append("\n");
		}
		System.out.println(sb);
	}
}
