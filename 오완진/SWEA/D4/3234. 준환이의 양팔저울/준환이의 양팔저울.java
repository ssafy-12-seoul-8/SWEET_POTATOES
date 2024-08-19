import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			int N = sc.nextInt();
			int[] chu = new int[N];
			boolean[] used = new boolean[N];
			
			sum = 0;
			for (int n = 0; n < N; n++) {
				int num = sc.nextInt();
				chu[n] = num;
				sum += num;
			}
			
			cnt = 0;
			setChu(chu, used, 0, 0);
			
			System.out.println("#" + tc + " " + cnt);
		}
		
	}

	static int sum = 0;
	static int cnt = 0;
	
	static void setChu(int[] chu, boolean[] used, int sum1, int sum2) {
		
        if (sum == sum1 + sum2) {
            cnt++;
            return;
        }
		
		int N = chu.length;
		for (int n = 0; n < N; n++) {
			if (used[n]) continue;
			
			used[n] = true;
			
			setChu(chu, used, sum1 + chu[n], sum2);
			
			if (sum1 >= sum2 + chu[n])
				setChu(chu, used, sum1, sum2 + chu[n]);
			
			used[n] = false;
		}
		
	}
	
}