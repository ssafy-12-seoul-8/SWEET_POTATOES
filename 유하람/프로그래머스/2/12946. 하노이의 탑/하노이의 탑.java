import java.util.List;
import java.util.ArrayList;

class Solution {
    
    public List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        
        Hanoi(n,1,3,2);
        
        int len = list.size();
        
        int[][] answer = new int[len][2];
        
        for(int i=0 ; i<len ; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public void Hanoi(int num, int from, int to, int other){
        if(num==0){
            return;
        }
        Hanoi(num-1, from, other, to);
        int[] tmp = {from,to};
        list.add(tmp);
        Hanoi(num-1, other, to, from);
               
        
    }
}