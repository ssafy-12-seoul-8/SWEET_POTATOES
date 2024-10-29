import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//class Node {
//	int idx;
//	List<Node> adjNodeList;
//	int shortest;
//
//	public Node(int index, int way) {
//		this.idx = index;
//		this.adjNodeList = new ArrayList<>();
//		this.shortest = way;
//	}
//}

public class Main {
	static int result = 0;
	static int D;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 건물 8개에 대한 정보를 먼저 받아야 함.
		
//			Node 정보과학관 = new Node(0,0);
//			Node 전산관 = new Node(1,1);
//			Node 미래관 = new Node(2,1);
//			Node 신양관 = new Node(3,2);
//			Node 진리관 = new Node(4,3);
//			Node 한경직기념관 = new Node(5,2);
//			Node 학생회관 = new Node(6,4);
//			Node 형남공학관 = new Node(7,3);
//		
//			connect(정보과학관,전산관);
//			connect(정보과학관,미래관);
//			connect(전산관,미래관);
//			connect(전산관,신양관);
//			connect(신양관,미래관);
//			connect(신양관,진리관);
//			connect(신양관,한경직기념관);
//			connect(미래관,한경직기념관);
//			connect(진리관,한경직기념관);
//			connect(진리관,학생회관);
//			connect(한경직기념관,형남공학관);
//			connect(학생회관,형남공학관);
			
			int[][] adjArr = {{0,1,1,0,0,0,0,0},
					{1,0,1,1,0,0,0,0},
					{1,1,0,1,1,0,0,0},
					{0,1,1,0,1,1,0,0},
					{0,0,1,1,0,1,0,1},
					{0,0,0,1,1,0,1,0},
					{0,0,0,0,0,1,0,1},
					{0,0,0,0,1,0,1,0}};
		
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			D = Integer.parseInt(br.readLine());
//			move(정보과학관,0);
			
			// DP로 업데이트 하면서 가보자.
			// 앞의 인덱스에는 건물 번호를 나타내고
			// 뒤에 인덱스에는 현재 시간을 나타내자.
			long[][] dp = new long[8][D+1];
			
			// dp안에 있는 값은 내가 구하고자 하는, 산책 경로 값
			dp[0][0] = 1;
			
			// dp[0][0] ~ dp[0][D] 까지 구하고싶음. 그 과정에서 dp[1][time] , dp[3][time] 등의 값도 구해짐.
			// time 을 0부터 D까지 돌리면서
			for (int time=1; time<=D; time++) {
				// 이번 노드와 연결된 다음 노드를 찾아야 함.
				
				// 시작하는 노드를 0부터 8까지 탐색해봄
				for (int startIdx = 0; startIdx<8; startIdx++) {
					// 끝나는 노드도 0부터 8까지 탐색해봄.
					for (int endIdx=0; endIdx<8; endIdx++) {
						// 만약 시작노드와 끝노드가 인근노드라면,
						if (adjArr[startIdx][endIdx] == 1) {
							// 시작노드까지 time 시간동안 오는 방법은 끝나는 노드로 time-1초 전까지 오는 방법의 수와 같음. 이것들의 누적합을 만들자.
							dp[startIdx][time] += dp[endIdx][time-1] % 1000000007;
						}
					}
					dp[startIdx][time] %= 1000000007; // 이게 왜 있어야 할까? 합 연산 뒤에 숫자가 커졌을수도 있으니까 해줘야하네..!
//					DP[b][t] %= mod;	
				}
			}
			
			System.out.println(dp[0][D]);
	}

//	public static void connect(Node a, Node b) {
//		a.adjNodeList.add(b);
//		b.adjNodeList.add(a);
//	}

//	private static void move(Node node, int count) {
//
//		// 남은 횟수가 최단거리보다 짧을때
//		if (D - count < node.shortest) return;
//		
//		if (count == D) {
//			if (node.idx != 0) return;
//			result++;
//			result %= 1000000007;
//			return;
//		}
//		count++;
//		
//		for (int i=0; i<node.adjNodeList.size(); i++) {
//			Node nextNode = node.adjNodeList.get(i);
//			move(nextNode, count);
//		}
//	}
}
