import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

	static class Node {
		int depth;
		Map<String, Node> child = new TreeMap<>();
		boolean isEnd = false;
		
		Node(){}
		
	}
	
	static class Trie {
		Node root;
		
		Trie(){
			this.root = new Node();
		}
		
		void insert(String[] Foods) {
			Node curr = root;
			
			for(int i=0 ; i<Foods.length ; i++) {
				if(curr.child.containsKey(Foods[i])) {
					curr = curr.child.get(Foods[i]);
				}else {
					curr.child.put(Foods[i], new Node());
					curr = curr.child.get(Foods[i]);
					curr.depth = i;
				}
			}
			curr.isEnd = true;
			
		}
		
		
		void printFood(Node curr) {
			if(!curr.isEnd) {
				for(Map.Entry<String, Node> entry : curr.child.entrySet()) {
					for(int i=0 ; i<entry.getValue().depth ; i++) {
						System.out.print("--");
					}
					
					System.out.println(entry.getKey());
					printFood(entry.getValue());
				}
				
			}
		}
		
		
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		Trie trie = new Trie();
		
		for(int i=0 ; i<N ; i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int K = Integer.parseInt(st.nextToken());
			
			String[] foods = new String[K];
			
			for(int j=0 ; j<K ; j++) {
				foods[j] = st.nextToken();
			}
			
			trie.insert(foods);
			
		}	// 입력 완료
		
		trie.printFood(trie.root);

	} // main

} // Main class