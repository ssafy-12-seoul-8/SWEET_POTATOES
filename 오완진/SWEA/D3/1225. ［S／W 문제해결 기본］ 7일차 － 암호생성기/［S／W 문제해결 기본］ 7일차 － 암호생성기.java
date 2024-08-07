import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {

			int T = sc.nextInt();
			
			Queue<Integer> amho = new LinkedList<>();
			
			for (int num = 0; num < 8; num++) {
				amho.offer(sc.nextInt());
			}
			
			outer:
			while (true) {
				int num;
				for (int i = 1; i <= 5; i++) {
					num = amho.poll();
					num -= i;
					if (num > 0) amho.offer(num);
					else {
						amho.offer(0);
						break outer;
					}
				}
			}
			
			System.out.print("#" + t + " ");
			for (int num : amho)
				System.out.print(num + " ");
			System.out.println();
		}
		
	}
}