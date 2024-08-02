class Solution {
    public int solution(int n) {        
        int temp = 0;
        int cnt = 1;
        
        while(temp<n){
            if(cnt%3==0||String.valueOf(cnt).contains("3")){
                cnt++;
                continue;
            }
            temp++;
            cnt++;
        }

        
        
        return cnt-1;
    }
}