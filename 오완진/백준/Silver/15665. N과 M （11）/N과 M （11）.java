import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static Queue<Integer>[] NN = new Queue[10000];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		for (int n = 0; n < 10000; n++)
			NN[n] = new LinkedList<>();
		
		for (int n = 0; n < N; n++)
			NN[sc.nextInt()].add(0);
		
		btk(new ArrayList<>());
		
		System.out.println(sb);
	}
	
	static void btk(List<Integer> pickN) {
		if(pickN.size() == M) {
			for (int num : pickN)
                sb.append(num).append(" ");
            sb.append("\n");
			
			return;
		}
		
		for (int n = 0; n < 10000; n++) {
			if (!NN[n].isEmpty()) {
				pickN.add(n);
				btk(pickN);
				pickN.remove(pickN.size() - 1);
			}
		}
		
	}
}