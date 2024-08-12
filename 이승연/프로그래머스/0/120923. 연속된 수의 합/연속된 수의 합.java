class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        int t = 0;
        
        for (int i = 1; i < num; i++) {
            t += i;
        }
        
        int x = (total - t) / num;
        
        for (int i = x, idx = 0; i < x + num; i++) {
            answer[idx++] = i;
        }
        
        return answer;
    }
}