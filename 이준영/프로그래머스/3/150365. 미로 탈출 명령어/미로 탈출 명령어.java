class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder sb = new StringBuilder();
		int a = compute(x, y, r, c);

		if (a > k || Math.abs(a - k) % 2 == 1) {
			return "impossible";
		}

		if (a == 0) {
			return road(x, y, r, c);
		} else {
			while (x < n && compute(x + 1, y, r, c) <= k - 1) {
				x = x + 1;
				k = k - 1;
				sb.append("d");
			}
			while (y > 1 && compute(x, y - 1, r, c) <= k - 1) {
				y = y - 1;
				k = k - 1;
				sb.append("l");
			}
			a = k - compute(x, y, r, c);
			if (a > 0) {
				if (x < n) {
					for (int i = 0; i < a / 2; i++) {
						sb.append("du");
					}
				} else if (y > 1) {
					for (int i = 0; i < a / 2; i++) {
						sb.append("lr");
					}
				} else {
					for (int i = 0; i < a / 2; i++) {
						sb.append("rl");
					}
				}
			}
			sb.append(road(x, y, r, c));
		}

		return sb.toString();
    }
    public static String road(int x, int y, int r, int c) {
		StringBuilder sb = new StringBuilder();
		if (x > r) {
			if (y < c) {
				for (int i = 0; i < c - y; i++) {
					sb.append("r");
				}
			} else {
				for (int i = 0; i < y - c; i++) {
					sb.append("l");
				}
			}
			for (int i = 0; i < x - r; i++) {
				sb.append("u");
			}
		} else {
			for (int i = 0; i < r - x; i++) {
				sb.append("d");
			}
			if (y < c) {
				for (int i = 0; i < c - y; i++) {
					sb.append("r");
				}
			} else {
				for (int i = 0; i < y - c; i++) {
					sb.append("l");
				}
			}
		}
		return sb.toString();
	}
    public static int compute(int x, int y, int r, int c) {
		return Math.abs(r - x) + Math.abs(c - y);

    }
}