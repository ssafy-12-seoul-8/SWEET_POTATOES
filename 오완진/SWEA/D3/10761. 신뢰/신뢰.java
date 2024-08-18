import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			Queue<Character> clkBot = new LinkedList<>();
			Queue<Integer> btnBlue = new LinkedList<>();
			Queue<Integer> btnOrge = new LinkedList<>();
			
			int N = sc.nextInt();
			for (int n = 0; n < N; n++) {
				char ch = sc.next().charAt(0);
				int M = sc.nextInt();
				clkBot.offer(ch);
				if (ch == 'B') 	btnBlue.offer(M);
				else			btnOrge.offer(M);
			}
			
			int time = 0;
			int idxB = 1;
			int idxO = 1;
			
			// 클릭로봇 큐가 비어질 때까지
			while (!clkBot.isEmpty()) {
				// 1. Blue 턴
				if (clkBot.peek() == 'B') {
					int nextB = Math.abs(btnBlue.peek() - idxB);
					if (!btnOrge.isEmpty()) {						// Orge 독립 이동
						int nextO = Math.abs(btnOrge.peek() - idxO);
						if (nextB >= nextO) {						// Orge 이동완료
							idxO = btnOrge.peek();
						} else {									// Orge 이동 중
							if (btnOrge.peek() > idxO) {
								idxO += nextB;						// Blue 이동만큼 이동
								idxO++;								// Blue 버튼클릭 1초 동안 이동
							} else {
								idxO -= nextB;
								idxO--;
							}
						}
					}
					// Blue 이동 & 버튼클릭
					time += nextB;									// 이동시간 time 추가
					idxB = btnBlue.poll();							// 도착한 idx 갱신
					clkBot.poll();
					
					time++;											// 버튼클릭 time 추가
					
//					// TEST
//					System.out.println("****************************************");
//					System.out.println("time: " + time);
//					System.out.println("idxB: " + idxB);
//					System.out.println("idxO: " + idxO);
//					System.out.print("clkBot: ");
//					for (char ch : clkBot)
//						System.out.print(ch + " ");
//					System.out.println();
//					System.out.print("btnBlue: ");
//					for (int num : btnBlue)
//						System.out.print(num + " ");
//					System.out.println();
//					System.out.print("btnOrge: ");
//					for (int num : btnOrge)
//						System.out.print(num + " ");
//					System.out.println();
//					System.out.println("****************************************");
				// 2. Orge 턴
				} else {
					int nextO = Math.abs(btnOrge.peek() - idxO);
					if (!btnBlue.isEmpty()) {						// Blue 독립 이동
						int nextB = Math.abs(btnBlue.peek() - idxB);
						if (nextO >= nextB) {						// Blue 이동완료
							idxB = btnBlue.peek();
						} else {									// Blue 이동 중
							if (btnBlue.peek() > idxB) {
								idxB += nextO;						// Orge 이동만큼 이동
								idxB++;								// Orge 버튼클릭 1초 동안 이동
							} else {
								idxB -= nextO;
								idxB--;
							}
						}
					}
					// Orge 이동 & 버튼클릭
					time += nextO;									// 이동시간 time 추가
					idxO = btnOrge.poll();							// 도착한 idx 갱신
					clkBot.poll();
					
					time++;											// 버튼클릭 time 추가
					
//					// TEST
//					System.out.println("****************************************");
//					System.out.println("time: " + time);
//					System.out.println("idxB: " + idxB);
//					System.out.println("idxO: " + idxO);
//					System.out.print("clkBot: ");
//					for (char ch : clkBot)
//						System.out.print(ch + " ");
//					System.out.println();
//					System.out.print("btnBlue: ");
//					for (int num : btnBlue)
//						System.out.print(num + " ");
//					System.out.println();
//					System.out.print("btnOrge: ");
//					for (int num : btnOrge)
//						System.out.print(num + " ");
//					System.out.println();
//					System.out.println("****************************************");
				}
			}
			
			System.out.println("#" + tc + " " + time);
			
		}
	}

}