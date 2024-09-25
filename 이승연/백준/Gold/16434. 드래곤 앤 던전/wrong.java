import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long maxHP = 1;
	static long currHP = 1;
	static int ATK = 1;
	static int init = 1;
	
	static int count = 0;
	static int[][] game;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		count = Integer.parseInt(st.nextToken());
		ATK = Integer.parseInt(st.nextToken());
		init = ATK;
		game = new int[count][3];
		
		for (int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			game[i] = new int[] {t, a, h};
		}
		
		long min = 1;
		long max = Long.MAX_VALUE;
		
		while(true) {
			long mid = (min + max) / 2;
			
			if (min >= max) {
				System.out.println(min);
				break;
			}
			
			ATK = init;
			maxHP = mid;
			currHP = mid;
			
			boolean isPass = true;
			
			for (int i = 0; i < count; i++) {
				int[] curr = game[i];
				
				// monster : curr[1] 공격력 curr[2] 생명력
				if (curr[0] == 1) {
					
					int monster_share = curr[2] / ATK;
					int monster_remain = curr[2] % ATK;
					long soldier_share = currHP / curr[1];
					long soldier_remain = currHP % curr[1];
					
					int monster = monster_share;
					long soldier = soldier_share;
					
					if (monster_remain != 0) { monster += 1; }
					if (soldier_remain != 0) { soldier += 1; }
					
					// 용사가 이김
					if (monster <= soldier) {
						currHP -= ((monster - 1) * curr[1]);
					// 몬스터가 이김
					} else {
						isPass = false;
						break;
					}
					
				// soldier : curr[1] 공격력 증가 curr[2] 현재 생명력 증가
				} else if (curr[0] == 2) {
					ATK += curr[1];
					currHP = Math.min(currHP + curr[2], maxHP);
				}
			}
			
			if (isPass) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
	}

}
