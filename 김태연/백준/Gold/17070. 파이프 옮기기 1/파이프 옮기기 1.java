import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static boolean[][] map;
	static int result = 0;
	static int[] dr = {0, 1, 1};	// 3시 6시 4.5시
	static int[] dc = {1, 0, 1};
	static Queue<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new boolean[N+1][N+1];
		for (int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=1; j<=N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if (input == 1) map[i][j] = true;
			}
		}
		
		if (map[N][N]) System.out.println(0);
		else {
			bfs();
			System.out.println(result);
		}
		
	}

	private static void bfs() {
		// 시작점 (1,1) 과 (1,2)
//		Queue<int[]> queue = new LinkedList<>();
		int[] start = new int[3];
		start[0] = 1;	// head R 
		start[1] = 2; 	// head C
		start[2] = 0;	// 방향
		
		queue.add(start);
		
		while (!queue.isEmpty()) {
			
			// 현재 위치 뽑기
			int[] current = queue.poll();
			
			int row = current[0];
			int column = current[1];
			int dir = current[2];
//			System.out.println("current : " + row + " " + column + " " + dir);
			
			// 도착지점을 뽑으면 그만한다.
			if (row == N && column == N) {
//				System.out.println("도착했어");
				result++;
				continue;
			}
			
			switch (dir) {
			case 0 : 
				move(row,column,0);
				move(row,column,2);
//				customAdd(queue,move(row,column,0));
//				customAdd(queue,move(row,column,2));
				break;
			case 1 : 
				move(row,column,1);
				move(row,column,2);
//				customAdd(queue,move(row,column,1));
//				customAdd(queue,move(row,column,2));
				break;
			case 2 : 
				move(row,column,0);
				move(row,column,1);
				move(row,column,2);
//				customAdd(queue,move(row,column,0));
//				customAdd(queue,move(row,column,1));
//				customAdd(queue,move(row,column,2));
				break;
			}
		}
	}
	
	private static void move(int row, int column, int direction) {
		int[] nextSpot = new int[3];
		int nextR = row + dr[direction];
		int nextC = column + dc[direction];
		
		if (direction == 2) {
			for (int i=0; i<=2; i++) {
				nextR = row + dr[i];
				nextC = column + dc[i];
				nextSpot[0] = nextR;
				nextSpot[1] = nextC;
				nextSpot[2] = i;
				if (!canGo(nextR, nextC)) return;
			}
		} else {
			nextSpot[0] = nextR;
			nextSpot[1] = nextC;
			nextSpot[2] = direction;
			if (!canGo(nextR,nextC)) return;
		}
		queue.add(nextSpot);
//		return nextSpot;
	}
	
	private static boolean canGo(int row, int column) {
		return isBoundary(row,column) && !isWall(row,column);
	}

	private static boolean isWall(int row, int column) {
		return map[row][column];
	}

	private static boolean isBoundary(int row, int column) {
		return row >= 1 && row <= N && column >= 1 && column <= N;
	}
	
//	private static void customAdd(Queue<int[]> queue, int[] data) {
//		if (data != null) queue.add(data);
//	}


}
