import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution
{
    static StringBuilder sb = new StringBuilder();
	
	static class Node{
		String data;
		Node next;
		Node prev;
	}
	
	static class singleLink{
		Node head;	// size = 0에 위치
		Node tail;	// size+1 에 위치
		int size = 0;
		
		singleLink(){
			this.head = new Node();
			this.tail = new Node();
			head.next = tail;
			tail.prev = head;
		}
		
		// 초기 입력
		void addFist(String data){	// 매번 삽입 위치 찾지 않고 head 뒤에 삽입
			size++;
			
			Node newNode = new Node();
			newNode.data = data;
			
			newNode.next = head.next;
			newNode.prev = head;
			
			head.next.prev = newNode;
			head.next = newNode;
			
		}
		
		// 삽입
		void add(int x, singleLink newlist) {
			// 삽입할 노드의 앞 위치로 접근
			Node curr = head;
			for(int i=0 ; i<x ; i++) {
				curr = curr.next;
			}
			
			// 주어진 단방향 리스트 x위치 다음으로 이어주기
			newlist.head.next.prev = curr;
			newlist.tail.prev.next = curr.next;
			
			curr.next.prev = newlist.tail.prev;
			curr.next = newlist.head.next;
			
		}
		
		// 삭제
		void del(int x, int y) {
			// 삭제할 노드 앞 위치로 접근
			Node curr = head;
			for(int i=0 ; i<x ; i++) {
				curr = curr.next;
			}
			
			// 그 뒤로 y번 삭제
			for(int i=0 ; i<y ; i++) {
				curr.next.next.prev = curr;
				curr.next = curr.next.next;
			}
			
		}
		
		// 추가
		void addLast(singleLink newlist) {
			// newlist 부터 연결
			newlist.tail.prev.next = tail;
			newlist.head.next.prev = tail.prev;
			
			// list 연결
			tail.prev.next = newlist.head.next;
			tail.prev = newlist.tail.prev;
			
		}
		
		// 10개 출력
		void print() {
			Node curr = head;
			for(int i=0 ; i<10 ; i++) {
				curr = curr.next;
				sb.append(curr.data).append(" ");
			}
			sb.append("\n");
			
		}
		
		
	}
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = 10;
		
		for(int tc=1 ; tc<=T ; tc++) {
			
			sb.append("#").append(tc).append(" ");
			
			singleLink list = new singleLink(); // 암호문
			
			// 암호문의 개수
			String s1 = br.readLine();
			int N = Integer.parseInt(s1);
			
			// 원본 암호문 뭉치
			String s2 = br.readLine();
			StringTokenizer st1 = new StringTokenizer(s2);
			
			Stack<String> stack = new Stack<>();	// 스택을 이용해 거꾸로 add
			
			for(int i=0 ; i<N ; i++) {
				stack.push(st1.nextToken());
			}
			
			for(int i=0 ; i<N ; i++) {
				String tmp = stack.peek();
				list.addFist(tmp);
			}
			
			// 명령어의 개수
			String s3 = br.readLine();
			int M = Integer.parseInt(s3);
			
			// 명령어
			String s4 = br.readLine();
			StringTokenizer st2 = new StringTokenizer(s4);
			
			for(int i=0 ; i<M ; i++) {
				String cmd = st2.nextToken();
				
				switch(cmd) {
					case "I":
						int x = Integer.parseInt(st2.nextToken());
						int y = Integer.parseInt(st2.nextToken());
						
						// list에 연결할 새로운 singleLink
						singleLink tmpList = new singleLink();
						Stack<String> tmpStack = new Stack<>();
						for(int j=0 ; j<y ; j++) {
							String tmp = st2.nextToken();
							tmpStack.push(tmp);
						}
						for(int j=0 ; j<y ; j++) {
							String tmp = tmpStack.pop();
							tmpList.addFist(tmp);
						}
						
						// list에 연결
						list.add(x, tmpList);
						break;
						
					case "D":
						int x1 = Integer.parseInt(st2.nextToken());
						int y1 = Integer.parseInt(st2.nextToken());
						list.del(x1, y1);
						break;
					case "A":
						int y2 = Integer.parseInt(st2.nextToken());
						
						// list 끝에 연결할 새로운 singleLink
						singleLink tmpList2 = new singleLink();
						Stack<String> tmpStack2 = new Stack<>();
						for(int j=0 ; j<y2 ; j++) {
							String tmp = st2.nextToken();
							tmpStack2.push(tmp);
						}
						for(int j=0 ; j<y2 ; j++) {
							String tmp = tmpStack2.pop();
							tmpList2.addFist(tmp);
						}
						
						// list 끝에 연결
						list.addLast(tmpList2);
					
				}
				
			}
			
			list.print();
			
		}
		
		String ans = sb.toString();
		bw.write(ans);
		bw.flush();
		bw.close();
		br.close();
	}
}