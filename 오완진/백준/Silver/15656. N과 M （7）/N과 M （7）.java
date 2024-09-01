import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] NN;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		NN = new int[N];
		
		for (int n = 0; n < N; n++)
			NN[n] = sc.nextInt();
		Arrays.sort(NN);
		
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
		
		for (int n = 0; n < N; n++) {
			pickN.add(NN[n]);
			btk(pickN);
			pickN.remove(pickN.size() - 1);
		}
		
	}
}