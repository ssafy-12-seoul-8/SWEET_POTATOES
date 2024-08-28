import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
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
			pickN.add(n+1);
			btk(n, pickN);
			pickN.remove(pickN.size() - 1);
		}
		
	}
}