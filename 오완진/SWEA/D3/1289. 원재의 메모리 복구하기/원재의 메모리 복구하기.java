import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        sc.nextLine();
        
        for (int tc = 1; tc <= T; tc++) {
        	
        	char[] tmpArr = sc.nextLine().toCharArray();
        	int N = tmpArr.length;
        	int[] memory = new int[N];
        	for (int n = 0; n < N; n++)
        		memory[n] = (int)(tmpArr[n] - '0');
        	int cnt = 1;
        	
        	// 뒤에서부터 0 - 1 - 0 바뀌는 순간 카운트
        	// 맨 앞이 0이면 카운트--
        	for (int n = N - 1; n > 0; n--) {
        		if (memory[n] != memory[n-1]) cnt++;
        	}
        	if (memory[0] == 0) cnt--;
        	
        	System.out.println("#" + tc + " " + cnt);
        }
    }
    
}