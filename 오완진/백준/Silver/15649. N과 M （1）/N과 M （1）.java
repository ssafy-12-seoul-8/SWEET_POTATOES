import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[N];
		
		btk(new ArrayList<>());
	}
	
	static void btk(List<Integer> pickN) {
		if(pickN.size() == M) {
			for (int num : pickN)
				System.out.print(num + " ");
			System.out.println();
			
			return;
		}
		
		for (int n = 0; n < N; n++) {
			if (!visited[n]) {
				pickN.add(n+1);
				visited[n] = true;
				btk(pickN);
				visited[n] = false;
				pickN.remove(pickN.size() - 1);
			}
		}
		
	}
}