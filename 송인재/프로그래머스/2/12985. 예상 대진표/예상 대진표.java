class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        boolean aSmaller = a < b ? true : false;
        boolean against = aSmaller ? a % 2 == 1 && b - a == 1 : b % 2 == 1 && a - b == 1;

        while (!against) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            against = aSmaller ? a % 2 == 1 && b - a == 1 : b % 2 == 1 && a - b == 1;
            
            answer++;
        }

        return answer;
    }
}