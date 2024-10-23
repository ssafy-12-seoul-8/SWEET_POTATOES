import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Dice {
	int up = 1; // 위 <=> 밑
	int back = 2; // 뒤 <=> 앞
	int right = 3; // 오른쪽 <=> 왼쪽
	int left = 4; // 왼쪽 <=> 오른쪽
	int front = 5; // 앞 <=> 뒤
	int down = 6; // 밑 <=> 위
	int score = 0;

	// (x,y) 에서 dir 으로 돌려.
	public void turn(int dir) {
		switch (dir) {
		case 0: // 동
			turnEast();
			return;
		case 1: // 남
			turnSouth();
			return;
		case 2: // 서
			turnWest();
			return;
		case 3: // 북
			turnNorth();
			return;
		}
	}

	private void turnNorth() {
		int temp = up;
		up = front;
		front = down;
		down = back;
		back = temp;

	}

	private void turnSouth() {
		int temp = up;
		up = back;
		back = down;
		down = front;
		front = temp;

	}

	private void turnWest() {
		int temp = up;
		up = right;
		right = down;
		down = left;
		left = temp;
	}

	private void turnEast() {
		int temp = up;
		up = left;
		left = down;
		down = right;
		right = temp;
	}

}

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int N, M, K;
	// 동 남 서 북 으로 해야함. (반대방향으로 갈 일이 생겨서)
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int r = 1;
	static int c = 1;
	static int dir = 0;
	static int nr,nc;
	static int A,B;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		K = Integer.parseInt(st.nextToken()); // 이동횟수

		// 좌표 (r,c) 는 (1,1) ~ (N,M) 까지 있음.
		map = new int[N + 1][M + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 입력 완료
		
		Dice dice = new Dice();
		int result = 0;
		for (int i=0; i<K; i++) {
			move(dice);	// 1. 움직임

//			System.out.println("현재 내 좌표 : " + r + " , " + c);
			A = dice.down;	// 2. 점수 획득
			B = map[r][c];
			result += getScore(r,c);
			
			updateDir();	// 3. 이동 방향 결정
			
		}
		
		System.out.println(result);
		

	}

	private static void updateDir() {
		if (A > B) dir = (dir + 1) % 4;
		else if (A < B) dir = (dir + 3) % 4;
		// A == B 인 경우 dir 변동 없음.
	}

	private static void move(Dice dice) {
		
		// 1. 방향을 기반으로 좌표를 바꾼다.
		nr = r + dr[dir];
		nc = c + dc[dir];
		
		// 만약 다음 좌표에 칸이 없다면?
		if (!isBoundary(nr,nc)) {
			dir = (dir+2) % 4;
			// 방향 바꿔서 이동
			nr = r + dr[dir];
			nc = c + dc[dir];
		}
		
		r = nr;
		c = nc;
		dice.turn(dir);
	}

	// true : 범위 안.
	private static boolean isBoundary(int nr, int nc) {
		return nr >= 1 && nr <= N && nc >= 1 && nc <= M;
	}
	
	public static int getScore(int r, int c) {
		visited = new boolean[N+1][M+1];
		int C = findSame(r,c);
		return B * C;
	}

	private static int findSame(int row, int column) {
		
		visited[row][column] = true;
		// getScore 는 bfs 방식을 사용함 (나랑 같은 정수가 있는 곳으로만 감)
		int count = 1;
		for (int dir=0; dir<4; dir++) {
			int nr = row + dr[dir];
			int nc = column + dc[dir];
			if (!isBoundary(nr,nc) || visited[nr][nc] || map[nr][nc] != B ) continue;	// 범위 밖이거나, 방문했거나, 같은 값이 아니라면 안감.
			count += findSame(nr,nc);
		}
		
		return count;
	}

}
