import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
	static List<int[]> records = new ArrayList<>();
	
    public int[][] solution(int n) {

    	hanoi(n, 1, 3, 2);
    	
    	int N = records.size();
    	int[][] answer = new int[N][2];
    	
    	int idx = 0;
    	for (int[] record : records)
    		answer[idx++] = record;
    	
    	return answer;
    }

    void hanoi(int n, int from, int to, int tmp) {
    	if (n == 1) {
    		records.add(new int[] {from, to});
    		return;
    	}
    		
    	hanoi(n - 1, from, tmp, to);		// (n-1)개의 원판을 from -> tmp
    	records.add(new int[] {from, to});	// n번 원판을 from -> to
    	hanoi(n - 1, tmp, to, from);		// (n-1)개의 원판을 tmp -> to
    }
}