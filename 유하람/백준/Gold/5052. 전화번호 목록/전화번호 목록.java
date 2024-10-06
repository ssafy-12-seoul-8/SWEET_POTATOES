import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	
	static class Node {
		// <다음 숫자, 다음 노드>
		HashMap<Integer,Node> child;
		// 번호의 끝인지
		boolean isEnd;
		
		Node(){
			this.child = new HashMap<>();
			this.isEnd = false;
		}
	}
	
	static class Trie {
		Node root;
		
		Trie(){
			root = new Node();
		}
		
		// 전화번호 등록
		boolean insertNumner(String number) {
			// 등록 성공 여부
			boolean isFinish = false;
			
			// 루트부터 시작
			Node curr = root;
			
			for(int i=0 ; i<number.length() ; i++) {
				int num = number.charAt(i) - '0';
				
				if(curr.child.keySet().contains(num)) {
					
					// 등록 돼 있다면 다음 노드로 이동
					curr = curr.child.get(num);
					if(curr.isEnd) {
						// 만약 중간에 끝 부분이 있다면
						// 접두어인 경우 -> 일관성 X
						return false;
					}
				} else {
					// 등록
					curr.child.put(num, new Node());
					// 등록 후 이동
					curr = curr.child.get(num);
					// 만약 한번이라도 새로운 숫자를 등록했다면 일관성 유지
					isFinish = true;
				}
			}
			
			curr.isEnd = true;
			
			return isFinish;
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스 개수 t (1<=t<=50)
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0 ; tc<T ; tc++) {
			
			// 전화번호의 수 n (1<=n<=10000)
			int N = Integer.parseInt(br.readLine());
			
			// 전화 번호부 생성
			Trie numbers = new Trie();
			
			// 일관성 있는 목록인지
			boolean isOk = true;
			
			for(int i=0 ; i<N ; i++) {
				String number = br.readLine();
				if(!numbers.insertNumner(number)) {
					isOk = false;
				}
			}
			
			if(isOk) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
			
			
			
		} // tc
		
	} // main


} // Main class