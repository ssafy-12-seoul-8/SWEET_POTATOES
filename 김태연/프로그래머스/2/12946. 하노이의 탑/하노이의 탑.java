import java.util.ArrayList;
import java.util.List;

class Solution {

    static List<int[]> list = new ArrayList<int[]>();
    
    public int[][] solution(int n) {
        int[][] answer = {};
        hanoi(1,3,n);   // 시작, 목적지, 갯수
        answer = new int[list.size()][2];
        
        for (int i=0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
     void hanoi(int start, int end, int level) {
		int other = 6 - (start+end);
         
		if (level == 1) {
			int[] arr = {start,end};
			list.add(arr);
			return;
		}
         
        hanoi(start,other,level-1);
		hanoi(start,end,1);
		hanoi(other,end,level-1);
	}
    
}