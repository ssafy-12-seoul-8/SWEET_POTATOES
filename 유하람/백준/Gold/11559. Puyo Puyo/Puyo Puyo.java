import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static char[][] field; // 게임 필드
	static int answer; // 답
	static List<int[]> list;
	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		field = new char[12][6];
		answer = 0;

		for (int i = 0; i < 12; i++) {
			String str = sc.next();
			for (int j = 0; j < 6; j++) {
				field[i][j] = str.charAt(j);
			}
		}

		list = new LinkedList<>();
		while (true) {
			boolean exploded = false;
			for (int i = 11; i >= 0; i--) { // 왼쪽 밑 부터 시작
				for (int j = 0; j < 6; j++) {
					if (field[i][j] != '.') {
						list.clear();
						char tmp = field[i][j];
						dfs(i, j, tmp, list);
						if (list.size() < 4) { // 4개 이상 인접하지 않았다면 다시 돌려놓기
							for (int[] c : list) {
								field[c[0]][c[1]] = tmp;
							}
						}else {
							exploded = true;
							
						}
					}	
				}
			}
			
			if (gravity() || exploded) { // 중력 작용하는 것이 있다면, 폭발 있었다는 것
				answer++;
			}else {
				break;
				
			}
			
		}
		


		System.out.println(answer);

	} // main

	private static void dfs(int r, int c, char puyo, List<int[]> list) {
		
		list.add(new int[] { r, c });
		field[r][c] = '.';
		
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nr < 12 && nc >= 0 && nc < 6 && field[nr][nc] == puyo) {
				dfs(nr, nc, puyo, list);
			}

		}
	}

	private static boolean gravity() {
		boolean moved = false;

		/*
		 * 포인터 두개 1. int bottom => 처음 '.'을 만난 자리 2. int row => '.' 말고 다른 뿌요가 나온 곳까지 이동,
		 * 이동 후 bottom 위치로 뿌요 옮기기 옮긴 후 bottom + 1
		 * 
		 */

		for (int c = 0; c < 6; c++) {
			int bottom = 11;
			int row = 11;

			// 시작점 찾기
			while (bottom>=0 && field[bottom][c] != '.') {
				bottom--;
				row--;
			}

			while (true) {

				while (row >= 0 && field[row][c] == '.') {
					row--;
				}

				if (row < 0)
					break; // 만약 중력 작용할 것이 없으면 break

				char tmp = field[row][c];
				field[row][c] = field[bottom][c];
				field[bottom][c] = tmp;

				bottom--;
				moved = true;

			}

		}

		return moved;
	}

}
