class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        
        int s;
        int e;
        char temp;
        
        char[] array = new char[my_string.length()];
        
        // 문자열을 배열로 옮김.
        for (int i=0; i<my_string.length(); i++) {
        	array[i] = my_string.charAt(i);
        }
        
        // 예시에서는 i < 4, 총 4번 반복
        for (int i=0; i<queries.length; i++) {
        	// query 에서 s,e 값 추출
        	// 먼저 첫번째 i 에서는 s = 2, e = 3
        	s = queries[i][0];
        	e = queries[i][1];
        	int sIdx = s;
        	int eIdx = e;
        	
            for (int j=s; j <= s + (e-s)/2; j++) {
                temp = array[sIdx];
                array[sIdx] = array[eIdx];
                array[eIdx] = temp;
                sIdx++;
                eIdx--;
            }
        }
        
        // 결과 출력
        for (int i=0; i<array.length; i++) {
        	answer += array[i];
        }
        
        return answer;
    }
}