import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static char[][] map;
    static Map<String, Integer> answerSheet;
    static List<String>[] lengthArray;
    static boolean[][] visited;
    // 12시부터 시계방향
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    static int maxScore = 0;
    static String longestWord = "";
    static int count = 0;
    static boolean isFound;
    static int lengthIndex = 0;
    
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());
        String[] dictionary = new String[w];
        StringBuilder sb = new StringBuilder();
        // w는 1 ~ 300,000

        for (int i = 0; i < w; i++) {
            String word = br.readLine();
            dictionary[i] = word;
        }
        // 단어사전 입력 완료

        br.readLine(); // 개행
        // 보글보드의 개수 b
        int b = Integer.parseInt(br.readLine());
        // b <= 30
        for (int test_case = 0; test_case < b; test_case++) {
            isFound = false;

            answerSheet = new HashMap<>();
            maxScore = 0;
            longestWord = "";
            count = 0;
            lengthIndex = 0;
            
            // 길이에 따라 다른 배열을 만들어야 할것같음.
            lengthArray = new ArrayList[9];
            for (int i=1; i<=8; i++) {
            	lengthArray[i] = new ArrayList<>();
            }
            
            
            // 4줄에 걸쳐 주어짐
            map = new char[4][4];
            for (int i = 0; i < 4; i++) {
                String board = br.readLine();
                for (int j = 0; j < 4; j++) {
                    map[i][j] = board.charAt(j);
                }
            }
            br.readLine();
            // 입력 끝
            
            // 단어를 하나씩 찾아보자.
            for (int i=0; i<w; i++) {
                String word = dictionary[i];
                visited = new boolean[4][4];
                boggle(word);
                isFound = false;
            }
            
            Collections.sort(lengthArray[lengthIndex]);
            longestWord = lengthArray[lengthIndex].get(0);
            sb.append(maxScore).append(" ").append(longestWord).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void boggle(String word) {
        // 단어를 찾기.
        for (int row=0; row<4; row++) {
            for (int column=0; column<4; column++) {
                // 모든 (i,j) 에서, 첫 자가 다르면 스킵.
//            	visited = new boolean[4][4];
                if (map[row][column] != word.charAt(0)) continue;
                if (answerSheet.get(word) == null) {
                	visited[row][column] = true;
                    dfs(word, row, column, 0);
                    visited[row][column] = false;
                }
            }
        }
    }

    
    
    private static void dfs(String word, int row, int column, int index) {
        
    	// 기저조건 설정.
    	// word 의 길이와 현재 찾는 index가 같으면 멈춘다.
    	if (isFound) return;
    	
    	if (word.length() -1 == index) {
            isFound = true;
            scoreUp(word);
            fetchLongestWord(word);
            count++;
            answerSheet.put(word, 1);
            lengthArray[word.length()].add(word);
            lengthIndex = Math.max(lengthIndex, word.length());
    		return;
    	}
    	
            for (int dir=0; dir<8; dir++) {
                int nr = row + dr[dir];
                int nc = column + dc[dir];
                char nextLetter = word.charAt(index + 1);
                
                // 범위 밖이거나, 이미 방문했다면
                if (!isBoundary(nr,nc) || visited[nr][nc]) continue;
                
                // 다음 글자가 index번째 글자일때만 실행
                if (map[nr][nc] == nextLetter) {
                	visited[nr][nc] = true;
                	dfs(word, nr, nc, index+1);
                	visited[nr][nc] = false;
                }
            }
            
        }
        
        
    
    private static void fetchLongestWord(String word) {
    	if (word.length() > longestWord.length()) {
    		longestWord = word;
    	}
	}

	private static void scoreUp(String word) {
		switch(word.length()) {
		case 1 : case 2 :
			break;
		case 3 : case 4 :
			maxScore += 1;
			break;
		case 5 : 
			maxScore += 2;
			break;
		case 6 : 
			maxScore += 3;
			break;
		case 7 : 
			maxScore += 5;
			break;
		case 8 :
			maxScore += 11;
			break;
		}
		
	}

	private static boolean isBoundary(int row, int column) {
        return row >= 0 && row < 4 && column >= 0 && column < 4;
    }
}
