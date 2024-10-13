import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int max = 0;
		int len = str.length();

		int r_count = 0;
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) == 'R') {
				r_count += 1;
			}
		}
		if (len == 0) {
			System.out.println(0);
		} else {
			int start = 0;
			int end = len - 1;
			int left = 0;
			int right = 0;
			while (start<len && str.charAt(start) == 'K') {
				start += 1;
				left += 1;
			}
			while (end>=0 && str.charAt(end) == 'K') {
				end -= 1;
				right += 1;
			}
			if (start > end) {
				System.out.println(0);
			} else {
				max = Math.max(max, r_count + 2 * Math.min(left, right));
				while (r_count > 0) {
					if (left < right) {
						while (start <= end && str.charAt(start) == 'R') {
							r_count -= 1;
							start += 1;
						}
						while (start <= end && str.charAt(start) == 'K') {
							start += 1;
							left += 1;
						}
					} else {
						while (start <= end && str.charAt(end) == 'R') {
							r_count -= 1;
							end -= 1;
						}
						while (start <= end && str.charAt(end) == 'K') {
							end -= 1;
							right += 1;
						}
					}
					max = Math.max(max, r_count + 2 * Math.min(left, right));
				}
				System.out.println(max);

			}
		}

	}
}
