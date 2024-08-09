class Solution {
    public int solution(int M, int N) {
        int answer = 0;
        
        if(M>N){
            int tmp = M;
            M = N;
            N = tmp;
        }
        
        answer = (M-1)+(N-1)*M;
        
        return answer;
    }
}