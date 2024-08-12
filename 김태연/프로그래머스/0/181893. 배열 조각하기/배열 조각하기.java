import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};
        
        
        // 쿼리길이만큼, 예를 들어 쿼리 길이가 3이면 0,1,2 해서 총 3번 실행
        
        for (int i=0; i<query.length; i++) {
        	
            // 짝수 인덱스 : 뒷부분을 자른다
            if (i % 2 == 0) {
                // arr[] 배열울 query[0] 번 까지만 남김. (뒷부분을 삭제함)
//                System.out.println("짝수의 경우 i값 : " + i);
//                System.out.println("변환 전 arr : " + Arrays.toString(arr));
                int[] evenArr = new int[query[i] + 1];		// 4번까지 살리니까, 길이는 5임
                // evenArr 에 arr 복사 (query[0]번까지)
                for (int j=0; j<evenArr.length; j++) {
                    evenArr[j] = arr[j];
                }
                arr = evenArr;
//                System.out.println("evenArr : " + Arrays.toString(evenArr));
//                System.out.println("arr : " + Arrays.toString(arr));
                
            } else { // 홀수 인덱스
//            	System.out.println("홀수의 경우 i값 : " + i);
                // arr[] 배열을 query[i] 번 부터 시작함. (앞부분을 삭제함)
//            	System.out.println("변환 전 arr : " + Arrays.toString(arr));
                int[] oddArr = new int[arr.length - query[i]];	// 길이는 맞음.
                
                //query[1] = 1;
                // j = 1;
                for (int j=0; j<oddArr.length; j++) {
                    oddArr[j] = arr[query[i]++];
                    // oddArr[0] = arr[query[1]]
                }
                arr = oddArr;
//                System.out.println("oddArr : " + Arrays.toString(oddArr));
//                System.out.println("arr : " + Arrays.toString(arr));
            }
        }
        
        answer = arr;
        
        return answer;
    }
}