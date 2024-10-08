import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Node {
//	int value;
	boolean isEnd = false;
	HashMap<Integer, Node> childNodeList = new HashMap<>();

	public Node() {
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			// 트라이 초기화
//			HashMap<Integer, Node> trie = new HashMap<>();
			Node rootNode = new Node();
//			trie.put(0, rootNode);
			boolean 일관성 = true; 
			
			for (int i = 0; i < N; i++) {
				// 값 입력받기 . 예 : 911
				String input = br.readLine();
				if (!일관성) continue;
				
				if (!add(rootNode, input)) {  // 문제 발생 시
					일관성 = false;
//					break;
				}
			}
			
			// 출력 관리
			if (일관성) sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	public static boolean add(Node currentNode, String input) {
		
		for (int i = 0; i < input.length(); i++) {
			// 내가 113 을 add 한다면, 먼저 nodeMap 에 1이 있는지 판단한다.
			int number = input.charAt(i) - '0';
			
			// 숫자가 없다면
			if (currentNode.childNodeList.get(number) == null) {
				// 없으면 새로운 노드 추가
				currentNode.childNodeList.put(number, new Node());
			}
			
			currentNode = currentNode.childNodeList.get(number);
			
			// isEnd 가 true 이면, 종료!
			// 91125 를 입력했는데, 911 이 있는 경우
			if (currentNode.isEnd) {
				return false;
			}
		}
		
		// 911 입력을 완료했는데, 이미 91125 가 있는 경우
		if (currentNode.childNodeList.size() > 0) {
			return false;
		}
		
		// 마지막에만 isEnd 를 true 로 설정해주고
		currentNode.isEnd = true;
		// 문제없이 종료
		return true;
		
		
	}
	
}
