import java.util.LinkedList;
import java.util.Queue;

class Solution {
	
	static int N, W, targetIdx;
	
    public int solution(String sString, String tString, String[] words) {
    	
    	N = words.length;
    	W = sString.length();
    	targetIdx = -1;
    	
        for (int n = 0; n < N; n++)
            if (words[n].equals(tString))
                targetIdx = n;
    	
    	if (targetIdx == -1)
    		return 0;
    	
    	Queue<int[]> bfs = new LinkedList<>();
    	boolean[] visited = new boolean[N];
    	
    	bfs.add(new int[] {-1, 0});
    	
    	while (!bfs.isEmpty()) {
    		
    		int[] now = bfs.poll();
    		int nowIdx = now[0];
    		int cnt = now[1];
    		
            if (nowIdx == -1) {
                for (int nextIdx = 0; nextIdx < N; nextIdx++) {
                    
                	if (check(sString, words[nextIdx])) {
                    	
                        bfs.add(new int[] {nextIdx, cnt + 1});
                        visited[nextIdx] = true;
                    }
                }
                
            } else if (nowIdx == targetIdx) {
                return cnt;
                
            } else {
                for (int nextIdx = 0; nextIdx < N; nextIdx++) {

                	if (visited[nextIdx]) continue;
                    
                    if (check(words[nowIdx], words[nextIdx])) {
                        bfs.add(new int[] {nextIdx, cnt + 1});
                        visited[nextIdx] = true;
                    }
                }
            }
    	}
    	
    	return 0;
    }
    
    static boolean check(String word1, String word2) {
    	
    	int cnt = 0;
    	for (int w = 0; w < W; w++)
    		if (word1.charAt(w) != word2.charAt(w))
    			cnt++;
    	
    	return cnt == 1;
    }
}