class Solution {
    public int[] solution(int[] num_list) {
        
        int len = num_list.length;
        int[] answer = new int[len];
        
        for(int i=0 ; i<len ; i++){
            answer[i] = num_list[len-i-1];
        }

        return answer;
    }
}