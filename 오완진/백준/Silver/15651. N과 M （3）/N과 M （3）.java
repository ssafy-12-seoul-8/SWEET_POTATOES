import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		btk(N, M, new ArrayList<>());
		System.out.println(sb);
	}
	
	static void btk(int N, int M, List<Integer> pickN) {
		if(pickN.size() == M) {
			for (int num : pickN)
                sb.append(num).append(" ");
            sb.append("\n");
			
			return;
		}
		
		for (int n = 0; n < N; n++) {
			pickN.add(n+1);
			btk(N, M, pickN);
			pickN.remove(pickN.size() - 1);
		}
		
	}
}