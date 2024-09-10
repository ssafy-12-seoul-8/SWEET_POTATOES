class Solution {
    public long solution(int n, int[] times) {
        int len = times.length;
		long start = 0;
		long end = 1000000000000000001L;
		while (start < end) {
			long mid = start / 2 + end / 2;
			if (start % 2 == 1 && end % 2 == 1) {
				mid += 1;
			}
			long count = 0;
			for (int i = 0; i < len; i++) {
				count = count + (mid / times[i]);
			}
			if (count >= n) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
    }
}