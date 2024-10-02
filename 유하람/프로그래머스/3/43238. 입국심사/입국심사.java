class Solution {
    public long solution(int n, int[] times) {
		
		long L = 0;
		long R = (long) (Math.pow(10, 18));
		
		while(L<=R) {
			long mid = (L+R)/2;
			
			long cnt = 0;
			
			for(long t : times) {
				cnt += mid/t;
			}
			
			if(cnt >= n) {
				R = mid-1;
			}else {
				L = mid+1;
			}
		}
        return L;
    }
}