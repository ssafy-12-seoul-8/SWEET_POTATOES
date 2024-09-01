import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int[] kyuOrder;
	static int[] iinCards;
	static boolean[] visited;
	static List<Integer> iinOrder;
	static int kyuWin, iinWin;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			kyuOrder = new int[9];
			iinCards = new int[9];
			visited = new boolean[9];
			iinOrder = new ArrayList<>();
			kyuWin = 0;
			iinWin = 0;
			boolean[] cardCheck = new boolean[19];
			
			for (int i = 0; i < 9; i++) {
				int card = sc.nextInt();
				kyuOrder[i] = card;
				cardCheck[card] = true;
			}
			
			int iinIdx = 0;
			for (int i = 1; i < 19; i++)
				if (!cardCheck[i])
					iinCards[iinIdx++] = i;
			
			btk(0, 0);
			
			System.out.println("#" + tc + " " + kyuWin + " " + iinWin);
		}
		
	}
	
	static void btk(int kyuScore, int iinScore) {
		if (iinOrder.size() == 9) {
			if (kyuScore > iinScore) kyuWin++;
			else					 iinWin++;
			
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				iinOrder.add(iinCards[i]);
				if (kyuOrder[iinOrder.size() - 1] > iinOrder.get(iinOrder.size() - 1))
					btk(kyuScore + kyuOrder[iinOrder.size() - 1] + iinOrder.get(iinOrder.size() - 1), iinScore);
				else
					btk(kyuScore, iinScore + kyuOrder[iinOrder.size() - 1] + iinOrder.get(iinOrder.size() - 1));
				iinOrder.remove(iinOrder.size() - 1);
				visited[i] = false;
			}
		}
	}
	
}
