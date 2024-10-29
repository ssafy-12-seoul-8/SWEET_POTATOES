import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};
	
	static int W;
	static HashMap<String, Boolean>[] words, copys;
	static char[][] board;
	static boolean[][] visited;
	static int totalScore, wordCnt, longgestWordLength;
	static String longgestWord;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		
		words = new HashMap[9];
		for (int i = 1; i <= 8; i++)
			words[i] = new HashMap<>();
		
		for (int w = 0; w < W; w++) {
			String line = br.readLine();
			int i = line.length();
			words[i].put(line, false);
		}
		
		br.readLine();
		st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= TC; tc++) {
			
			board = new char[4][4];
			for (int r = 0; r < 4; r++)
				board[r] = br.readLine().toCharArray();
			
			if (tc != TC) br.readLine();
			
			copys = new HashMap[9];
			for (int i = 1; i <= 8; i++)
				copys[i] = new HashMap<>(words[i]);
			
			/* 
			 * 출력
			 * 0 0점 	1-2
			 * 1 1점 	3-4
			 * 2 2점 	5
			 * 3 3점 	6
			 * 4 5점 	7
			 * 5 11점 	8
			 * 
			 * 중복 단어 = 한 번만 카운트 ~ totalScore++ & wordCnt++
			 * copys[길이] ~ 해당 단어 찾으면 value: false -> true
			 * 가장 긴단어 : 사전 순 우선
			 * longgestWordLength 동일 ~ compareLonggestWord
			 * longgestWordLength 갱신 ~ longgestWord 등록
			 */
			
			totalScore = 0;
			wordCnt = 0;
			longgestWordLength = 0;
			longgestWord = "";
			visited = new boolean[4][4];
			
			for (int r = 0; r < 4; r++) {
				for (int c = 0; c < 4; c++) {
					visited[r][c] = true;
					btk(r, c, 1, board[r][c] + "");
					visited[r][c] = false;
				}
			}
			
			sb.append(totalScore).append(" ");
			sb.append(longgestWord).append(" ");
			sb.append(wordCnt).append("\n");
		}//tc
		
		System.out.println(sb);
	}
	
	static void btk(int rNow, int cNow, int length, String word) {
		
		if (length > 8) return;
		
		if (copys[length].containsKey(word) && !copys[length].get(word))
			calScore(length, word);
		
		for (int d = 0; d < 8; d++) {
			
			int rNext = rNow + dr[d];
			int cNext = cNow + dc[d];
			
			if (rNext < 0 || 4 <= rNext || cNext < 0 || 4 <= cNext ||
					visited[rNext][cNext]) continue;
			
			visited[rNext][cNext] = true;
			btk(rNext, cNext, length + 1, word + board[rNext][cNext]);
			visited[rNext][cNext] = false;
		}
	}
	
	static void calScore(int length, String word) {
		
		copys[length].put(word, true);
		totalScore += score[length];
		wordCnt++;
		
		if (length > longgestWordLength) {
			longgestWordLength = length;
			longgestWord = word;
		} else if (length == longgestWordLength) {
			if (longgestWord.isEmpty())
				longgestWord = word;
			else
				longgestWord = compareLonggestWord(word, longgestWord);
		}
	}
	
	// 사전 순으로 A가 B 앞이면 음수, 뒤면 양수
	static String compareLonggestWord(String A, String B) {
		
		if (A.compareTo(B) < 0)
			return A;
		else
			return B;
	}
}