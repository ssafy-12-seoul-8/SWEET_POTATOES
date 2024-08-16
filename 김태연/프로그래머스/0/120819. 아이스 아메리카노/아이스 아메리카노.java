class Solution {
    public int[] solution(int money) {
        int[] answer = new int[2];
        
        // 아아 5500원
        
        int amount = money / 5500;
        int change = money % 5500;
        
        answer[0] = amount;
        answer[1] = change;
        
        return answer;
    }
}