import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] NN;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		NN = new int[N];
		visited = new boolean[N];
		
		for (int n = 0; n < N; n++)
			NN[n] = sc.nextInt();
		Arrays.sort(NN);
		
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
				visited[n] = true;
				pickN.add(NN[n]);
				btk(pickN);
				pickN.remove(pickN.size() - 1);
				visited[n] = false;
			}
		}
		
	}
}