package 문자열지옥에빠진호석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N,M,K;
	static char[][] map;
	static int[] answer;
	// 12시부터 시계방향
	static int dr[] = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int dc[] = {0, 1, 1, 1, 0, -1, -1, -1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = new int[K];
		map = new char[N][M];
		
		for (int i=0; i<N; i++) {
			String line = br.readLine();	// aaa
			for (int j=0; j<M; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		for (int time=0; time<K; time++) {
			String line = br.readLine();
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					find(i,j,line,0,time);
				}
			}
		}
		// 입력 끝.
		
		// 출력
		for (int i=0; i<K; i++) {
			sb.append(answer[i]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void find(int row,int column, String line, int index, int answerIdx) {

		
//		char letter = line.charAt(index);
//		char mapData = map[row][column];
//		if (!isSame (mapData,letter)) return;

		if (map[row][column] != line.charAt(index)) return;
		index++;
		
		// 종료조건 : 문자열 다 탐색했으면 종료한다.
		if (index == line.length()) {
			answer[answerIdx]++;
			return;
		}
		
		for (int dir = 0; dir < 8; dir ++) {
			int nr = (row + dr[dir] + N) % N;
			int nc = (column + dc[dir] + M) % M;
			find (nr, nc, line, index, answerIdx);
		}
	}

}
