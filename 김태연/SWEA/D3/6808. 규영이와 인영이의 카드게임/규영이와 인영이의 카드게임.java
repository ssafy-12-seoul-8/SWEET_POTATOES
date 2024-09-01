

import java.util.Scanner;

public class Solution {

	static int[] arr;
	static int[] arr2;
	static int aCount;
	static int bCount;
	static boolean[] deck;
	static int[] power = {0, 0, 0, 0, 0, 120, 24, 6, 2, 1};
	public static void main(String[] args) {
		// 1 ~ 18 까지 있는 카드
		// 9 장씩 나눔.
		// 한 라운드에 한장씩 내고, 비교해서 점수계산
		// 높은수 : a+b 점수
		// 낮은수 : 0
		// 총점 같으면 무승부
		
		// 규영이가 내는 카드의 순서를 고정했을때
		// 인영이의 9!가지 경ㅇ에 대한 승패구하기
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <=T; test_case++) {
			aCount = 0;
			bCount = 0;
			arr = new int[9];		// 규영이 카드
			deck = new boolean[19];	// 18장의 카드가 들어있음. 인덱스 1~18까지 쓰려고 19로 만듦
			arr2 = new int[9];
			
			// 인영이 덱 채우기
			for (int i=0; i<9; i++) {
				int card = sc.nextInt();
				arr[i] = card;
				deck[card] = true;
			}
			
			// 규영이 덱 채우기
			int idx = 0;
			for (int i=1; i<19; i++) {
				if (deck[i] == false) {
					arr2[idx++] = i;
				}
			}
			// 인영이 카드는 true, 규영이 카드는 false로 마킹되어있음
			game(0 , 0, 0);
			
			System.out.println("#" + test_case + " " + aCount + " " + bCount);
			
		}
	}
	
	static void game(int Asum, int Bsum, int depth) {
//		총합 171 이므로, sum이 86 이상이면 승리.
//		if (Asum >= 86) {
//			// 뒤에껀 굳이 계산할필요없음
//			aCount += power[depth];
//			return;
//		}
//		
//		if (Bsum >= 86) {
//			bCount += power[depth];
//			return;
//		}
		
		if (depth == 9) {
			if (Asum >= Bsum) {
				aCount++;
			} else {
				bCount++;
			}
//			System.out.println("이거는 완전탐색");
			return;
		}
		
		
		// 규영이의 카드 : arr[0]
		// 인영이의 카드 : arr2[0] ~ arr2[8];
		
		for (int i=0; i<9; i++) {
			// 규영이가 이겼다면
			// deck[] 이 false 일때만 승부봐야함
			if (deck[arr2[i]] == true) continue;
			
			if (arr[depth] > arr2[i]) {
				Asum += (arr[depth]+arr2[i]);
				deck[arr2[i]] = true;
				game(Asum, Bsum, depth+1);
				deck[arr2[i]] = false;
				Asum -= (arr[depth]+arr2[i]);
			} else {
				// 인영이가 이겼다면
				Bsum += (arr[depth] + arr2[i]);
				deck[arr2[i]] = true;
				game(Asum, Bsum, depth+1);
				deck[arr2[i]] = false;
				Bsum -= (arr[depth] + arr2[i]);
			}
				
			
		}
		
		
	}
}


/*

1
1 3 5 7 9 11 13 15 17

*/