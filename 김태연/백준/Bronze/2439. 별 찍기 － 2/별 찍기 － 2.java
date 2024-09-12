import java.util.Scanner;

public class Main {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		

		int N = sc.nextInt();
		for (int i=0; i<N; i++) {
			for (int j = N-1; j>=0; j--) {
				// i = 0 이고 j 는 4,3,2,1,0
				if (i >= j) System.out.print("*");
				else System.out.print(" ");
			}
			System.out.println();
		}
	}
}
