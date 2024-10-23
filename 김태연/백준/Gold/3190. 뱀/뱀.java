import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Node {
	int row;
	int column;
	Node next;

	public Node(int row, int column, Node nextNode) {
		next = nextNode;
		this.row = row;
		this.column = column;
	}

}

class Snake {
	// 머리 & 꼬리
	Node head;
	Node tail;
	int dir;
	int[][] map;

	public void moveHead(int nr, int nc) {
		// 대가리에 전진! (새로운 노드 생성)
		Node newHead = new Node(nr, nc, head);
		head.next = newHead;
		head = newHead;
		map[head.row][head.column] = 1;
	}

	public void init(int[][] map) {
		head = new Node(1, 1, null);
		tail = head;
		dir = 0;
		this.map = map;
		this.map[1][1] = 1;
	}

	public void moveTail() {
		map[tail.row][tail.column] = 0;
		tail = tail.next;	// 꼬리 앞에있는 몸통으로 꼬리를 바꿈
	}
	
	public void eatApple(int row, int column) {
		moveHead(row,column);
	}

}

public class Main {
	static int N, K, L;
	static int[][] map; // 0 : 아무것도 없음, 1 : 뱀 , 2 : 사과
	static boolean isAlive = true;
	// 기본세팅이 오른쪽으로 향함.
	// 오른쪽, 아래, 왼쪽, 위 로 향해보자
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int time = 0;
	static Map<Integer, String> commands = new HashMap<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];

		// 사과 입력받기
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int column = Integer.parseInt(st.nextToken());
			map[row][column] = 2;
		}

		L = Integer.parseInt(br.readLine());

		// 회전 명령 입력받기
		for (int i = 0; i < L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			String command = st.nextToken();
			commands.put(number, command);
		}

		Snake snake = new Snake();
		snake.init(map); // 시작 좌표 설정

		// 필요한 변수들 선언
		int row, column, dir, nr, nc;

		while (isAlive) {
			time++;
			row = snake.head.row;
			column = snake.head.column;
			dir = snake.dir;

			nr = row + dr[dir];
			nc = column + dc[dir];

			
			// 범위 밖으로 벗어나면 사망
			// 내 몸에 박으면 사망
			if (!isBoundary(nr, nc) || isBody(nr,nc)) {
				isAlive = false;
				break;
			}
				

			// 사과 있을 때
			if (isApple(nr, nc)) {
				snake.eatApple(nr, nc);	// 다음 좌표에 새 몸통 만들기
			} else {
				snake.moveHead(nr,nc);	// 다음 좌표로 이동하기
				snake.moveTail();
			}
			
			if (commands.get(time) != null) {
				getCommand(snake, commands.get(time));
			}

		}


		System.out.println(time);
	}

	private static void getCommand(Snake snake, String command) {
		if (command.equals("D")) {
			// 오른쪽 90도 회전
			snake.dir = (snake.dir + 1) % 4;
		}

		if (command.equals("L")) {
			// 왼쪽 90도 회전
			snake.dir = (snake.dir + 3) % 4;
		}
	}

	private static boolean isBody(int nr, int nc) {
		return map[nr][nc] == 1;
	}

	private static boolean isApple(int nr, int nc) {
		return map[nr][nc] == 2;
	}

	private static boolean isBoundary(int nr, int nc) {
		return nr >= 1 && nr <= N && nc >= 1 && nc <= N;
	}
}
