import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] NN;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		NN = new int[N];
		
		for (int n = 0; n < N; n++)
			NN[n] = sc.nextInt();
		Arrays.sort(NN);
		
		btk(0, new ArrayList<>());
	}
	
	static void btk(int start, List<Integer> pickN) {
		if(pickN.size() == M) {
			for (int num : pickN)
				System.out.print(num + " ");
			System.out.println();
			
			return;
		}
		
		for (int n = start; n < N; n++) {
			pickN.add(NN[n]);
			btk(n + 1, pickN);
			pickN.remove(pickN.size() - 1);
		}
		
	}
}