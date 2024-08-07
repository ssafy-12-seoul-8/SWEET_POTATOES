class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        
        int[] query = new int[2];
        // queries : 2차원 배열
        
        int x,y,temp;
        for (int i=0; i<queries.length; i++) {
            // i = 0 일 때 
            x = queries[i][0];      // 예를 들면 queries[0][0] = 0
            y = queries[i][1];      // 예를 들면 queries[0][1] = 3
            temp = arr[x];
            arr[x] = arr[y];        // arr[0] = arr[3]
            arr[y] = temp;        // arr[3] = temp
        }
        
        
        answer = arr;
        
        return answer;
    }
}