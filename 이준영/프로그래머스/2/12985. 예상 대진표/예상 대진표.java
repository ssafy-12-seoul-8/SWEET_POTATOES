class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        a = a-1;
        b = b-1;
        int i = 21;
        while(true) {
        	if((a&(1<<i))==(b&(1<<i))) {
        		i=i-1;
        	} else {
        		answer = i+1;
        		break;
        	}
        }

        return answer;
    }
}