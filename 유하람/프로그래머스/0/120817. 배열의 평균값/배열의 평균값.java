class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        double sum = 0;
        int m = 0;
        
        for(int n : numbers){
            sum += n;
            m++;
        }
        
        answer = sum/m;
        
        return answer;
    }
}