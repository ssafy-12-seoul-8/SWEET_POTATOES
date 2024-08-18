class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = {};
        int[] result = new int[queries.length];
        
        for (int q = 0; q < queries.length; q++) {
            int s = queries[q][0]; // 시작 인덱스
            int e = queries[q][1]; // 끝 인덱스
            int k = queries[q][2]; // 기준 값
            
            int min = Integer.MAX_VALUE; // 인티져 맥스밸류(강사님스타일로)
            boolean found = false; // k보다 큰 값이 있는가?
            
            // s부터 e까지의 배열 요소를 순회
            for (int i = s; i <= e; i++) {
                
                if (arr[i] > k && arr[i] < min) {
                    min = arr[i]; // min 갱신
                    found = true; 
                }
            }
        
           
            if (found) result[q] = min;
            else result[q] = -1;
                
        }
        
        answer = result;
        return answer;
    }
}