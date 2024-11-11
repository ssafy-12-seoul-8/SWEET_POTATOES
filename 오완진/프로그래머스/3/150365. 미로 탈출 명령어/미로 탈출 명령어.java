class Solution {
	
	static int[] dr = {1, 0, 0, -1};
	static int[] dc = {0, -1, 1, 0};
	static char[] key = {'d', 'l', 'r', 'u'};
	static int R, C, K, sr, sc, er, ec;
	static String answer = "impossible";
	static boolean isEnd = false;
	
//	public static String solution(int n, int m, int x, int y, int r, int c, int k) {
	public String solution(int n, int m, int x, int y, int r, int c, int k) {
    	
		R = n;
		C = m;
		K = k;
		sr = x - 1;
		sc = y - 1;
		er = r - 1;
		ec = c - 1;
		
    	btk(sr, sc, 0, new StringBuilder());
    	return answer;
    }
    
    static void btk(int rNow, int cNow, int cnt, StringBuilder sb) {
    	
//    	System.out.println(rNow + "|" + cNow + "|" + cnt + "\t|" + isEnd + "|" + sb.toString());
    	
    	if (cnt > K || isEnd) return;
    	
    	if (rNow == er && cNow == ec && cnt == K) {
    		answer = sb.toString();
    		isEnd = true;
    		return;
    	}
    	
    	for (int d = 0; d < 4; d++) {
    		
    		int rNext = rNow + dr[d];
    		int cNext = cNow + dc[d];
    		
    		if (rNext < 0 || R <= rNext || cNext < 0 || C <= cNext ||
    			!continueBtk(rNext, cNext, cnt + 1)) continue;
    		
    		sb.append(key[d]);
    		btk(rNext, cNext, cnt + 1, sb);
    		sb.deleteCharAt(sb.length() - 1);
    	}
    }
    
    static boolean continueBtk(int rNow, int cNow, int cnt) {
    	
    	int remains = Math.abs(er - rNow) + Math.abs(ec - cNow);
    	
    	if (remains + cnt > K)
    		return false;
    	
    	return (remains + (K - cnt)) % 2 == 0;
    }
}