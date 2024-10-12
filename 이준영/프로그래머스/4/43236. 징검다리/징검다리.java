import java.util.Arrays;
class Solution {
    static int[] len;
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
		len = new int[rocks.length + 1];
		len[0] = rocks[0];
		for (int i = 1; i < rocks.length; i++) {
			len[i] = rocks[i] - rocks[i - 1];
		}
		len[rocks.length] = distance - rocks[rocks.length - 1];

		int start = 0;
		int end = distance+1;
		while (end - start > 1) {
			int mid = (start + end) / 2;
			if (check(mid, n)) {
				start = mid;
			} else {
				end = mid;
			}
		}

		return start;
    }
    public static boolean check(int mid, int n) {
		int count = 0;
		int sum = 0;
		for (int i = 0; i < len.length; i++) {
			if (sum + len[i] < mid) {
				sum = sum + len[i];
				count += 1;
			} else {
				sum = 0;
			}
		}
		if (count <= n) {
			return true;
		}
		return false;
	}
    
}