class Solution {
    public int solution(int[] common) {
        int answer = 0;
        
        int idx = common.length;
        
        if((common[1]-common[0])==(common[2]-common[1])){
            answer = common[idx-1] + (common[1]-common[0]);
        }else if((common[1]/common[0])==(common[2]/common[1])){
            answer = common[idx-1] * (common[1]/common[0]);
        }
        
        return answer;
    }
}