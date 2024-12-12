import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt(); // 커피 가격 (1<=X<=10000)

		// 동전 종류
		int[] coin = { 1, 5, 10, 25 };

		// 동전 개수 (0<=A,B,C,D<=1,0000)
		int[] cnt = new int[4];

		for (int i = 0; i < 4; i++) {
			cnt[i] = sc.nextInt();
		}

		// 각 가격을 채우기 위해 사용한 동전의 최대 개수 저장
		// 1원, 5원, 10원, 25원, 총 개수
		int[][] DP = new int[X + 1][5];
		for(int i=1 ; i<=X ; i++) {
			DP[i][4] = -1;
		}
		
		for (int p = 1; p <= X; p++) {
			for (int i = 0; i < 4; i++) {
				if (p >= coin[i]) {
					if(DP[p-coin[i]][4]!=-1 && DP[p-coin[i]][i] < cnt[i] && DP[p-coin[i]][4]+1 > DP[p][4]) {
						DP[p][0] = DP[p-coin[i]][0];
						DP[p][1] = DP[p-coin[i]][1];
						DP[p][2] = DP[p-coin[i]][2];
						DP[p][3] = DP[p-coin[i]][3];
						DP[p][i]++;
						DP[p][4] = DP[p-coin[i]][4]+1;
					}
				}
			}
		}
		
		System.out.println(DP[X][0]+" "+DP[X][1]+" "+DP[X][2]+" "+DP[X][3]);

	} // main

} // Main class
