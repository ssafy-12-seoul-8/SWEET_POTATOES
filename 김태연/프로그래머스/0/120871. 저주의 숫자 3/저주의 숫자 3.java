class Solution {
    public int solution(int n) {
        int answer = 0;
        int rawNumber = 0;
        int xNumber = 0;
        
        while (rawNumber < n) {
            xNumber++;
            // xNumber가 3의 배수이거나 숫자 3을 포함하는 경우
            if (xNumber % 3 == 0 || Integer.toString(xNumber).contains("3")) {
                continue;
            }
            rawNumber++;
        }
        
        answer = xNumber;
        
        return answer;
    }
}
