import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {

    	HashMap<String, Integer> keys = new HashMap<>();
    	int N = friends.length;
    	int[][] keyMap = new int[N][N];
    	
    	for (int i = 0; i < N; i++)
    		keys.put(friends[i], i);
    	
    	for (String gift : gifts) {
    		String gi = gift.split(" ")[0];
    		String ft = gift.split(" ")[1];
    		int giver = keys.get(gi);
    		int taker = keys.get(ft);
    		keyMap[giver][taker]++;
    	}
    	
    	// 선물지수 저장
    	int[] scores = new int[N];
    	for (int i = 0; i < N; i++) {
    		int score = 0;
    		for (int j = 0; j < N; j++) {
    			score += keyMap[i][j];
    			score -= keyMap[j][i];
    		}
    		scores[i] = score;
    	}
    	
    	// 선물의수 저장
    	int[] cnts = new int[N];
    	for (int i = 0; i < N; i++) {
    		for (int j = i + 1; j < N; j++) {
    			int cntI = keyMap[i][j];
    			int cntJ = keyMap[j][i];
    			
    			if (cntI > cntJ) cnts[i]++;
    			else if (cntJ > cntI) cnts[j]++;
    			else {
    				if (scores[i] > scores[j]) cnts[i]++;
    				else if (scores[j] > scores[i]) cnts[j]++;
    			}
    		}
    	}
    	
    	int maxCnt = 0;
    	for (int i = 0; i < N; i++)
    		maxCnt = Math.max(maxCnt, cnts[i]);
    	
    	return maxCnt;
    }
}