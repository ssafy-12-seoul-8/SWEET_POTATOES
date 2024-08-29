import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static Queue<Integer>[] NN;				// 기존 visited 상위호환

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		NN = new Queue[10000];
		for (int i = 0; i < 10000; i++)
			NN[i] = new LinkedList<>();
		
		for (int n = 0; n < N; n++) {
			int num = sc.nextInt();
			NN[num].add(0);					// 의미없는 0임
		}
		
		btk(new ArrayList<>());
		
	}
	
	static void btk(List<Integer> pickN) {
		if (pickN.size() == M) {
			for (int num : pickN)
				System.out.print(num + " ");
			System.out.println();
			
			return;
		}
		
		for (int n = 0; n < 10000; n++) {
			if (!NN[n].isEmpty()) {
				NN[n].poll();
				pickN.add(n);
				btk(pickN);
				pickN.remove(pickN.size() - 1);
				NN[n].add(0);
			}
		}
	}
	
}
