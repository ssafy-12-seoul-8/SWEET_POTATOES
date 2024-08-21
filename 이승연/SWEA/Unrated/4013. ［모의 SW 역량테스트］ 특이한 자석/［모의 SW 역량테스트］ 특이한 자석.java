import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	static int K;
	static int MC = 4;
	static int MT = 8;
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			K = sc.nextInt();
			
			// ArrayList 2차원배열
			List<Integer>[] magnet = new ArrayList[MC];
			
			for (int i = 0; i < MC; i++) {
				magnet[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < MC; i++) {
				for (int j = 0; j < MT; j++) {
					magnet[i].add(sc.nextInt());
				}
			}
			
			for (int i = 0; i < K; i++) {
				int gear_num = sc.nextInt();
				int direction = sc.nextInt();
				
				int[] directions = getDirections(magnet, gear_num, direction);
				
				for (int d = 0; d < directions.length; d++) {
					// 순행
					if (directions[d] == 1) {
						magnet[d].add(0, magnet[d].remove(7));
					} 
					
					// 역행
					if (directions[d] == -1) {
						magnet[d].add(7, magnet[d].remove(0));
					}
				}
			}
			
			int total = 0;
			int[] t = {1, 2, 4, 8};
			
			for (int i = 0; i < MC; i++) {
				total += magnet[i].get(0) * t[i];
			}
			
			System.out.printf("#%d ", test_case);
			System.out.println(total);
			
		}
	}
	
	/*
	 * 톱니 바퀴 맞물리는 포인트
	 * 
	 * 1톱니 | 0 1 [2] 3 4 5  6  7
	 * 2톱니 | 0 1 (2) 3 4 5 [6] 7
	 * 3톱니 | 0 1 <2> 3 4 5 (6) 7
	 * 4톱니 | 0 1  2  3 4 5 <6> 7
	 * 
	 */
	
	// 기어 2차원 ArrayList, 기어 넘버, 기어 방향
	private static int[] getDirections (List<Integer>[] magnet, int gear_num, int direction) {
		int[] D = new int[4];
		
		D[gear_num - 1] = direction;
		
		switch(gear_num) {
			case 1:
				
				for (int i = 1; i < MC; i++) {
					// move (N극과 S극 && 앞 바퀴가 움직일 때)
					if ((magnet[i - 1].get(2) != magnet[i].get(6)) && D[i - 1] != 0) {
						D[i] = D[i - 1] == 1 ? -1 : 1;
					}
				}
				
				break;
			case 2:
				
				if ((magnet[0].get(2) != magnet[1].get(6))) {
					D[0] = direction == 1 ? -1 : 1;
				}
				
				if ((magnet[1].get(2) != magnet[2].get(6))) {
					D[2] = direction == 1 ? -1 : 1;
				}
				
				if ((magnet[2].get(2) != magnet[3].get(6)) && D[2] != 0) {
					D[3] = D[2] == 1 ? -1 : 1;
				}
				
				break;
			case 3:
				
				if ((magnet[1].get(2) != magnet[2].get(6))) {
					D[1] = direction == 1 ? -1 : 1;
				}
				
				if ((magnet[2].get(2) != magnet[3].get(6))) {
					D[3] = direction == 1 ? -1 : 1;
				}
				
				if ((magnet[0].get(2) != magnet[1].get(6)) && D[1] != 0) {
					D[0] = D[1] == 1 ? -1 : 1;
				}
				
				break;
			case 4:
				
				for (int i = MC - 2; i >= 0; i--) {
					// move (N극과 S극 && 앞 바퀴가 움직일 때)
					if ((magnet[i].get(2) != magnet[i + 1].get(6)) && D[i + 1] != 0) {
						D[i] = D[i + 1] == 1 ? -1 : 1;
					}
				}
				
				break;
			default:
				break;
		}
		
		return D;
	}

}
