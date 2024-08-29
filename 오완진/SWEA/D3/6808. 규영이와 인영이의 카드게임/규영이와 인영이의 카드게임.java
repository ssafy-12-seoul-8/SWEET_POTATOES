import java.util.Scanner;

public class Solution {
	
	static boolean[] cards;		// idx: 1 ~ 18	- 인영이의 카드덱 결정에 사용
	static boolean[] iinPicked;	// idx: 0 ~ 8	- 백트래킹 중복 선택 방지
	static int[] kyuOrder;		// idx: 0 ~ 8	- 규영이의 카드순서
	static int[] iinCard;		// idx: 0 ~ 8	- 인영이의 카드덱 (순서는 미정)
	static int[] iinOrder;		// idx: 0 ~ 8	- 인영이의 카드순서
	static int kyuWin;
	static int iinWin;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			cards = new boolean[19];
			iinPicked = new boolean[9];
			kyuOrder = new int[9];
			iinCard = new int[9];
			iinOrder = new int[9];
			kyuWin = 0;
			iinWin = 0;
			
			for (int i = 0; i < 9; i++) {
				int card = sc.nextInt();
				kyuOrder[i] = card;
				cards[card] = true;
			}
			
			int iinIdx = 0;
			for (int i = 1; i < 19; i++) {
				if (!cards[i]) iinCard[iinIdx++] = i;
			}
			
			play (0, 0, 0);
			
			System.out.println("#" + tc + " " + kyuWin + " " + iinWin);
			
		}
		
	}
	
	static void play(int iinIdx, int kyuScore, int iinScore) {
		
		if (iinIdx == 9) {
			if (kyuScore > iinScore) kyuWin++;
			else					 iinWin++;

			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (!iinPicked[i]) {
				iinPicked[i] = true;
				if (kyuOrder[i] > iinCard[iinIdx])
					play(iinIdx + 1, kyuScore + kyuOrder[i] + iinCard[iinIdx], iinScore);
				else
					play(iinIdx + 1, kyuScore, iinScore + kyuOrder[i] + iinCard[iinIdx]);
				iinPicked[i] = false;
			}
		}
		
	}
	
}
