import java.util.*;

class Solution {
    public static int solution(int n, int[] tops) {
        int[] count = new int[n];
        int[] add = new int[n];
        
        count[0] = tops[0] == 1 ? 4 : 3;
        add[1] = tops[0] == 1 ? 3 : 2;
        count[1] = count[0] * (2 + tops[1]) + add[1];
        
        for (int i = 2; i < n; i++) {
            add[i] = count[i - 2] * (1 + tops[i - 1]) + add[i - 1];
            count[i] = count[i - 1] * (2 + tops[i]) + add[i];
            count[i] %= 10007;
        }
        
        return count[n - 1];
    }
}